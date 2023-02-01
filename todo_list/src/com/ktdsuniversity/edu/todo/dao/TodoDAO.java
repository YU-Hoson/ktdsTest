package com.ktdsuniversity.edu.todo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ktdsuniversity.edu.todo.vo.TodoVO;

public class TodoDAO {
	
	private static int count=1;
	
	private Map<Integer, TodoVO> dataSource;
	
	public TodoDAO() {
		dataSource = new HashMap<>();
	}
	
	//CRUD를 해주는 일외에는 없다.
	
	//등록
	//heap(static에서 참조는 가능)
	public int create(String itemName) {
		dataSource.put(count++, new TodoVO(itemName));
		return 1;//1건만 시킬 것이다.
	}
	//조회(1건)
	public TodoVO read(int number) {
		return dataSource.get(number);
	}
	//조회(모든건)
	public List<TodoVO> readAll() {
		return dataSource.entrySet()
				.stream()
				.map(entry -> entry.getValue())
				.collect(Collectors.toList());
	}
	//수정
	
	public int update(int key, boolean isSuccess) {
		TodoVO todoVO = dataSource.get(key);
		todoVO.setSuccess(isSuccess);
		return 1;
	}
	//삭제(1건)
	public int delete(int key) {
		dataSource.remove(key);
		return 1;
	}
	//삭제(모든건)
	public int deleteAll() {
		int size = dataSource.size();
		dataSource.clear();
		return size;
	}
}
