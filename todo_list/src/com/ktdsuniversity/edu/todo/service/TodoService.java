package com.ktdsuniversity.edu.todo.service;

import java.util.List;

import com.ktdsuniversity.edu.todo.dao.TodoDAO;
import com.ktdsuniversity.edu.todo.vo.TodoVO;

public class TodoService {
	
	private TodoDAO todoDAO;
	
	public TodoService() {
		todoDAO = new TodoDAO();
	}
	
	// 등록
	public boolean create(String itemName) {
		return todoDAO.create(itemName) > 0;
	}
	
	// 조회(1건)
	public TodoVO read(int key) {
		return todoDAO.read(key);
	}
	
	// 조회(모든건)
	public List<TodoVO> readAll() {
		return todoDAO.readAll();
	}
	
	// 수정
	public boolean update(int key, boolean isSuccess) {
		return todoDAO.update(key, isSuccess) > 0;
	}
	
	// 삭제(1건)
	public boolean delete(int key) {
		return todoDAO.delete(key) > 0;
	}
	
	// 삭제(모든건)
	public boolean deleteAll() {
		return todoDAO.deleteAll() > 0;
	}
}
