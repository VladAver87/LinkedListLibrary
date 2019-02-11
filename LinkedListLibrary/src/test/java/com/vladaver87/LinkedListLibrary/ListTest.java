package com.vladaver87.LinkedListLibrary;

import static org.junit.Assert.*;

import org.junit.Test;

public class ListTest {
	List<String> list = new List<String>(null, null);

	@Test
	public void testInserElement() {
		assertNull(list.get(0));		
		
	}


}
