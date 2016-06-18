package com.epona.parser;

import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

public abstract class ResultParser<T> {

  private Result result;

  public abstract T parse();

  public T parse(Result result) {
    this.result = result;
    return parse();
  }

  protected String getString(String family, String qualifier) {
    return Bytes.toString(result.getValue(Bytes.toBytes(family), Bytes.toBytes(qualifier)));
  }

  protected int getInt(String family, String qualifier) {
    return Bytes.toInt(result.getValue(Bytes.toBytes(family), Bytes.toBytes(qualifier)));
  }

  protected boolean getBoolean(String family, String qualifier) {
    return Bytes.toBoolean(result.getValue(Bytes.toBytes(family), Bytes.toBytes(qualifier)));
  }

  protected float getFloat(String family, String qualifier) {
    return Bytes.toFloat(result.getValue(Bytes.toBytes(family), Bytes.toBytes(qualifier)));
  }

  protected double getDouble(String family, String qualifier) {
    return Bytes.toDouble(result.getValue(Bytes.toBytes(family), Bytes.toBytes(qualifier)));
  }

}
