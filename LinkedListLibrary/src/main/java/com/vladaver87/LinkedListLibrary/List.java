package com.vladaver87.LinkedListLibrary;

public class List<T> {
	private Element<T> element;
	private Element<T> first;

//	public String toString() {
//		element = first;
//		String result = "";
//		String last = "";
//		while (element != null) {
//			result += element.getValue() + ",";
//			element = element.getNext();
//			if (element.getNext() == null) {
//				last = (String) element.getValue();
//				result += last;
//				break;
//			}
//		}
//		return "[" + result + "]";
//	}

//	public int size() {
//		int count = 0;
//		element = first;
//		while (element != null) {
//			element = element.getNext();
//			count++;
//		}
//		return count;
//	}
	
	public String toString() {
		return toStringRec(first, "");
	}
	
	private String toStringRec(Element<T> current, String result) {		
		if (current != null) {
			if (current.getNext() == null) {
			return toStringRec(current.getNext(), result += current.getValue());
			}
			return toStringRec(current.getNext(), result += current.getValue() + ",");
		} else {
			return "[" + result + "]";
		}
	}

	public int size() {
		return sizeRec(first, 0);
	}

	private int sizeRec(Element<T> current, int currentSize) {
		if (current != null) {
			return sizeRec(current.getNext(), currentSize + 1);
		} else {
			return currentSize;
		}
	}

	public T get(int i) {
		if (first == null)
			return null;
		int count = 0;
		if (i == 0)
			return first.getValue();
		element = first;
		while (element != null) {
			element = element.getNext();
			count++;
			if (count == i) {
				break;
			}
		}
		return element.getValue();
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

//	public static void main(String[] args) {
//		List<String> list = new List<String>();
//		list.add("one");
//		list.add("two");
//		list.add("three");
//		list.add("four");
//		System.out.println(list.size());
//	}
}
