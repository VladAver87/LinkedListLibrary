package com.vladaver87.LinkedListLibrary;

import static org.junit.Assert.*;
import org.junit.Test;

import com.vladaver87.linkedlistlibrary.ILinkedList;
import com.vladaver87.linkedlistlibrary.LoopList;

public class LoopListTest {
	LoopList<String> list = new LoopList<String>();
	LoopList<Integer> listInt = new LoopList<Integer>();

	@Test
	public void testInserElement() {
		assertEquals(null, list.get(0));		

	}

	@Test
	public void checkStringElementOrder() {
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		assertEquals("four", list.get(0));
		assertEquals("three", list.get(1));
		assertEquals("two", list.get(2));
		assertEquals("one", list.get(3));

	}
	
	@Test
	public void checkIntegerElementOrder() {
		listInt.add(1);
		listInt.add(2);
		listInt.add(3);
		listInt.add(4);
		assertEquals(Integer.valueOf(4), listInt.get(0));
		assertEquals(Integer.valueOf(3), listInt.get(1));
		assertEquals(Integer.valueOf(2), listInt.get(2));
		assertEquals(Integer.valueOf(1), listInt.get(3));
		
	}
	
	@Test
	public void checkFillListStringSize() {
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		assertEquals(4, list.size());

	}
	
	@Test
	public void checkFillListIntegerSize() {
		listInt.add(1);
		listInt.add(2);
		listInt.add(3);
		assertEquals(3, listInt.size());
		
	}
	
	@Test
	public void checkEmptyListSize() {
		assertEquals(0, list.size());
	}
	
	@Test
	public void checkListPrint() {
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		String result = "[four,three,two,one]";
		assertEquals(result, list.toString());
	}
	
	@Test
	public void checkListIntegerPrint() {
		listInt.add(1);
		listInt.add(2);
		listInt.add(3);
		listInt.add(4);
		String result = "[4,3,2,1]";
		assertEquals(result, listInt.toString());
	}
	
	@Test
	public void printIfOneElement() {
		list.add("one");
		String result = "[one]";
		assertEquals(result, list.toString());
	}
	
	@Test
	public void printIfNullElement() {
		String result = "[null]";
		assertEquals(result, list.toString());
	}
	
	@Test
	public void checkFilterOneElement() {
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		String result = "[one]";
		LoopList<String> testList = list.filter(x -> x.equals("one"));
		assertEquals(result, testList.toString());
	}
	
	@Test
	public void checkFilter() {
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		String result = "[one,three]";
		LoopList<String> testList = list.filter(x -> x.equals("one") || x.equals("three"));
		assertEquals(result, testList.toString());
	}
	
	@Test
	public void reverseCheck() {
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		String result = "[one,two,three,four]";
		assertEquals(result, list.reverse().toString());
	}
	
	@Test
	public void checkTake() {
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		String result = "[four,three,two]";
		assertEquals(result, list.take(3).toString());
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
		assertEquals(result, testList.toString());
	}
	
	@Test
	public void checkMap() {
		list.add("one");
		list.add("two");
		String result = "[two1,one1]";
		ILinkedList<String> testList = list.map(x -> x + "1");
		assertEquals(result, testList.toString());
	}
	
	@Test
	public void checkAddLast() {	
		for (int i = 0; i <= 10; i++) {
			listInt.addLast(i);
		}
		String result = "[0,1,2,3,4,5,6,7,8,9,10]";
		assertEquals(result, listInt.toString());
	}
	
	@Test
	public void addLastTimeTest() {
		long start = System.currentTimeMillis();
		for (int i = 0; i <= 10000; i++) {
			listInt.addLast(i);
		}
		long finish = System.currentTimeMillis();
		long time = finish - start;
		System.out.println("Time to add elements at the end of the list is " +time + " ms");
	}
	
}
