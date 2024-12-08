package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.VideoDTO;
import com.example.demo.entity.Video;
import com.example.demo.pojo.VideoSearchApiData;
import com.example.demo.service.VideoService;
import com.example.demo.utils.ResponseData;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@Tag(name = "Video APIs")
public class VideoController {
	
	@Autowired
	private VideoService videoService;
	
	@PostMapping("/video/search")
	public ResponseEntity<?> searchVideos(@Valid @RequestBody VideoSearchApiData videoSearchApiData) {
		java.util.List<VideoDTO> videos = videoService.handleVideoSearch(videoSearchApiData);
		Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put(ResponseData.RESULT, ResponseData.SUCCESS);
		responseMap.put(ResponseData.DATA, videos);
		return ResponseEntity.status(HttpStatus.OK).body( responseMap );
	}

}
