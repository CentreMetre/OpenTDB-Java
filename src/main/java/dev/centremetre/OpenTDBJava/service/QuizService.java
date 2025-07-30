package dev.centremetre.OpenTDBJava.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.centremetre.OpenTDBJava.external.OpenTDBResponse;
import dev.centremetre.OpenTDBJava.model.Question;
import dev.centremetre.OpenTDBJava.model.Quiz;
import dev.centremetre.OpenTDBJava.util.QuizHttpClient;
import dev.centremetre.OpenTDBJava.util.QuizUrl;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

public class QuizService
{
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Calls the API and returns a {@link Quiz} object.
     * @param quizUrl A {@link QuizUrl} containing the constructed URL.
     * @return A {@link Quiz} containing the questions.
     * @throws IOException if network or JSON errors occur, or if there is a non 200 response code.
     * @throws InterruptedException if the thread is interrupted while waiting for the response.
     */
    public Quiz createQuiz(QuizUrl quizUrl) throws IOException, InterruptedException
    {
        String url = quizUrl.build();
        return createQuiz(url);
    }

    /**
     * Calls the API and returns a {@link Quiz} object.
     * @param url The url to call.
     * @return A {@link Quiz} containing the questions.
     * @throws IOException if network or JSON errors occur, or if there is a non 200 response code.
     * @throws InterruptedException if the thread is interrupted while waiting for the response.
     */
    public Quiz createQuiz(String url) throws IOException, InterruptedException
    {
        OpenTDBResponse openTDBResponse = createQuizInResponse(url);

        List<Question> questions = openTDBResponse.getQuestions();

        return new Quiz(questions);
    }

    /**
     * Calls the API and returns a {@link OpenTDBResponse} object.
     * @param url The url to call.
     * @return A {@link OpenTDBResponse} containing the questions and response code.
     * @throws IOException if network or JSON errors occur, or if there is a non 200 response code.
     * @throws InterruptedException if the thread is interrupted while waiting for the response.
     */
    public OpenTDBResponse createQuizInResponse(String url) throws IOException, InterruptedException
    {
        HttpResponse<String> response = QuizHttpClient.callService(url);

        if (response.statusCode() != 200)
        {
            throw new IOException("Unexpected status code: " + response.statusCode());
        }

        String body = response.body();

        return objectMapper.readValue(body, OpenTDBResponse.class);
    }

    /**
     * Calls the API and returns a {@link OpenTDBResponse} object.
     * @param quizUrl A {@link QuizUrl} containing the constructed URL.
     * @return A {@link OpenTDBResponse} containing the questions and response code.
     * @throws IOException if network or JSON errors occur, or if there is a non 200 response code.
     * @throws InterruptedException if the thread is interrupted while waiting for the response.
     */
    public OpenTDBResponse createQuizInResponse(QuizUrl quizUrl) throws IOException, InterruptedException
    {
        return createQuizInResponse(quizUrl.build());
    }
}
