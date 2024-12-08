package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetAPIs {
	
	@GetMapping("watch")
	public String getVideoDetails(@RequestParam String v, @RequestParam String ab_channel) {
		
		
		return "Video Id: " + v + ". Ab Channel: " + ab_channel;
	}
	
	@GetMapping("api/v1/users/web_profile_info")
	public String getProfileDetails(@RequestParam String username) {
		
		return "Profile details of: " + username;
	}
	
	@GetMapping("c/{courseId}")
	public String getCourseDetails(@PathVariable String courseId) {
		return "Course details are: " + courseId;
	}
	
	@GetMapping("p/{postId}")
	public String getPostDetails(@PathVariable String postId) {
		return "Instgram post details: " + postId;
	}
	
	//https://www.amazon.in/Apple-iPhone-15-128-GB/dp/B0CHX2F5QT/
	
	@GetMapping("{seoTitle}/dp/{productId}")
	public String getAmazonProductDetails(@PathVariable String seoTitle, @PathVariable String productId) {
		return "Product details: " + seoTitle + ", id: " + productId;
	}
	

}
