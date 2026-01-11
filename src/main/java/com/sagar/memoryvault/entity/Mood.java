package com.sagar.memoryvault.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

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
        for (Mood e : Mood.values()) {
            if (e.value.equals(value)) {
                return e;
            }
        }

        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}