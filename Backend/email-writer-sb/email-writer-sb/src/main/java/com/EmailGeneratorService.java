package com;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class EmailGeneratorService {

    private final WebClient webClient;

    @Value("${gemini.api.url}")
    private String geminiApiUrl;
    @Value("${gemini.api.key}")
    private String geminiApiKey;

    public EmailGeneratorService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public String generateEmailReply(EmailRequest emailRequest){
        //Build the prompt go to ai

        String prompt = buildPrompt(emailRequest);

        // craft a request

        //{
        //  "contents": [{
        //    "parts":[{"text": "Explain Springboot in brief"}]
        //    }]
        //}

        Map<String , Object> requestBody = Map.of(
                "contents", new Object[]{
                        Map.of("parts", new Object[]{
                                Map.of("text", prompt)
                        })
                }
        );

        //do req and get resp-- needs api and url
        String response = webClient.post()
                .uri(geminiApiUrl + geminiApiKey)
                .header("Content-Type","application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        //extract the resp and return

        //{
        //    "candidates": [
        //        {
        //            "content": {
        //                "parts": [
        //                    {
        //                        "text": "Spring Boot is a popular Java-based framework that simplifies the

        return extractResponseContent(response);
    }

    private String extractResponseContent(String response) {
        try {
            ObjectMapper mapper = new ObjectMapper();//can conv json data to java obj and visa versa
            JsonNode rootNode = mapper.readTree(response);//json rep to tree
            return rootNode.path("candidates")
                    .get(0)
                    .path("content")
                    .path("parts")
                    .get(0)
                    .path("text")
                    .asText();
        } catch (Exception e) {
            return "Error Processing Req"+e.getMessage();
        }
    }

    private String buildPrompt(EmailRequest emailRequest) {
        StringBuilder prompt = new StringBuilder();
        prompt.append("Generate a Professional email reply for the following email content. Please don't generate a subject line ");
        if(emailRequest.getTone() != null && !emailRequest.getTone().isEmpty()){
            prompt.append("use a").append(emailRequest.getTone()).append("tone.");
        }
        prompt.append("\nOriginal email:\n").append(emailRequest.getEmailContent());
        return prompt.toString();
    }
}
