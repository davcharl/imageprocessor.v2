package com.example.demo;

import org.springframework.web.multipart.MultipartFile;

public class MetaInformation {
	
	private MultipartFile tempMultipartFile;
		
	public MetaInformation(MultipartFile incomingMPF){
		this.tempMultipartFile = incomingMPF;
	}
	
	public String getMeTheMetaData() {
		
		String fileName = "";
		fileName = this.tempMultipartFile.getOriginalFilename();
		return fileName;
	}

}
