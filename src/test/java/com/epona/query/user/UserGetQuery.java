package com.epona.query.user;

import com.epona.model.GetDescription;
import com.epona.parser.ResultParser;
import com.epona.query.GetQuery;
import org.apache.hadoop.hbase.client.Result;

import java.util.ArrayList;
import java.util.List;

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
