package com.epona.configuration;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;


public class EponaConfig {

  private static Connection connection;

  public static Connection getHBaseConnection() {
    if (connection == null) {
      Configuration config = HBaseConfiguration.create();
      //config.set("hbase.zookeeper.quorum", "localhost");
      try {
        connection = ConnectionFactory.createConnection(config);
      } catch (IOException e) {
        throw new HBaseConnectionException();
      }
    }
    return connection;
  }

}
