package dev.centremetre.OpenTDBJava.util;

import dev.centremetre.OpenTDBJava.external.OpenTDBResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class QuizHttpClient
{
    private static final HttpClient client = HttpClient.newHttpClient();

    public static HttpResponse<String> callService(String url) throws IOException, InterruptedException
    {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        OpenTDBResponse quizResponse = new OpenTDBResponse();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
