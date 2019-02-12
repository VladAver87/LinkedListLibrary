package com.vladaver87.LinkedListLibrary;

public class List<T> {
	private Element<T> element;
	private Element<T> first;

	public int size() {
		int count = 0;
		element = first;
		while (element != null) {
			element = element.getNext();
			count++;
		}
		return count;
	}

	public T get(int i) {
		if (first == null) return null;
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
}
