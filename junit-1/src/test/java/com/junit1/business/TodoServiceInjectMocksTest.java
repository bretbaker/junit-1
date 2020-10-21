package com.junit1.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;

import com.junit1.data.api.ITodoService;

//@RunWith(MockitoJUnitRunner.class)
public class TodoServiceInjectMocksTest {
	
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Mock
	ITodoService iTodoServiceMock;
	
	@InjectMocks
	TodoService todoService;
	
	@Captor
	ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
	
//	public static ITodoService iTodoServiceMock = mock(ITodoService.class);
//	public static TodoService todoService = new TodoService(iTodoServiceMock);

	@Test
	public void test_retrieve_todos_related_to_spring() {
		List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		when(iTodoServiceMock.retrieveTodos("dummy")).thenReturn(allTodos);
		List<String> filteredTodos = todoService.retrieveSpringTodos("dummy");
		assertEquals(2, filteredTodos.size());
	}
	
	@Test
	public void test_retrieve_todos_with_empty_list() {
		List<String> allTodos = Arrays.asList();
		when(iTodoServiceMock.retrieveTodos("dummy")).thenReturn(allTodos);
		List<String> filteredTodos = todoService.retrieveSpringTodos("dummy");
		assertEquals(0, filteredTodos.size());
	}
	
	@Test
	public void test_retrieve_todos_with_empty_list_using_bdd() {
//		given
		List<String> allTodos = Arrays.asList();
		when(iTodoServiceMock.retrieveTodos("dummy")).thenReturn(allTodos);
//		when
		List<String> filteredTodos = todoService.retrieveSpringTodos("dummy");
//		then
		assertEquals(0, filteredTodos.size());
	}
	
	@Test
	public void test_delete_todos_Unrelated_to_spring_using_bdd() {
//		given
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		when(iTodoServiceMock.retrieveTodos("dummy")).thenReturn(todos);
//		when
		todoService.deleteTodosNotRelatedToSpring("dummy");
//		then
		verify(iTodoServiceMock, times(1)).deleteTodo("Learn to Dance");
		verify(iTodoServiceMock, never()).deleteTodo("Learn Spring MVC");
	}
	
	@Test
	public void test_delete_todos_Unrelated_to_spring_using_bdd_and_argument_capture() {
//		given
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		when(iTodoServiceMock.retrieveTodos("dummy")).thenReturn(todos);
//		when
		todoService.deleteTodosNotRelatedToSpring("dummy");
//		then
		verify(iTodoServiceMock, times(2)).deleteTodo(stringArgumentCaptor.capture());
		assertEquals(stringArgumentCaptor.getValue(), "Learn to Dance");
	}

}
