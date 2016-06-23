package com.epona.model;

public class PutDescriptionBuilder {

  private String family;
  private String qualifier;
  private String value;

  PutDescriptionBuilder() {
  }

  public static PutDescriptionBuilder putDescription() {
    return new PutDescriptionBuilder();
  }

  public PutDescriptionBuilder setFamily(String family) {
    this.family = family;
    return this;
  }

  public PutDescriptionBuilder setQualifier(String qualifier) {
    this.qualifier = qualifier;
    return this;
  }

  public PutDescriptionBuilder setValue(String value) {
    this.value = value;
    return this;
  }

  public PutDescription build() {
    return new PutDescription(family, qualifier, value);
  }
}