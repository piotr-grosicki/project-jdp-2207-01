package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
