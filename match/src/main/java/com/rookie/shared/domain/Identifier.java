package com.rookie.shared.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.MappedSuperclass;

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class Identifier implements Serializable {
  private final String value;

  protected Identifier(String value) {
    ensureValidUuid(value);
    this.value = value;
  }

  protected Identifier() {
    value = null;
  }

  public String value() {
    return value;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
	return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
	return false;
    }
    Identifier that = (Identifier) o;
    return value.equals(that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  private void ensureValidUuid(String value) throws IllegalArgumentException {
    UUID.fromString(value);
  }
}
