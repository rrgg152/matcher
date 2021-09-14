package com.rookie.shared.domain;

import java.util.Objects;


public abstract class StringValueObject {

  protected String value;

  protected StringValueObject(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }

  @Override
  public String toString() {
    return value();
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
	return true;
    }
    if (!(o instanceof StringValueObject)) {
	return false;
    }
    StringValueObject that = (StringValueObject) o;
    return Objects.equals(value, that.value);
  }

}
