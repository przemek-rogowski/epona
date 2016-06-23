package com.epona.query.user;

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
