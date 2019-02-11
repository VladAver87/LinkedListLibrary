package com.vladaver87.LinkedListLibrary;

public class List<T> {
	private Element<T> element;
	private Element<T> first;
	private Element<T> last;
	private int n;

	public List(Element<T> first, Element<T> last, int n) {
		this.first = first;
		this.last = last;
		this.n = n;
	}

//	@Override
//	public String toString() {
//		return "Element" + element;
//	}

	public int size() {
		return n;
	}

	public void print(List<String> list) {
		
			while (first.getNext() != null) {
				System.out.println(first);
			}
	}

	public void add(T value) {
		Element<T> element = new Element<T>(value, null);
		if (first == null) {
			first = element;

		} else {
			element.setNext(first);
			first = element;
		}
		n++;
	}

	public static void main(String[] args) {
		List<String> list = new List<String>(null, null, 0);
		list.add("one");
		list.add("two");
		list.print(list);
	}

}
