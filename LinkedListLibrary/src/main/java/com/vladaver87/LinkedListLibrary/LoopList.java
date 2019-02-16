package com.vladaver87.LinkedListLibrary;

public class LoopList<T> implements ILinkedList<T> {
	private Element<T> element;
	private Element<T> first;
	
	@FunctionalInterface
	public interface Predicate<T> {
		boolean test(T value);
	}

	@Override
	public String toString() {
		element = first;
		String result = "";
		String last = "";
		while (element != null) {
			if (element.getNext() == null) {
				last = (String) element.getValue();
				result += last;
				break;
			}
			result += element.getValue() + ",";
			element = element.getNext();
		}
		return "[" + result + "]";
	}

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

	public LoopList<T> filter(Predicate<T> predicate) {
		LoopList<T> result = new LoopList<T>();
		element = first;
		while (element != null) {
			if (predicate.test(element.getValue())) {
				result.add(element.getValue());
			}
			element = element.getNext();
		}
		return result;
	}

	public void reverse() {
		Element<T> current = null;
		Element<T> prev = null;
		Element<T> temp = first;

		while (temp != null) {
			current = temp;
			temp = temp.getNext();
			
			current.setNext(prev);
			prev = current;
			first = current;
		}
	}
	
	

}
