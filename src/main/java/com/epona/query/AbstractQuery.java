package com.epona.query;


import org.apache.hadoop.hbase.TableName;

public abstract class AbstractQuery {

  protected TableName getTable() {
    return TableName.valueOf(getTableName());
  }

  private String getTableName() {
    String name = extractTableName();
    validateTableName(name);
    return name;
  }

  private String extractTableName() {
    Class<PutQuery> object = PutQuery.class;
    EponaQuery eponaQuery = (EponaQuery) object.getAnnotation(EponaQuery.class);
    return eponaQuery.name();
  }

  private void validateTableName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException("Interface EponaSquery needs to have parameter: name");
    }
  }

}
