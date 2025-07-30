package dev.centremetre.OpenTDBJava.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum QuestionType
{
    MULTIPLE("Multiple"),
    BOOLEAN("True or False");

    private final String descriptor;

    QuestionType(String descriptor)
    {
        this.descriptor = descriptor;
    }

    public String getDescriptor()
    {
        return descriptor;
    }

    /*
    Needed to convert tdb response into enum.
     */
    @JsonCreator
    public static QuestionType fromString(String key)
    {
        return key == null ? null : QuestionType.valueOf(key.toUpperCase());
    }
}
