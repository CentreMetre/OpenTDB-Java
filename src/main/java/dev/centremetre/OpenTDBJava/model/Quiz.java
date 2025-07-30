package dev.centremetre.OpenTDBJava.model;

import java.util.List;

/**
 * A class representing a quiz.
 */
public class Quiz
{
    public Quiz(List<Question> questions)
    {
        this.questions = questions;
    }

    private List<Question> questions;

    public List<Question> getQuestions()
    {
        return questions;
    }

    public void setQuestions(List<Question> questions)
    {
        this.questions = questions;
    }
}