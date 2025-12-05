package com.vivekanand.restapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vivekanand.restapp.model.JobPost;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {
    // You now have: save, findById, findAll, deleteById, etc.
}
