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

  public static final String ZOOKEEPER_ADDRESS = "hbase.zookeeper.quorum";
  public static final String EPONA_CONFIG_FILE = "epona-config.properties";

  private static Connection connection;

  public static Connection getHBaseConnection() {
    Configuration config = HBaseConfiguration.create();
    Properties properties = loadProperties();
    config.set(ZOOKEEPER_ADDRESS, properties.getProperty(ZOOKEEPER_ADDRESS));
    try {
      return ConnectionFactory.createConnection(config);
    } catch (IOException e) {
      throw new HBaseConnectionException("Connection to the HBase couldn't be established");
    }
  }

  public static Properties loadProperties() {

    Properties properties = new Properties();
    InputStream input = null;

    try {
      input = Thread.currentThread().getContextClassLoader().getResourceAsStream(EPONA_CONFIG_FILE);
      properties.load(input);

    } catch (IOException ex) {
      ex.printStackTrace();
    } finally {
      EponaUtil.closeSilently(input);
    }

    return properties;
  }

}
