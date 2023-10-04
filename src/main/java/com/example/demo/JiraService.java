package com.example.demo;

import com.atlassian.jira.rest.client.api.IssueRestClient;
import com.atlassian.jira.rest.client.api.domain.input.IssueInput;
import com.atlassian.jira.rest.client.api.domain.input.IssueInputBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Base64;

@Service
public class JiraService {

    private final WebClient webClient;

    public JiraService(WebClient.Builder webClientBuilder,
                       @Value("${jira.base-url}") String baseUrl,
                       @Value("${jira.username}") String username,
                       @Value("${jira.api-token}") String apiToken) {

        this.webClient = webClientBuilder
                .baseUrl(baseUrl)
                .defaultHeader("Authorization", "Basic " + Base64.getEncoder().encodeToString((username + ":" + apiToken).getBytes()))
                .build();
    }
//    public String createIssue(String projectKey, Long issueType, String issueSummary) {
//        IssueRestClient issueClient = restClient.getIssueClient();
//        IssueInput newIssue = new IssueInputBuilder(
//                projectKey, issueType, issueSummary).build();
//        return issueClient.createIssue(newIssue).claim().getKey();
//    }
    public void createIssueInJira(String projectKey, String summary, String description) {
        String apiUrl = "/rest/api/2/issue/";

        IssueRequest issueRequest = new IssueRequest(projectKey, summary, description);
        // You need to create IssueRequest class with appropriate fields for your request
        webClient.post()
                .uri(apiUrl)
                .body(BodyInserters.fromValue(issueRequest))
                .retrieve()
                .bodyToMono(String.class);
            //    .block(); // block() used here for simplicity, handle response asynchronously in production
    }
}
