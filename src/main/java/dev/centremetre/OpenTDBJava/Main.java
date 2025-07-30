package dev.centremetre.OpenTDBJava;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.centremetre.OpenTDBJava.external.OpenTDBResponse;
import dev.centremetre.OpenTDBJava.model.Question;
import dev.centremetre.OpenTDBJava.service.QuizService;
import dev.centremetre.OpenTDBJava.util.QuizUrl;
import jdk.jshell.spi.ExecutionControl;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.exit;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        QuizUrl url = new QuizUrl("5");

        QuizService service = new QuizService();

        OpenTDBResponse response = null;

        try
        {
            response = service.createQuizInResponse(url);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        System.out.println("Response code: " + response.getResponseCode());
        List<Question> questions = response.getQuestions();
        for (Question question : questions)
        {
            System.out.println(question.toString());
        }
    }
}