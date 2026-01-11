package com.sagar.memoryvault.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class MoodAttributeConverter implements AttributeConverter<Mood, String> {
    @Override
    public String convertToDatabaseColumn(Mood mood) {
        return mood.toString();
    }

    @Override
    public Mood convertToEntityAttribute(String mood) {
        return Mood.valueOf(mood);
    }
}
