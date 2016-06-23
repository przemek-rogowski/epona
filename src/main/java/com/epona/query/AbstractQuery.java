package com.epona.query;


import org.apache.hadoop.hbase.TableName;

import java.lang.annotation.Annotation;


public abstract class AbstractQuery {

  protected TableName getTable() {
    return TableName.valueOf(getTableName());
  }

  private String getTableName() {
    String tableName = extractTableName();
    validateTableName(tableName);
    return tableName;
  }

  private String extractTableName() {
    for (Annotation annotation : getClass().getAnnotations()) {
      EponaQuery eponaQuery = (EponaQuery) annotation;
      if (eponaQuery != null)
        return eponaQuery.tableName();
    }
    return null;
  }

  private void validateTableName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException("Interface EponaSquery needs to have parameter: name");
    }
  }

}
