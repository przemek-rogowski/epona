package com.epona.query.configuration;

import com.epona.configuration.EponaConfig;
import org.apache.hadoop.hbase.client.Connection;
import org.junit.Test;

import java.util.Properties;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class EponaConfigTest {

  @Test
  public void shouldLoadProperties() throws Exception {
    // given

    // when
    Properties properties = EponaConfig.loadProperties();

    // then
    assertThat(properties.get(EponaConfig.ZOOKEEPER_ADDRESS)).isEqualTo("localhost");
  }
}
