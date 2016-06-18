package com.epona.query.user;

import com.epona.model.DeleteDescription;
import com.epona.query.DeleteQuery;

import java.util.ArrayList;
import java.util.List;

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
