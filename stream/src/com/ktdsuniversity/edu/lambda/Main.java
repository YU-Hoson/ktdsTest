package com.ktdsuniversity.edu.lambda;

import java.util.Arrays;
import java.util.List;

public class Main {

	//중괄호, 중괄호X
	public static void print(Printable printable) {
		printable.print("유호선");
	}



	//인터페이스를 어디에서도 구현 X
	public static void printSumResult(Computable computable) {
		int sumResult = computable.sum(10, 30);
		System.out.println(sumResult);
	}


	//익명클래스로 접근
	//원래로는 클래스를 만들어서 오버라이딩해서 객체를 만들어 전달
	//그런 방법 대신 익명클래스로 했다.
	public static void main(String[] args) {
		// 익명 클래스
		printSumResult(new Computable() {

			@Override
			public int sum(int numberOne, int numberTwo) {
				return numberOne + numberTwo;
			}
		});

		//람다 함수
		//sum 호출할 때 num1->10, num2 -> 30
		//실제데이터가 넘어온다.
		//중괄호를 쓰면 return을 반드시 생략해야 한다.
		//타입을 생략(이름만 받아온다.) -> 인터페이스에서 int라고 정의되어 있기 때문에 알아서 int로 인식
		printSumResult((num1, num2) -> num1 + num2);
		//다른 방법
		printSumResult((num1, num2) -> {
			return num1 + num2;
		});


		//void return 시 sysout해도 무관
		//이 케이스는 에러
		//return 타입을 맞춘다면 문제는 no! 타입이 다르면 에러
		//		print((data) -> data + "입니다.");
		//lambda 바디가 여러개 일땐 중괄호를 써야 한다.
		print((data) -> System.out.println(data + "입니다."));
		//위쪽에 있는 인자가 아래쪽에 있는 인자로 전달
		print(System.out::println);
		print((data) -> {
			data += 1;
			System.out.println(data + "입니다.");
		});

		//list롤 간단하게 만들 수가 있다.(java 9부터 들어간 기능)
		List<Integer> intList = List.of(10,20,30,40,50);
		//java 8 이하는
		List<Integer> intList2 = Arrays.asList(10,20,30,40);
		//intlist.forEach-> void를 return
		intList.forEach(System.out::println);
		intList2.forEach(System.out::println);

	}
}
