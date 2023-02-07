package com.ktdsuniversity.edu.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BigdataStream1 {
	public static List<TextVO> readTextFile() {
		String filePath = "C:\\devs\\data\\bigdata\\10K.ID.CONTENTS";
		try {
			List<TextVO> list = Files.readAllLines(Paths.get(filePath))
					                 .parallelStream()
					                 .map( (line) -> {
					                	 String[] strArr = line.split("\t");
					                	 TextVO vo = new TextVO();
					                	 vo.setKey(strArr[0].trim());
					                	 if(strArr.length >= 2) {
					                		 vo.setValue(strArr[1].trim());
					                	 }
					                	 return vo;
					                 })
					                 .collect(Collectors.toList());
			return list;
		}
		catch (IOException ioe){
			return new ArrayList<>();
		}
	}
	
	public static void main(String[] args) {
		List<TextVO> textList = readTextFile();
		System.out.println(textList.size());
		
		
		long startTime = 0;
		//8-1. 10K.ID.CONTENTS 파일에서 "12370584"type name = new type();
		Optional<String> value = readTextFile().stream()
				                               .filter(vo -> vo.getKey().equals("12370584"))
				                               .map(vo -> vo.getValue())
				                               .findFirst();
		
		System.out.println(value.orElse("없음"));
		
		System.out.println("8-1 실행시간: " + (System.currentTimeMillis()- startTime));
	}
	
	

}
