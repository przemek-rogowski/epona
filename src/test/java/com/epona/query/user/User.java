package com.epona.query.user;


public class User {

  private String name;
  private String surname;
  private int age;
  private boolean isMan;

  public User(String name, String surname, int age, boolean isMan) {
    this.name = name;
    this.surname = surname;
    this.age = age;
    this.isMan = isMan;
  }

  @Override
  public String toString() {
    return "User{" +
        "name='" + name + '\'' +
        ", surname='" + surname + '\'' +
        ", age=" + age +
        ", isMan=" + isMan +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    User user = (User) o;

    if (age != user.age) return false;
    if (isMan != user.isMan) return false;
    if (name != null ? !name.equals(user.name) : user.name != null) return false;
    return surname != null ? surname.equals(user.surname) : user.surname == null;

  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (surname != null ? surname.hashCode() : 0);
    result = 31 * result + age;
    result = 31 * result + (isMan ? 1 : 0);
    return result;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public boolean isMan() {
    return isMan;
  }

  public void setMan(boolean man) {
    isMan = man;
  }
}
