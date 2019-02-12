package com.vladaver87.LinkedListLibrary;

import static org.junit.Assert.*;

import org.junit.Test;

public class ListTest {
	List<String> list = new List<String>(null, null);
	List<Integer> listInt = new List<Integer>(null, null);

	@Test
	public void testInserElement() {
		assertNull(list.get(0));		
		assertNull(listInt.get(0));
	}

	@Test
	public void checkElementOrder() {
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		listInt.add(1);
		listInt.add(2);
		listInt.add(3);
		listInt.add(4);
		assertEquals(list.get(0), "four");
		assertEquals(list.get(1), "three");
		assertEquals(list.get(2), "two");
		assertEquals(list.get(3), "one");
		assertEquals(listInt.get(0), Integer.valueOf(4));
		assertEquals(listInt.get(1), Integer.valueOf(3));
		assertEquals(listInt.get(2), Integer.valueOf(2));
		assertEquals(listInt.get(3), Integer.valueOf(1));
	}
	
	@Test
	public void checkFillListSize() {
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		listInt.add(1);
		listInt.add(2);
		listInt.add(3);
		listInt.add(4);
		assertEquals(list.size(), 4);
		assertEquals(listInt.size(), 4);
	}
	
	@Test
	public void checkEmptyListSize() {
		assertEquals(list.size(), 0);
	}
}
