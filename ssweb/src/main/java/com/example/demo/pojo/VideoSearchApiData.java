package com.example.demo.pojo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class VideoSearchApiData {
	
	@NotNull(message = "searchWord is missing")
	@NotBlank( message = "search word should not be blank")
	@Size( min=2, message = "Min 2 characters")
	private String searchWord;

}
