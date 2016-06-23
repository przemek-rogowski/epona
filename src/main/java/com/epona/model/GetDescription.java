package com.epona.model;


public class GetDescription {

  private final String family;
  private final String qualifier;

  GetDescription(String family, String qualifier) {
    this.family = family;
    this.qualifier = qualifier;
  }

  public String getFamily() {
    return family;
  }

  public String getQualifier() {
    return qualifier;
  }

}
