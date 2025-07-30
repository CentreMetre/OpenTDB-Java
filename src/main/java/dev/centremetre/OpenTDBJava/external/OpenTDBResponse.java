package dev.centremetre.OpenTDBJava.external;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.centremetre.OpenTDBJava.model.Question;

import java.util.List;

/**
 * A model of a response from the OpenTDB server. Used to convert a response into a Java class.
 */
public class OpenTDBResponse
{
    /**
     * The response code from the server.
     * From <a href="https://opentdb.com/api_config.php">opentdb docs</a>:
     * Code 0: Success Returned results successfully.<br>
     * Code 1: No Results Could not return results. The API doesn't have enough questions for your query. (Ex. Asking for 50 Questions in a Category that only has 20.)<br>
     * Code 2: Invalid Parameter Contains an invalid parameter. Arguements passed in aren't valid. (Ex. Amount = Five)<br>
     * Code 3: Token Not Found Session Token does not exist.<br>
     * Code 4: Token Empty Session Token has returned all possible questions for the specified query. Resetting the Token is necessary.<br>
     * Code 5: Rate Limit Too many requests have occurred. Each IP can only access the API once every 5 seconds.<br>
     */
    @JsonProperty("response_code")
    private int responseCode;

    @JsonProperty("results")
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
