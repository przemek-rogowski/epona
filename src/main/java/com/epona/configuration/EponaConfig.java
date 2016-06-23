package com.epona.configuration;

import com.epona.util.EponaUtil;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class EponaConfig {

  private static Configuration configuration;

  public static Connection getHBaseConnection() {
    if (configuration == null) {
      throw new IllegalArgumentException("Configuration can not be null. First you need to configure connection.");
    }
    try {
      return ConnectionFactory.createConnection(configuration);
    } catch (IOException e) {
      throw new HBaseConnectionException("Connection to the HBase couldn't be established");
    }
  }

  public static void configure(Configuration config) {
    if (config == null) {
      throw new IllegalArgumentException("Configuration can not be null");
    }
    configuration = config;
  }

  public static void clearConfiguration() {
    configuration = null;
  }

  public static Configuration getConfiguration() {
    return configuration;
  }

}
