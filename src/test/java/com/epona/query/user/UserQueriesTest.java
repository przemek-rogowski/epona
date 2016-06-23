package com.epona.query.user;


import com.epona.configuration.EponaConfig;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.junit.Before;
import org.junit.Test;

public class UserQueriesTest {

  private UserPutQuery userPutQuery;
  private UserGetQuery userGetQuery;
  private UserDeleteQuery userDeleteQuery;

  @Before
  public void setup() {
    userPutQuery = new UserPutQuery();
    userGetQuery = new UserGetQuery();
    userDeleteQuery = new UserDeleteQuery();
  }

  @Test
  public void testUserQueries() throws Exception {

    // Configuring the Epona
    Configuration configuration = HBaseConfiguration.create();
    configuration.set("hbase.zookeeper.quorum", "10.10.23.23");
    EponaConfig.configure(configuration);

    // creating object
    User user = new User("Some", "Guy", 32, true);
    String rowKey = user.getName() + "::" + user.getSurname();

    // Storing data
    userPutQuery.execute(rowKey, user);

    // Getting data
    User storedUser = userGetQuery.execute(rowKey);

    // Delete user
    userDeleteQuery.execute(rowKey);

  }
}
