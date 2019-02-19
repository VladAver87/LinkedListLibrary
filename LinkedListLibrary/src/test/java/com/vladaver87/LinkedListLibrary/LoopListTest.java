package com.vladaver87.LinkedListLibrary;

import static org.junit.Assert.*;
import org.junit.Test;

public class LoopListTest {
	LoopList<String> list = new LoopList<String>();
	LoopList<Integer> listInt = new LoopList<Integer>();

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
	
	@Test
	public void checkListIntegerPrint() {
		listInt.add(1);
		listInt.add(2);
		listInt.add(3);
		listInt.add(4);
		String result = "[4,3,2,1]";
		assertEquals(listInt.toString(), result);
	}
	
	@Test
	public void printIfOneElement() {
		list.add("one");
		String result = "[one]";
		assertEquals(list.toString(), result);
	}
	
	@Test
	public void checkFilterOneElement() {
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		String result = "[one]";
		LoopList<String> testList = list.filter(x -> x.equals("one"));
		assertEquals(testList.toString(), result);
	}
	
	@Test
	public void checkFilter() {
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		String result = "[one,three]";
		LoopList<String> testList = list.filter(x -> x.equals("one") || x.equals("three"));
		assertEquals(testList.toString(), result);
	}
	
	@Test
	public void reverseCheck() {
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		String result = "[one,two,three,four]";
		assertEquals(list.reverse().toString(), result);
	}
	
	@Test
	public void checkTake() {
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		String result = "[four,three,two]";
		assertEquals(list.take(3).toString(), result);
	}
	
	@Test
	public void checkTakeWhile() {
		listInt.add(1);
		listInt.add(2);
		listInt.add(12);
		listInt.add(4);
		listInt.add(2);
		listInt.add(2);
		listInt.add(1);
		listInt.add(1);
		String result = "[1,1,2,2]";
		ILinkedList<Integer> testList = listInt.takeWhile(x -> x < 3);
		assertEquals(testList.toString(), result);
	}
	
	@Test
	public void checkMap() {
		listInt.add(3);
		listInt.add(4);
		String result = "[14,13]";
		ILinkedList<Integer> testList = listInt.map(x -> x + 10);
		assertEquals(testList.toString(), result);
	}
	
}
