package lotto;

import java.util.*;
public class Lotto {
	
	public static void main(String[] args) {
		
		//홀수 케이스(for문)
//		int k=100;
//		for(int i=0; i<=k; i++) {
//			if(i%2==1) {
//				System.out.print(i+" ");
//			}
//			System.out.println();
//		}
		
		
		
		
		//짝수 케이스
//		int p = 100;
//		for(int j=0; j<=p; j++) {
//			if(j%2==0) {
//				System.out.print(j+" ");
//			}
//			System.out.println();
//		}
		
		
		//while문
//		int k=0;
//		while(k<100) {
//			k+=1;
//			if(k%2==1) {
//				System.out.print(k+" ");
//				break;
//			}
//		}
		
//		int[] number = {50,30,20,55,999,1000};
//		for(int k : number) {
//			System.out.println(k);
//		}
		
		
		///for문
//		String str = "이번에 만나본 비건 가죽의 버킷 백 스타일의 토트백은 크로스로 가방끈을 늘려서 투 웨이로 다양하게 활용할 수 있어 좋았고요";
//		String[] wordArray = str.split(" ");
//		for(int i=0; i<wordArray.length; i++) {
//			System.out.print(wordArray[i]+" ");
//		}
		
		//for-each문
		String str = "이번에 만나본 비건 가죽의 버킷 백 스타일의 토트백은 크로스로 가방끈을 늘려서 투 웨이로 다양하게 활용할 수 있어 좋았고요";
	    String[] wordArray = str.split(" ");
//	    int len = str.length();
//	    System.out.println(len);
	    for(int i=0; i<wordArray.length; i++) {
	    	int len = wordArray[i].length();
	    	if(len>3) {
	    		System.out.println(wordArray[i]);
	    	}
	    }
	}
}
