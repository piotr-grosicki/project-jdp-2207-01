package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.entity.Group;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
}
