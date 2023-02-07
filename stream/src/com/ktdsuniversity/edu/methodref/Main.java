package com.ktdsuniversity.edu.methodref;

import java.util.List;
import java.util.function.Predicate;

public class Main {
	
	public static void printEvenNumber(List<NumberVO> numberList,
			Predicate<NumberVO> predicate) {
		
		
		for (NumberVO number: numberList) {
			if (predicate.test(number)) {
				System.out.println(number.getNumber());
			}
		}
	}
	
	public static void main(String[] args) {
		
		//함수형 인터페이스로 전달될 때만 이렇게 쓰일 수 있다.
		//Predicate에 numberVO기 떄문이다.
		//NumberVO라는 parameter
		//NumberVO에서 isEven은 boolean을 return
		//짝수만 출력이 된다.
		//numberVO를 파리미터로 받아와서 isEven으로 반환시켜라
		//Typing을 줄이면 줄일수록 Good
		printEvenNumber(List.of(new NumberVO(1),
				                new NumberVO(2),
				                new NumberVO(3),
				                new NumberVO(4),
				                new NumberVO(5),
				                new NumberVO(6),
				                new NumberVO(7),
				                new NumberVO(8),
				                new NumberVO(9),
				                new NumberVO(10)),
				                (numberVO)-> numberVO.isEven());
//		printEvenNumber(List.of(new NumberVO(1),
//                new NumberVO(2),
//                new NumberVO(3),
//                new NumberVO(4),
//                new NumberVO(5),
//                new NumberVO(6),
//                new NumberVO(7),
//                new NumberVO(8),
//                new NumberVO(9),
//                new NumberVO(10)),
//                NumberVO::isEven();
		
	}
}
