package com.vivekanand.restapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivekanand.restapp.model.JobPost;
import com.vivekanand.restapp.repo.JobRepo;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    // Get all jobs
    public List<JobPost> getAllJobs() {
        return repo.findAll();
    }

    // Add job
    public JobPost addJob(JobPost jobPost) {
        return repo.save(jobPost);
    }

    // Get job by ID
    public JobPost getJob(int postId) {
        return repo.findById(postId).orElse(null);
    }

    // Update job
    public JobPost updateJob(int postId, JobPost jobPost) {
        return repo.findById(postId).map(existing -> {
            existing.setPostProfile(jobPost.getPostProfile());
            existing.setPostDesc(jobPost.getPostDesc());
            existing.setReqExperience(jobPost.getReqExperience());
            existing.setPostTechStack(jobPost.getPostTechStack());
            return repo.save(existing);
        }).orElse(null);
    }

    // Delete job
    public boolean deleteJob(int postId) {
        if (repo.existsById(postId)) {
            repo.deleteById(postId);
            return true;
        }
        return false;
    }
}
