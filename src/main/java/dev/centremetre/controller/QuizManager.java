package dev.centremetre.controller;

import dev.centremetre.model.Question;
import dev.centremetre.model.Quiz;

import java.util.List;

/**
 * A class to manage a quiz easier.
 */
public class QuizManager
{
    QuizManager(Quiz quiz)
    {
        this.quiz = quiz;
    }

    private Quiz quiz;

    private int currentQuestionIndex = 0;

    private boolean quizStarted = false;

    private boolean quizActive = false;

    /**
     * Starts the quiz by setting the {@link #quizStarted} field to true
     * and the {@link #currentQuestionIndex} field to 0.
     * It's recommended to not start the same quiz twice for fear of unexpected behaviour.
     */
    public void startQuiz()
    {
        quizStarted = true;
        quizActive = true;
        currentQuestionIndex = 0;
    }

    /**
     * Gets the question at the given index.
     * @param index The index to retrieve.
     * @return The question.
     * @throws IndexOutOfBoundsException If the index is out of bounds.
     */
    public Question getQuestion(int index)
    {
        return this.getQuestions().get(index);
    }

    /**
     * Gets the current question according to {@link #currentQuestionIndex}
     * @return The current question.
     * @throws IndexOutOfBoundsException If the index is out of bounds.
     */
    public Question getCurrentQuestion()
    {
        return this.getQuestion(currentQuestionIndex);
    }

    public List<Question> getRemainingQuestions()
    {
        return this.getQuestions().subList(currentQuestionIndex, this.getQuestions().size());
    }

    public List<Question> getQuestions()
    {
        return this.quiz.getQuestions();
    }
}
