package com.vivekanand.restapp.model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "job_post")
@NoArgsConstructor
@AllArgsConstructor
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;

    private String postProfile;
    private String postDesc;
    private Integer reqExperience;

    @ElementCollection
    private List<String> postTechStack;

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getPostProfile() {
		return postProfile;
	}

	public void setPostProfile(String postProfile) {
		this.postProfile = postProfile;
	}

	public String getPostDesc() {
		return postDesc;
	}

	public void setPostDesc(String postDesc) {
		this.postDesc = postDesc;
	}

	public Integer getReqExperience() {
		return reqExperience;
	}

	public void setReqExperience(Integer reqExperience) {
		this.reqExperience = reqExperience;
	}

	public List<String> getPostTechStack() {
		return postTechStack;
	}

	public void setPostTechStack(List<String> postTechStack) {
		this.postTechStack = postTechStack;
	}
    
    
}
