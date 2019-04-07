package com.example.demouser.Repository;

import com.example.demouser.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends JpaRepository<User,Long> {
    User findByLastName(String lastName);
}
