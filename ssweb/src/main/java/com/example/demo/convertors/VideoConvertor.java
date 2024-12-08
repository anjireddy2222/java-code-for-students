package com.example.demo.convertors;

import com.example.demo.dto.VideoDTO;
import com.example.demo.entity.Video;

public class VideoConvertor {

	
	public static VideoDTO convertVideoToVideoDto(Video video) {
		
		VideoDTO videoDTO = new VideoDTO();
		
		videoDTO.setId( video.getId() );
		videoDTO.setTitle( video.getTitle() );
		videoDTO.setDescription( video.getDescription() );
		
		return videoDTO;
	}
	
	
}
