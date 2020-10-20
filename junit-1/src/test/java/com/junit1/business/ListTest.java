package com.junit1.business;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Test;

public class ListTest {
	
	public static List listMock = mock(List.class);

	@Test
	public void mock_list_size_basic() {
		when(listMock.size()).thenReturn(2);
		assertEquals(2, listMock.size());
	}
	
	@Test
	public void mock_list_size_return_multiple_values() {
		when(listMock.size()).thenReturn(2).thenReturn(3);
		assertEquals(2, listMock.size());
		assertEquals(3, listMock.size());
	}
	
	@Test
	public void mock_list_get_basic() {
		when(listMock.get(0)).thenReturn("string");
		assertEquals("string", listMock.get(0));
		assertEquals(null, listMock.get(1));
	}
	
	@Test
	public void mock_list_get_any_int() {
		when(listMock.get(anyInt())).thenReturn("string");
		assertEquals("string", listMock.get(0));
		assertEquals("string", listMock.get(1));
	}
	
	@Test(expected = AssertionError.class)
	public void mock_list_throw_exception() {
		when(listMock.get(anyInt())).thenReturn("string");
		assertEquals("string", listMock.get(0));
		assertEquals(null, listMock.get(1));
	}

}
