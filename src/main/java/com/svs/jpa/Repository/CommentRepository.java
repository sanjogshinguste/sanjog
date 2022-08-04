package com.svs.jpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.svs.jpa.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
