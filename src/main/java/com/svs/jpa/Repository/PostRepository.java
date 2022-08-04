package com.svs.jpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.svs.jpa.model.Post;
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
