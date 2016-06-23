# Epona

This is a java library that can effectively help in work with HBase. It will allows you to create queries to perform basic operation on your entities.
This library is a wrapper for the hbase-client. The implementations should be compatible from the version 1.0.0. 
http://mvnrepository.com/artifact/org.apache.hbase/hbase-client/1.2.1


CONFIGURATION
// In build


GET operation

``` java
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
  protected String getTableName() {
    return "User";
  }

  @Override
  protected List<GetDescription> prepareGetDescription() {
    List<GetDescription> descriptions = new ArrayList<GetDescription>();
    descriptions.add(new GetDescription("personal", "name"));
    descriptions.add(new GetDescription("personal", "surname"));
    descriptions.add(new GetDescription("personal", "age"));
    descriptions.add(new GetDescription("personal", "is_man"));
    return descriptions;
  }
}
```

PUT operation

``` Java

public class UserPutQuery extends PutQuery<User> {

  @Override
  protected List<PutDescription> preparePutDescription(User value) {
    List<PutDescription> descriptions = new ArrayList<PutDescription>();
    descriptions.add(new PutDescription("personal", "name", value.getName()));
    descriptions.add(new PutDescription("personal", "surname", value.getSurname()));
    descriptions.add(new PutDescription("personal", "age", String.valueOf(value.getAge())));
    descriptions.add(new PutDescription("personal", "is_man", String.valueOf(value.isMan())));
    return descriptions;
  }

  @Override
  protected String getTableName() {
    return "User";
  }
}

```

DELETE operation

``` Java

public class UserDeleteQuery extends DeleteQuery {

  @Override
  protected List<DeleteDescription> prepareDeleteDescription() {
    List<DeleteDescription> descriptions = new ArrayList<DeleteDescription>();
    descriptions.add(new DeleteDescription("personal", "name"));
    descriptions.add(new DeleteDescription("personal", "surname"));
    descriptions.add(new DeleteDescription("personal", "age"));
    descriptions.add(new DeleteDescription("personal", "is_man"));
    return descriptions;
  }

  @Override
  protected String getTableName() {
    return "User";
  }
}

```