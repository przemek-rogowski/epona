package com.epona.query.user;

import com.epona.model.PutDescription;
import com.epona.query.PutQuery;

import java.util.ArrayList;
import java.util.List;

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
