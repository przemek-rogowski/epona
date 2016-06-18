package com.epona.model;


public class DeleteDescription {

  private final String family;
  private final String qualifier;

  public DeleteDescription(String family, String qualifier) {
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
