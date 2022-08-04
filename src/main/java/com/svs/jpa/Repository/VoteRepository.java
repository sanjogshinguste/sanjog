package com.svs.jpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.svs.jpa.model.Vote;

public interface VoteRepository extends JpaRepository<Vote,Long> {

}
