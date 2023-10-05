package com.example.demo.controller;

import com.example.demo.dto.IssueRequest;
import com.example.demo.service.JiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/issues")
public class IssueController {

    @Autowired
    JiraService jiraService;

    @PostMapping("/create")
    public ResponseEntity<String> createJiraIssue(@RequestBody IssueRequest issueRequest) {
        jiraService.createIssueInJira3(issueRequest.getProjectId(), issueRequest.getSummary(), issueRequest.getIssueType());
        return ResponseEntity.ok("Issue created successfully in Jira!");
    }

    @GetMapping("/{issueKey}")
    public ResponseEntity<Object> getIssue(@PathVariable String issueKey) {
        Object issue = jiraService.getIssue(issueKey);
            return ResponseEntity.ok(issue);

    }

    @PutMapping("/{issueKey}/edit")
    public ResponseEntity<Object> updateJiraIssue(
            @PathVariable String issueKey,@RequestBody Object o) {

        jiraService.updateIssue(issueKey,o);
        return ResponseEntity.ok("Issue updated !");
    }
}


