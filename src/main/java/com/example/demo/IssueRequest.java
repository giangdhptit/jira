package com.example.demo;

public class IssueRequest {

    private String projectKey;
    private String summary;
    private String description;

    // Constructors, getters, and setters

    public IssueRequest() {
    }

    public IssueRequest(String projectKey, String summary, String description) {
        this.projectKey = projectKey;
        this.summary = summary;
        this.description = description;
    }

    public String getProjectKey() {
        return projectKey;
    }

    public void setProjectKey(String projectKey) {
        this.projectKey = projectKey;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
