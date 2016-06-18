package com.epona.query;


import com.epona.configuration.EponaConfig;
import com.epona.model.PutDescription;
import com.epona.util.EponaUtil;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.List;

public abstract class PutQuery<T> {

  /***
   *
   * Saves vaues inside the hbase row
   *
   * @param rowKey key of the row in the HBase
   * @param value the value that we would like to save in the row
   * @return rowKey of the modified row, if the value where not save it will return null
   *
   */
  public String execute(String rowKey, T value) {

    Table table = null;
    List<PutDescription> putDescriptions = preparePutDescription(value);

    try {
      Connection connection = EponaConfig.getHBaseConnection();
      Put put = preparePut(rowKey, putDescriptions);
      table = connection.getTable(getTable());
      table.put(put);
      return rowKey;

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      EponaUtil.closeSilently(table);
    }

    return null;
  }

  private TableName getTable() {
    return TableName.valueOf(getTableName());
  }

  private Put preparePut(String rowKey, List<PutDescription> descriptions) {
    Put put = new Put(Bytes.toBytes(rowKey));
    for (PutDescription description : descriptions) {
      put.addColumn(Bytes.toBytes(description.getFamily()),
          Bytes.toBytes(description.getQualifier()),
          Bytes.toBytes(description.getValue()));
    }
    return put;
  }

  protected abstract List<PutDescription> preparePutDescription(T value);

  protected abstract String getTableName();

}
