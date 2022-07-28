package com.example.demo;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

import org.springframework.web.multipart.MultipartFile;

public class ImageManipulation {
	
	private MultipartFile tempMultipartFile;
	
	public ImageManipulation(MultipartFile incomingMPF){
		this.tempMultipartFile = incomingMPF;
	}
	
	// Take in a multipartfile
	
	// Get the image content of the multipart
	
	// Manipulate the image
	
	// Convert to a valid multipartfile
	
	// Return the image as a multipart file
	
	public MultipartFile giveMeTheMultipartFile() {
		return this.tempMultipartFile;
	}
	
	byte[] giveMeTheByteArray() {
		
		byte[] tempByteArray = null;
		
		try {
			tempByteArray = this.tempMultipartFile.getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempByteArray;
	}
	
	
	BufferedImage giveMeTheBufferImage() {
		
		BufferedImage newBi = null;
		byte[] bytes = giveMeTheByteArray();					// MPFile > byte[]
		
		// convert byte[] to a BufferedImage
        InputStream is = new ByteArrayInputStream(bytes);		// byte[] > BAIS > IS
        try {
			newBi = ImageIO.read(is);							// IS > ImageIO > BI
		} catch (IOException e) {
			e.printStackTrace();
		}
        return newBi;
	}
	
	
	BufferedImage giveMeTheBufferImage2() {
		
		BufferedImage newBi = null;
		InputStream is = null;
		try {
			is = this.tempMultipartFile.getInputStream();		// MPFile > IS
		} catch (IOException eMPFtoIS) {
			eMPFtoIS.printStackTrace();
		}					
		
		try {
			newBi = ImageIO.read(is);
		} catch (IOException eIStoBI) {							// IS >>ImageIO>> BI
			eIStoBI.printStackTrace();
		}
		
        return newBi;
	}
	
	
	
	
}
