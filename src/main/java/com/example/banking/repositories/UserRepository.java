package com.example.banking.repositories;

import com.example.banking.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository<User,Integer> {


    @Query(value = "Select * from banking.users as u\n" +
            "Where u.id_card = :id",nativeQuery = true)
    User getUser(@Param("id") String id);
}
