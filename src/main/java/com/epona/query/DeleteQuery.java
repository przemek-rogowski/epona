package com.epona.query;


import com.epona.configuration.EponaConfig;
import com.epona.model.DeleteDescription;
import com.epona.util.EponaUtil;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.List;

public abstract class DeleteQuery extends AbstractQuery {

  public void execute(String rowKey) {

    Table table = null;
    Connection connection = null;

    try {
      connection = EponaConfig.getHBaseConnection();
      Delete delete = prepareDelete(rowKey);
      table = connection.getTable(getTable());
      table.delete(delete);

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      EponaUtil.closeSilently(table);
      EponaUtil.closeSilently(connection);
    }
  }

  private Delete prepareDelete(String rowKey) {
    List<DeleteDescription> descriptions = prepareDeleteDescription();
    Delete delete = new Delete(Bytes.toBytes(rowKey));
    for (DeleteDescription description : descriptions) {
      delete.addColumn(Bytes.toBytes(description.getFamily()),
          Bytes.toBytes(description.getQualifier()));
    }
    return delete;
  }

  protected abstract List<DeleteDescription> prepareDeleteDescription();
}
