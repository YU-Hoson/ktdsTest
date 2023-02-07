package com.ktdsuniversity.edu.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BaseballStream2 {

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
		//		//에러 발생시 비어있는 리스트를 반환
		catch (IOException ioe) {
			ioe.printStackTrace();
			return new ArrayList<>();
		}
	}


	public static void main(String[] args) {
		List<AllStarFullVO> list = readAllStarFull();

		//1. 1933년 NYA팀의 세 번째 선수의 playerID를 출력
		Optional<String> playerID = list.stream()
				.filter(vo -> vo.getYear().equals("1933"))
				.filter(vo -> vo.getTeamID().equals("NYA"))
				.map(vo -> vo.getPlayerID())
				.skip(2)
				.limit(1)
				.findFirst();

		System.out.println(playerID.orElse("없음"));


		//2. 1700년 NYA팀의 세번째 선수의 playerID를 출력
		Stream<AllStarFullVO> listStream = list.stream();

		//데이터가 없으므로 실행은 하지만 없는 걸로 처리
		//null로 input
		Stream<AllStarFullVO> playersIn1700 = 
				listStream.filter(vo -> vo.getYear().equals("1700"));

		Stream<AllStarFullVO> playersInNYA = 
				playersIn1700.filter(vo -> vo.getTeamID().equals("NYA"));

		//결과가 String-stream임을 알수가 있다.
		//vo -> AllS
		//Optional 사용? -> 1700년도가 없음에도 불구하고 출력을 하고자 해서 사용한 것이다.
		Stream<String> playersId = playersInNYA.map(vo -> vo.getPlayerID());


		Stream<String> skipedPlayersId = playersId.skip(2);

		Stream<String> limitedPlayersId = skipedPlayersId.limit(1);

		Optional<String> playerId = limitedPlayersId.findFirst();

		System.out.println(playerId.orElse("없음"));




		//3. 1934년 CHA startingPos가 8인 선수의 playerID를 출력
		Optional<String> playedId = list.stream()
				.filter(vo -> vo.getYear().equals("1934"))
				.filter(vo -> vo.getStartingPos() == 8)
				.filter(vo -> vo.getTeamID().equals("CHA"))
				.map(vo -> vo.getPlayerID())
				.findAny();

		System.out.println(playedId.orElse("없음"));


		//4. 1934년 CHA 팀에서 startingPos가 8인 두번째 선수의 playerID 출력
		Optional<String> playerId2 = list.stream()
				.filter(vo -> vo.getYear().equals("1934"))
				.filter(vo -> vo.getStartingPos() == 8)
				.filter(vo -> vo.getTeamID().equals("CHA"))
				.map(vo -> vo.getPlayerID())
				.skip(2)
				.limit(2)
				.findFirst();
		//		System.out.println(playerId2.orElse("없음"));




		//5-1. 1933년 출전한 TeamID별 playerID를 모두 출력(group)
		//		Optional<String> teamID = list.stream()
		//				                      .filter(vo -> vo.getYear().equals("1933"))
		//				                      .collect()
		//		Map<String, List<AllStarFullVO>> teamMap1 = list.stream()
		//				                                       .filter(vo -> vo.getYear().equals("1933"))
		//				                                        .collect(Collectors.groupingBy(AllStarFullVO::getTeamID));
		//		
		//		
		//		System.out.println(teamMap1);
		//		
		//		
		//		teamMap1.forEach((teamId, players) -> {
		//			players.stream()
		//			       .map(vo -> vo.getPlayerID())
		//			       .forEach((playerId2) -> {
		//			    	   System.out.println("5-1. " +
		//			                       teamID + ">" + playerId2);
		//			       });
		//		
		//		
		//		teamMap1.forEach((key,value) -> {
		//			for (AllStarFullVO allStarFullVO : value) {
		//				System.out.println("5-1. "
		//						            + key
		//						            + ">" + allStarFullVO.getPlayerID());
		//			}
		//		});







		//5-2. 1933년에 출전한 teamID별 playerID의 수를 모두 출력


		//6. TeamID별 출전 연도를 모두 출력(group)
//		Map<String, List<AllStarFullVO>> collect_team = list.stream()
//				.collect(Collectors.groupingBy(AllStarFullVO::getTeamID));
//		
//		collect_team.forEach((teamId, valueList) -> {
//			valueList.stream()
//			         .map(vo -> vo.getYear())
//			         .forEach( (year) ->  {
//			        	 System.out.println("6. " + teamId + ">" + year);
//			});
//		});
		
		
		
		//7. TeamID별 출전 연도를 중복제거 후 모두출력(group)
		Map<String, List<AllStarFullVO>> collect_team2 = list.stream()
				                                            .collect(Collectors.groupingBy(AllStarFullVO::getTeamID));

		collect_team2.forEach((teamId, valueList) -> {
			valueList.stream()
			         .map(vo -> vo.getYear())
			         .distinct()
			         .forEach( (year) ->  {
			        	 System.out.println("6. " + teamId + ">" + year);
			});
		});

	}


}