# Epona

This is a java library that can effectively help in work with HBase. It will allows you to create queries to perform basic operation on your entities.
This library is a wrapper for the hbase-client. The implementations should be compatible from the version 1.0.0. 
http://mvnrepository.com/artifact/org.apache.hbase/hbase-client/1.2.1

CONTRIBUTION
If you would like to participate in creating of the Epona library, please send me en email on przemyslavr@gmail.com


CONFIGURATION
We want to leave freedom in configuring to users of Epona so configuration was implemented on the base of the class from hbase-client library
http://hbase.apache.org/apidocs/org/apache/hadoop/hbase/HBaseConfiguration
https://mvnrepository.com/artifact/org.apache.hbase/hbase-client/1.2.1


``` java

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

```


Example of GET operation

``` java

import com.epona.model.GetDescription;
import com.epona.parser.ResultParser;
import com.epona.query.EponaQuery;
import com.epona.query.GetQuery;

import java.util.Arrays;
import java.util.List;

import static com.epona.model.GetDescriptionBuilder.getDescription;

@EponaQuery(name = "User")
public class UserGetQuery extends GetQuery<User> {

  @Override
  protected ResultParser<User> getParser() {
    return new ResultParser<User>() {

      public User parse() {
        String name = getString("personal", "name");
        String surname = getString("personal", "surname");
        int age = getInt("personal", "age");
        boolean isMan = getBoolean("personal", "is_man");

        return new User(name, surname, age, isMan);
      }
    };
  }

  @Override
  protected List<GetDescription> prepareGetDescription() {
    return Arrays.asList(
        getDescription()
            .setFamily("personal")
            .setQualifier("name")
            .build(),
        getDescription()
            .setFamily("personal")
            .setQualifier("surname")
            .build(),
        getDescription()
            .setFamily("personal")
            .setQualifier("age")
            .build(),
        getDescription()
            .setFamily("personal")
            .setQualifier("is_man")
            .build()
    );
  }
}

```

Example of PUT operation

``` Java

import com.epona.model.PutDescription;
import com.epona.query.EponaQuery;
import com.epona.query.PutQuery;

import java.util.Arrays;
import java.util.List;

import static com.epona.model.PutDescriptionBuilder.putDescription;

@EponaQuery(name = "User")
public class UserPutQuery extends PutQuery<User> {

  @Override
  protected List<PutDescription> preparePutDescription(User user) {
    return Arrays.asList(
        putDescription()
            .setFamily("personal")
            .setQualifier("name")
            .setValue(user.getName())
            .build(),
        putDescription()
            .setFamily("personal")
            .setQualifier("surname")
            .setValue(user.getSurname())
            .build(),
        putDescription()
            .setFamily("personal")
            .setQualifier("age")
            .setValue(String.valueOf(user.getAge()))
            .build(),
        putDescription()
            .setFamily("personal")
            .setQualifier("is_man")
            .setValue(String.valueOf(user.isMan()))
            .build()
    );
  }

}

```

Example of DELETE operation

``` Java

import com.epona.model.DeleteDescription;
import com.epona.query.DeleteQuery;
import com.epona.query.EponaQuery;

import java.util.Arrays;
import java.util.List;

import static com.epona.model.DeleteDescriptionBuilder.deleteDescription;

@EponaQuery(name = "User")
public class UserDeleteQuery extends DeleteQuery {

  @Override
  protected List<DeleteDescription> prepareDeleteDescription() {
    return Arrays.asList(
        deleteDescription()
            .setFamily("personal")
            .setQualifier("name")
            .build(),
        deleteDescription()
            .setFamily("personal")
            .setQualifier("surname")
            .build(),
        deleteDescription()
            .setFamily("personal")
            .setQualifier("age")
            .build(),
        deleteDescription()
            .setFamily("personal")
            .setQualifier("is_man")
            .build()
    );
  }
}

```