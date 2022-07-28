package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class ImageController {
	
	/*
	@GetMapping("/upload")
	public String upload(@RequestParam(value="imagedimension", defaultValue="1x1") String imageDimension,
			@RequestParam(value="imagesize", defaultValue="1KB") String imageSize ) {
			// Metadata myMeta = new Metadata("200x400","243KB");
			Metadata myMeta = new Metadata(imageDimension, imageSize);
			return String.format("dimension: %s; size: %s", myMeta.getImageDimension(), myMeta.getImageSize());
			
	
	
	
	// @PostMapping(value = "/upload", produces = MediaType.IMAGE_JPEG_VALUE)
	@PostMapping("/upload")
	// @RequestParam("file") MultipartFile file
	// @RequestParam(value="imagedimension") Image image
	public @ResponseBody String upload( @RequestParam("file") MultipartFile file ) {
		if(file!=null) {
	
	

	*/
	
	/*
	@PostMapping("/postMeta")
	public String getMeta( @RequestParam("file") MultipartFile file ) {
		return null;	
	}
	*/
	
	@GetMapping("/myMeta")
	public String provideMetaData(@RequestParam("file") MultipartFile file) {
		
		MetaInformation returnableMeta = new MetaInformation(file);
		
		return returnableMeta.getMeTheMetaData();
	}
	
	@PostMapping( value = "/filterImage", produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] filterImage( @RequestParam("file") MultipartFile file ) {
		
		ImageManipulation returnableMPF = new ImageManipulation(file);

		
		return returnableMPF.giveMeTheByteArray() ;
	}
	
	

}
