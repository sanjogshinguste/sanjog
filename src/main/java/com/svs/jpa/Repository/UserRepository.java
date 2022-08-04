package com.svs.jpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.svs.jpa.model.User;

public interface UserRepository  extends JpaRepository<User, Long>{

}
