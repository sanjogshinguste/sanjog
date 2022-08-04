package com.svs.jpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.svs.jpa.model.Subreddit;

public interface SubredditRepository extends JpaRepository<Subreddit,Long> {

}
