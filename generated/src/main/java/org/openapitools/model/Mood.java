package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Represents mood field memory
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-01-11T18:58:48.001078900+05:30[Asia/Calcutta]")
public enum Mood {
  
  HAPPY("HAPPY"),
  
  SAD("SAD"),
  
  CALM("CALM"),
  
  DARK("DARK"),
  
  HOPEFUL("HOPEFUL"),
  
  CHAOTIC("CHAOTIC"),
  
  ANGRY("ANGRY");

  private String value;

  Mood(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static Mood fromValue(String value) {
    for (Mood b : Mood.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

