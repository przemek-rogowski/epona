package com.epona.query.user;

import com.epona.model.DeleteDescription;
import com.epona.query.DeleteQuery;

import java.util.Arrays;
import java.util.List;

import static com.epona.model.DeleteDescriptionBuilder.deleteDescription;

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

  @Override
  protected String getTableName() {
    return "User";
  }
}
