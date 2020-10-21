package com.junit1;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class HamcrestMatcherTest {

	@Test
	public void test() {
		List<Integer> scores = Arrays.asList(99, 100, 101, 105);
		assertThat(scores, hasSize(4));
		assertThat(scores, hasItems(99, 100));
		assertThat(scores, everyItem(greaterThan(90)));
		assertThat("", isEmptyString());
		assertThat(null, nullValue());
		Integer[] marks = { 1, 2, 3 };
		assertThat(marks,  arrayWithSize(3));
		assertThat(marks, arrayContaining(1, 2, 3));
		assertThat(marks, arrayContainingInAnyOrder(3, 2, 1));
	}

}
