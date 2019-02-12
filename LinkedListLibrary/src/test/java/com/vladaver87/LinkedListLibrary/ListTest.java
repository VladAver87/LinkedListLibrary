package com.vladaver87.LinkedListLibrary;

import static org.junit.Assert.*;

import org.junit.Test;

public class ListTest {
	List<String> list = new List<String>(null, null);
	

	@Test
	public void testInserElement() {
		assertNull(list.get(0));		
		
	}
	@Test
	public void addElement() {
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
	}
	@Test
	public void checkElementOrder() {
		assertEquals(list.get(0), "four");
		assertEquals(list.get(1), "three");
		assertEquals(list.get(2), "two");
		assertEquals(list.get(3), "one");
	}

}
