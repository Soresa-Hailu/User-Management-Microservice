package com.usermanagement.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.usermanagement.model.User;

@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

	public User findByEmail(String email);

}