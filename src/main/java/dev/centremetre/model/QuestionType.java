package dev.centremetre.model;

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
}
