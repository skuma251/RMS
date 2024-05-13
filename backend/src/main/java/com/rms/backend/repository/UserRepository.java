package com.rms.backend.repository;

import com.rms.backend.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<Users, Long> {

    Users findByEmail(String email);
}
