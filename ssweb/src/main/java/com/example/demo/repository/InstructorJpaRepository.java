package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Instructor;

@Repository
public interface InstructorJpaRepository extends JpaRepository<Instructor, Long> {
	
	@Query("select i from Instructor i LEFT JOIN i.courses where i.id = :insId ")
	Instructor getInstructorDataById(@Param("insId") Long insId );
	
}
