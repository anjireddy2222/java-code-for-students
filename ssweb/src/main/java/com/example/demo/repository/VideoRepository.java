package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Video;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Integer> {
	
	// select * from videos where title like '%java%' ;
	@Query("select v from Video v where v.title like %:searchWord% ")
	List<Video> searchVideos(@Param("searchWord") String searchWord);

}
