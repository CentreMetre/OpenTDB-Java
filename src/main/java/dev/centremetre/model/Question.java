package dev.centremetre.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question
{
    Question(String correctAnswer, Iterable<String> incorrectAnswers)
    {
        this.correctAnswer = correctAnswer;
        this.incorrectAnswers = incorrectAnswers;
    }

    private QuestionType questionType;

    private String difficulty;

    private String category;

    private String question;

    private String correctAnswer;

    private Iterable<String> incorrectAnswers;

    /**
     * The answer submitted by the user.
     * Updated via {@link #submitAnswer(String)}
     */
    private String userAnswer;

    /**
     * True if the submitted answer matches the correct answer. False if not.
     * Updated via {@link #submitAnswer(String)}
     */
    private boolean answeredCorrectly;

    /**
     * Submits an answer to this question.
     * Updates the {@link #userAnswer} field with the submitted answer,
     * and the {@link #answeredCorrectly} field depending on if the submitted answer matches {@link #correctAnswer}.
     * @param chosenAnswer The answer submitted by the user.
     */
    public void submitAnswer(String chosenAnswer)
    {
        this.userAnswer = chosenAnswer;
        if (chosenAnswer.equals(this.correctAnswer))
        {
            this.answeredCorrectly = true;
            return;
        }
        this.answeredCorrectly = false;
    }

    /**
     * Get all answers for this question with the correct answer being the first element.
     * @return A list of all answers for this question, with the correct answer being the first element.
     */
    public List<String> getAnswers()
    {
        List<String> possibleAnswers = new ArrayList<>();
        possibleAnswers.add(this.correctAnswer);
        for (String incorrectAnswer : this.incorrectAnswers)
        {
            possibleAnswers.add(incorrectAnswer);
        }
        return possibleAnswers;
    }

    /**
     * Get all answers for this question in a shuffled order.
     * @return A list of all answers for this question, shuffled.
     */
    public List<String> getShuffledAnswers()
    {
        List<String> answers = getAnswers();
        Collections.shuffle(answers);
        return answers;
    }

    public QuestionType getQuestionType()
    {
        return questionType;
    }

    public String getDifficulty()
    {
        return difficulty;
    }

    public String getCategory()
    {
        return category;
    }

    public String getQuestion()
    {
        return question;
    }

    public String getCorrectAnswer()
    {
        return correctAnswer;
    }

    public Iterable<String> getIncorrectAnswers()
    {
        return incorrectAnswers;
    }

    public String getUserAnswer()
    {
        return userAnswer;
    }

    public boolean isAnsweredCorrectly()
    {
        return answeredCorrectly;
    }
}
