package com.rms.backend.repository;

import com.rms.backend.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<Users, Long> {

    List<Users> findByEmail(String email);
}
