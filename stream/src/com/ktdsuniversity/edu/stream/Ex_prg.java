package com.ktdsuniversity.edu.stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Ex_prg {
	public static void main(String[] args) {
		
		List<Integer> list = (List) Arrays.asList(10,20,30,40,50);
		Iterator<Integer> iterator = list.iterator();
		
		while(iterator.hasNext()) {
			Integer value = iterator.next();
			System.out.println(value + " ");
		}
	}
}
