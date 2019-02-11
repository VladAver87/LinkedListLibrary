package com.vladaver87.LinkedListLibrary;

public class List<T> {
	private Element<T> element;
	private Element<T> first;
	private Element<T> last;

	public List(Element<T> first, Element<T> last) {
		this.first = first;
		this.last = last;
	}

	public int size() {
		int count = 0;	
		element = first;
		while(element != null) {
			element = element.getNext();
			count++;
		}
		return count;
	}

	public void add(T value) {
		Element<T> element = new Element<T>(value, null);
		if (first == null) {
			first = element;

		} else {
			element.setNext(first);
			first = element;
		}
	}

	public static void main(String[] args) {
		List<String> list = new List<String>(null, null);
		list.add("one");
		list.add("two");
		System.out.print("size" +list.size());
	}

}
