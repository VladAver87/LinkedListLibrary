package com.vladaver87.LinkedListLibrary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class RecListTest {
	RecList<String> list = new RecList<String>();
	RecList<Integer> listInt = new RecList<Integer>();

	@Test
	public void testInserElement() {
		assertNull(list.get(0));		

	}

	@Test
	public void checkStringElementOrder() {
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		assertEquals(list.get(0), "four");
		assertEquals(list.get(1), "three");
		assertEquals(list.get(2), "two");
		assertEquals(list.get(3), "one");

	}
	
	@Test
	public void checkIntegerElementOrder() {
		listInt.add(1);
		listInt.add(2);
		listInt.add(3);
		listInt.add(4);
		assertEquals(listInt.get(0), Integer.valueOf(4));
		assertEquals(listInt.get(1), Integer.valueOf(3));
		assertEquals(listInt.get(2), Integer.valueOf(2));
		assertEquals(listInt.get(3), Integer.valueOf(1));
		
	}
	
	@Test
	public void checkFillListStringSize() {
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		assertEquals(list.size(), 4);

	}
	
	@Test
	public void checkFillListIntegerSize() {
		listInt.add(1);
		listInt.add(2);
		listInt.add(3);
		listInt.add(4);
		assertEquals(listInt.size(), 4);
		
	}
	
	@Test
	public void checkEmptyListSize() {
		assertEquals(list.size(), 0);
	}
	
	@Test
	public void checkListPrint() {
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		String result = "[four,three,two,one]";
		assertEquals(list.toString(), result);
	}
}
