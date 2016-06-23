package com.epona.query.configuration;


import com.epona.configuration.EponaConfig;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;

public class EponaConfiguration {

  public void configure() {
    // Creating hbase configuration
    Configuration configuration = HBaseConfiguration.create();

    // Setting parameters
    configuration.set("hbase.zookeeper.quorum", "10.10.23.23");

    // Passing configuration to Epona. Should be done at the beginning and only once.
    EponaConfig.configure(configuration);
  }

}
