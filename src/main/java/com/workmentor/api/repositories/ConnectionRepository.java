package com.workmentor.api.repositories;

import com.workmentor.api.models.Connection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConnectionRepository extends JpaRepository<Connection, Integer> {
}
