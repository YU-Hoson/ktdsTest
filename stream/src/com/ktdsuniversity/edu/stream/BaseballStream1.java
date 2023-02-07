package com.ktdsuniversity.edu.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballStream1 {

	public static List<AllStarFullVO> readAllStarFull() {

		//list string을 리턴
		//map -> String타입의 Stream이 변동

		try {
			List<AllStarFullVO> list = Files.readAllLines(Paths.get("C:\\devs\\data\\baseball\\core\\AllstarFull.csv"))
					.stream()
					//첫번째 라인은 건너뛰고 다음 라인으로 가라
					.skip(1)
					//중간에 데이터가 어떻게 처리되고 있는가를 임시로 확인
					//debuging 매우 힘듬
					.peek(System.out::println)
					.map( (line) -> {
						String[] strArr = line.split(",");
						AllStarFullVO vo = new AllStarFullVO();
						vo.setPlayerID(strArr[0]);
						vo.setYear(strArr[1]);
						vo.setGameNum(Integer.parseInt(strArr[2]));
						vo.setGameID(strArr[3]);
						vo.setTeamID(strArr[4]);
						vo.setLgID(strArr[5]);
						vo.setGp(Integer.parseInt(strArr[6]));
						if(strArr.length == 8) {
							vo.setStartingPos(Integer.parseInt(strArr[7]));
						}
						else {
							vo.setStartingPos(0);
						}

						return vo;
					})
					.collect(Collectors.toList());
			return list;
		} 
		//에러 발생시 비어있는 리스트를 반환
		catch (IOException ioe) {
			ioe.printStackTrace();
			return new ArrayList<>();
		}
	}

	public static void main(String[] args) {
		List<AllStarFullVO> list = readAllStarFull();
		//parallelStream => 병렬처리 스트림
		//중괄호가 없으므로 return
		list.stream()
			.filter( (vo) -> vo.getYear().equals("1933"))
			.forEach( (vo) -> {
				System.out.println(vo.getPlayerID());
				System.out.println(vo.getYear());
		});


		//for-each또는 stream 둘 중 하나를 선택
		//		List<AllStarFullVO> playIn1933 = list.stream()
		//				.filter( (vo) -> vo.getYear().equals("1933") )
		//				.collect(Collectors.toList());

		//필터를 해서 첫번째 데이터를 가지고 와라
		//Optional를 준다.
		//엄청나게 많이 쓰이는 함수
		//		AllStarFullVO vo = list.stream()
		//				.filter( (vo1)-> vo1.getYear().equals("1933"))
		//최종함수(Optional 함수)
		//에러가 있으면 다른 걸로 바꿔주는 기능이 있다.
		//				.findFirst()
		//				.get();
		//				.orElse(new AllStarFullVO());

		//		System.out.println(vo.getPlayerID());


		//연도에 관계없이 플레이어의 아이디가 f로 시작한다.
		//웹에플리케이션에서 구성하는 환경변수를 DB에 넣는데
		//비번규칙?-> 코드를 짠다.(실무)
		//데이터에서 불필요한 데이터를 없앨 때
		//		List<AllStarFullVO> list = readAllStarFull();
		//		list.stream().filter( (vo) -> vo.getPlayerID().startsWith("F"))
		//		.forEach( (vo) -> {
		//			System.out.println(vo.getPlayerID());
		//		});
		//		
		//		
		//		
		//		System.out.println("-----------------------------");
		//		
		//		list.stream().filter( (vo) -> vo.getYear().equals("2004"))
		//		.filter( (vo) -> vo.getTeamID().equals("TEX"))
		//		.forEach( (vo) -> {
		//			System.out.println(vo.getPlayerID());
		//			System.out.println(vo.getYear());
		//			System.out.println(vo.getTeamID());
		//		});


		///starting pos==0인 것만 출력
		//		List<AllStarFullVO> list = readAllStarFull();
		//		list.stream().filter( (vo) -> vo.getStartingPos()==0)
		//		.forEach( (vo -> {
		//			System.out.println(vo.getPlayerID());
		//			System.out.println(vo.getTeamID());
		//		});


		//gp==0 teamID==NYA playerID=f5가 다출력 "fo"
		//		List<AllStarFullVO> list2 = readAllStarFull();
		//		list2.stream().filter( (vo) -> vo.getGp()==0 && vo.getTeamID().equals("NYA") && vo.getPlayerID().startsWith("f") || vo.getPlayerID().startsWith("o"))
		//		.forEach( (vo) -> {
		//			System.out.println(vo.getGp());
		//			System.out.println(vo.getTeamID());
		//			System.out.println(vo.getPlayerID());
		//		});

		//		List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);
		//		numbers.stream()
		//		.filter(i -> i%2==0)
		//		.distinct();


		//map은 function으로 사용
		//중복제거
		//중복이 되는 데이터만 가져와서 리스트에 넣는다.
		//		System.out.println("------------------------------");

		//		List<String> playerNameList =list.stream()
		//				.map( (vo) -> vo.getPlayerID() )
		//				.distinct()
		//				.sorted()
		//				.collect(Collectors.toList());

		//		System.out.println(playerNameList.size());
		//		playerNameList.forEach(System.out::println);


		//startingPos = 4 가져와서 playerId만 추출 중복제거 정렬까지 해서 출력
		//		List<String> playerNameList = list.stream()
		//				.filter( (vo) -> vo.getStartingPos() == 4)
		//				.map( (vo) -> vo.getPlayerID())
		//				.distinct()
		//				.sorted()
		//				.collect(Collectors.toList());
		//		
		//		playerNameList.forEach(System.out::println);


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//9. lambda 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//19년도 이름A nya 포지션 3 정렬 중복 정리 map 중봇정리 foreach 이름,년도,번호

	}
}
