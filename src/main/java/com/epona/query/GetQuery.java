package com.epona.query;


import com.epona.configuration.EponaConfig;
import com.epona.model.GetDescription;
import com.epona.model.PutDescription;
import com.epona.util.EponaUtil;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.List;

public abstract class GetQuery<T> {

  public T execute(String rowKey) {

    T result = null;
    Table table = null;

    try {
      Connection connection = EponaConfig.getHBaseConnection();
      Get get = prepareGet(rowKey);
      table = connection.getTable(getTable());
      Result r = table.get(get);
      result = parseResult(r);

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      EponaUtil.closeSilently(table);
    }

    return result;
  }

  private TableName getTable() {
    return TableName.valueOf(getTableName());
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

  protected abstract String getTableName();

  protected abstract T parseResult(Result r);

}
