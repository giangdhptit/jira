package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/issues")
public class IssueController {

    @Autowired
    MyJiraClient myJiraClient;

    @PostMapping
    public ResponseEntity<String> createJiraIssue(@RequestBody IssueRequest issueRequest) {
        myJiraClient.createIssue(issueRequest.getProjectKey(), Long.valueOf("10003"), issueRequest.getDescription());
        return ResponseEntity.ok("Issue created successfully in Jira!");
    }
}


