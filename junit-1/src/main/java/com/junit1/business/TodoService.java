package com.junit1.business;

import java.util.ArrayList;
import java.util.List;

import com.junit1.data.api.ITodoService;

public class TodoService {
	
	private ITodoService todoService;

	TodoService(ITodoService todoService) {
		this.todoService = todoService;
	}

	public List<String> retrieveSpringTodos(String user) {
		List<String> filteredTodos = new ArrayList<String>();
		List<String> todos = todoService.retrieveTodos(user);
		for (String todo : todos) {
			if (todo.contains("Spring")) {
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}
	
	public void deleteTodosNotRelatedToSpring(String user) {
		List<String> todos = todoService.retrieveTodos(user);
		for (String todo : todos) {
			if (!todo.contains("Spring")) {
				todoService.deleteTodo(todo);
			}
		}
	}
	
}
