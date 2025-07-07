package dev.centremetre.model;

import java.util.List;

public class Quiz
{
    Quiz(List<Question> questions)
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