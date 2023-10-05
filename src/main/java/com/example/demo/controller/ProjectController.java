package com.example.demo.controller;

import com.example.demo.service.JiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    JiraService jiraService;

    @PostMapping("/create")
    public ResponseEntity<String> createJiraProject(@RequestBody Object o) {
        jiraService.createProject(o);
        return ResponseEntity.ok("Project created successfully in Jira!");
    }

//    @GetMapping("/{ProjectKey}")
//    public ResponseEntity<Object> getProject(@PathVariable String ProjectKey) {
//        Object Project = jiraService.getProject(ProjectKey);
//            return ResponseEntity.ok(Project);
//
//    }
//
//    @PutMapping("/{ProjectKey}/edit")
//    public ResponseEntity<Object> updateJiraProject(
//            @PathVariable String ProjectKey,@RequestBody Object o) {
//
//        jiraService.updateProject(ProjectKey,o);
//        return ResponseEntity.ok("Project updated !");
//    }
}


