package com.epona.model;

public class DeleteDescriptionBuilder {

  private String family;
  private String qualifier;

  private DeleteDescriptionBuilder() {
  }

  public static DeleteDescriptionBuilder deleteDescription() {
    return new DeleteDescriptionBuilder();
  }

  public DeleteDescriptionBuilder setFamily(String family) {
    this.family = family;
    return this;
  }

  public DeleteDescriptionBuilder setQualifier(String qualifier) {
    this.qualifier = qualifier;
    return this;
  }

  public DeleteDescription build() {
    return new DeleteDescription(family, qualifier);
  }
}