package com.example.demo;

import com.atlassian.jira.rest.client.api.IssueRestClient;
import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.domain.input.IssueInput;
import com.atlassian.jira.rest.client.api.domain.input.IssueInputBuilder;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.net.URI;

@Component
public class MyJiraClient {


    @Value("${jira.base-url}")
    private String jiraUrl;

    @Value("${jira.username}")
    private String username;

    @Value("${jira.api-token}")
    private String password;

    private JiraRestClient restClient;

//    public MyJiraClient(String jiraUrl, String username, String password) {
//        this.jiraUrl = jiraUrl;
//        this.username = username;
//        this.password = password;
//        this.restClient = getJiraRestClient();
//    }
    private JiraRestClient getJiraRestClient() {
        return new AsynchronousJiraRestClientFactory()
                .createWithBasicHttpAuthentication(getJiraUri(), this.username, this.password);
    }
    private URI getJiraUri() {
        return URI.create(this.jiraUrl);
    }

    public String createIssue(String projectKey, Long issueType, String issueSummary) {
        IssueRestClient issueClient = restClient.getIssueClient();
        IssueInput newIssue = new IssueInputBuilder(
                projectKey, issueType, issueSummary).build();
        return issueClient.createIssue(newIssue).claim().getKey();
    }
}
