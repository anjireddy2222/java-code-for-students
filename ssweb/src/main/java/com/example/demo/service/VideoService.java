package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.VideoController;
import com.example.demo.convertors.VideoConvertor;
import com.example.demo.dto.VideoDTO;
import com.example.demo.entity.Video;
import com.example.demo.pojo.VideoSearchApiData;
import com.example.demo.repository.VideoRepository;

@Service
public class VideoService {
	
	@Autowired
	private VideoRepository videoRepository;
	
	public List<VideoDTO> handleVideoSearch(VideoSearchApiData videoSearchApiData) {
		
		List<Video> videos = videoRepository.searchVideos( videoSearchApiData.getSearchWord() );
//		System.out.println( videos );
		Video video = videos.get(0);
		System.out.println(video);
		
		VideoDTO videoDTO = VideoConvertor.convertVideoToVideoDto(video);
		System.out.println(videoDTO);
		
		List<VideoDTO>  videoDTOs = videos.stream().map( VideoConvertor::convertVideoToVideoDto ).collect( Collectors.toList() );
		System.out.println(videoDTOs);
		
		return videoDTOs;
		
	}

}
