package dev.centremetre.util;
//Todo review if needed
/**
 * Use the builder pattern to build a URL with the 5 parameters.
 */
public class UrlBuilder
{
    private static final String BASE_URL = "https://opentdb.com/api.php?";

    private int questionCount;

    private String questionType;

    private String difficulty;

    private String category;

    private String encoding;

    /**
     *
     * @param questionCount The amount of questions to request for. Must be between 1 and 50 (inclusive)
     * @throws IllegalArgumentException If the amount is less than 1 or greater than 50.
     * @throws NumberFormatException If the amount is not a number or if it is not an integer.
     */
    public UrlBuilder(String questionCount)
    {
        setQuestionCount(questionCount);
    }

    /**
     *
     * @param questionCount The amount of questions to request for. Must be between 1 and 50 (inclusive)
     * @throws IllegalArgumentException If the amount is less than 1 or greater than 50.
     * @throws NumberFormatException If the amount is not a number or if it is not an integer.
     */
    private void setQuestionCount(String questionCount)
    {
        int intAmount = Integer.parseInt(questionCount);

        if (intAmount < 1)
        {
            throw new IllegalArgumentException("Question count cannot be less than 1.");
        }

        if (intAmount > 50)
        {
            throw new IllegalArgumentException("Question count cannot be greater than 50.");
        }

        this.questionCount = intAmount;
    }

    public UrlBuilder setQuestionType(String questionType)
    {
        this.questionType = questionType;
        return this;
    }

    public UrlBuilder setDifficulty(String difficulty)
    {
        this.difficulty = difficulty;
        return this;
    }

    public UrlBuilder setCategory(String category)
    {
        this.category = category;
        return this;
    }

    public UrlBuilder setEncoding(String encoding)
    {
        this.encoding = encoding;
        return this;
    }

    /**
     * Builds the URL made using the builder pattern on this class.
     * @return A string which contains the URL to call.
     */
    public String build()
    {
        StringBuilder url = new StringBuilder();
        url.append(BASE_URL);
        url.append("amount=").append(this.questionCount);

        if (this.questionType != null)
        {
            url.append("&type=").append(this.questionType);
        }
        if (this.difficulty != null)
        {
            url.append("&difficulty=").append(this.difficulty);
        }
        if (this.category != null)
        {
            url.append("&category=").append(this.category);
        }
        if (this.encoding != null)
        {
            url.append("&encode=").append(this.encoding);
        }

        return url.toString();
    }
}
