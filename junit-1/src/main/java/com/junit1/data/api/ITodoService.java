package com.junit1.data.api;

import java.util.List;

public interface ITodoService {

	public List<String> retrieveTodos(String user);
	public void deleteTodo(String todo);
	
}
