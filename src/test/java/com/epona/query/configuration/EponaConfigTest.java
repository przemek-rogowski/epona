package com.epona.query.configuration;

import com.epona.configuration.EponaConfig;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EponaConfigTest {

  @Test(expected = IllegalArgumentException.class)
  public void shouldFailWhenTriesToConfigureWithNull() throws Exception {
    // given
    Configuration config = null;

    // when
    EponaConfig.configure(config);

    // then
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldFailIfConnectionWasNotConfigured() throws Exception {
    // given

    // when
    EponaConfig.getHBaseConnection();

    // then
  }

  @Test
  public void shouldAcceptConfiguration() throws Exception {
    // given
    Configuration config = HBaseConfiguration.create();
    config.set("hbase.zookeeper.quorum", "10.10.23.23:2812");

    // when
    EponaConfig.configure(config);

    // then
    Configuration configuration = EponaConfig.getConfiguration();
    assertThat(configuration).isNotNull();
    assertThat(configuration.get("hbase.zookeeper.quorum")).isEqualTo("10.10.23.23:2812");
  }

  @Test
  public void shouldClearConfiguration() throws Exception {
    // given
    Configuration config = HBaseConfiguration.create();
    config.set("hbase.zookeeper.quorum", "10.10.23.23:2812");
    EponaConfig.configure(config);

    // when
    EponaConfig.clearConfiguration();

    // then
    Configuration configuration = EponaConfig.getConfiguration();
    assertThat(configuration).isNull();
  }
}
