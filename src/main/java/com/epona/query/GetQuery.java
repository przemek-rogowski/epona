package com.epona.query;


import com.epona.configuration.EponaConfig;
import com.epona.model.GetDescription;
import com.epona.parser.ResultParser;
import com.epona.util.EponaUtil;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.List;

public abstract class GetQuery<T> extends AbstractQuery {

  /***
   *
   * @param rowKey key of the row in the HBase
   * @return value from the HBase database, if the value does't exist it will return null
   */
  public T execute(String rowKey) {

    T value = null;
    Table table = null;
    Connection connection = null;

    try {
      connection = EponaConfig.getHBaseConnection();
      Get get = prepareGet(rowKey);
      table = connection.getTable(getTable());
      Result result = table.get(get);
      value = getParser().parse(result);

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      EponaUtil.closeSilently(table);
      EponaUtil.closeSilently(connection);
    }

    return value;
  }

  private Get prepareGet(String rowKey) {
    List<GetDescription> descriptions = prepareGetDescription();

    Get get = new Get(Bytes.toBytes(rowKey));
    for (GetDescription description : descriptions) {
      get.addColumn(Bytes.toBytes(description.getFamily()),
          Bytes.toBytes(description.getQualifier()));
    }
    return get;
  }

  protected abstract List<GetDescription> prepareGetDescription();

  protected abstract ResultParser<T> getParser();

}
