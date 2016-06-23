package com.epona.model;

public class GetDescriptionBuilder {

  private String family;
  private String qualifier;

  private GetDescriptionBuilder() {
  }

  public static GetDescriptionBuilder getDescription() {
    return new GetDescriptionBuilder();
  }

  public GetDescriptionBuilder setFamily(String family) {
    this.family = family;
    return this;
  }

  public GetDescriptionBuilder setQualifier(String qualifier) {
    this.qualifier = qualifier;
    return this;
  }

  public GetDescription build() {
    return new GetDescription(family, qualifier);
  }
}