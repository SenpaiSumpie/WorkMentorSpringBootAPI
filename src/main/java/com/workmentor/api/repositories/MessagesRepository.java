package com.workmentor.api.repositories;

import com.workmentor.api.models.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessagesRepository extends JpaRepository<Messages, Integer> {
}
