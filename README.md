# Epona

This is a java library that can effectively help in work with HBase. It will allows you to create queries to perform basic operation on your entities.

CONFIGURATION
// In build


GET OPERATION

``` java
public class UserGetQuery extends GetQuery<User> {

  @Override
  protected User parseResult(Result r) {
    // parsing logic
    return null;
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

PUT OPERATION

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

DELETE OPERATION

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