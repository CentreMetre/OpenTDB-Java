package dev.centremetre.external;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.centremetre.model.Question;

import java.util.List;

public class OpenTDBResponse
{
    private int responseCode;

    private List<Question> questions;

    public int getResponseCode()
    {
        return responseCode;
    }

    public void setResponseCode(int responseCode)
    {
        this.responseCode = responseCode;
    }

    public List<Question> getQuestions()
    {
        return questions;
    }

    public void setQuestions(List<Question> questions)
    {
        this.questions = questions;
    }
}
