package com.epona.query.user;

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
