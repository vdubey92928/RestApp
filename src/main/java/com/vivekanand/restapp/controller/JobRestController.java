package com.vivekanand.restapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vivekanand.restapp.model.JobPost;
import com.vivekanand.restapp.service.JobService;
@RestController
public class JobRestController {

    @Autowired
    private JobService service;

    // Get all job posts
    @GetMapping("/jobPosts")
    public List<JobPost> getAllJobs() {
        return service.getAllJobs();
    }

    // Get job by id
    @GetMapping("/jobPost/{postId}")
    public ResponseEntity<JobPost> getJob(@PathVariable int postId) {
        JobPost job = service.getJob(postId);
        if (job != null) {
            return ResponseEntity.ok(job);
        }
        return ResponseEntity.notFound().build();
    }

    // Add job
    @PostMapping("/jobPost")
    public ResponseEntity<JobPost> addJob(@RequestBody JobPost jobPost) {
        JobPost savedJob = service.addJob(jobPost);
        return ResponseEntity.ok(savedJob);
    }

    // Update job by ID
    @PutMapping("/jobPost/{postId}")
    public ResponseEntity<JobPost> updateJob(@PathVariable int postId, @RequestBody JobPost jobPost) {
        JobPost updatedJob = service.updateJob(postId, jobPost);
        if (updatedJob != null) {
            return ResponseEntity.ok(updatedJob);
        }
        return ResponseEntity.notFound().build();
    }

    // Delete job by ID
    @DeleteMapping("/jobPost/{postId}")
    public ResponseEntity<String> deleteJob(@PathVariable int postId) {
        boolean deleted = service.deleteJob(postId);
        if (deleted) {
            return ResponseEntity.ok("Deleted Successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
