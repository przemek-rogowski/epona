package com.epona.model;


public class PutDescription {

  private final String family;
  private final String qualifier;
  private final String value;

  public PutDescription(String family, String qualifier, String value) {
    this.family = family;
    this.qualifier = qualifier;
    this.value = value;
  }

  public String getFamily() {
    return family;
  }

  public String getQualifier() {
    return qualifier;
  }

  public String getValue() {
    return value;
  }

}
