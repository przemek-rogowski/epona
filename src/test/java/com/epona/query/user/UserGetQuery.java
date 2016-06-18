package com.epona.query.user;

import com.epona.model.GetDescription;
import com.epona.query.GetQuery;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

import java.util.ArrayList;
import java.util.List;

public class UserGetQuery extends GetQuery<User> {

  @Override
  protected User parseResult(Result result) {
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
