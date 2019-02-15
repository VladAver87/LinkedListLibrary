package com.vladaver87.LinkedListLibrary;

public class RecList<T> implements ILinkedList<T> {
	private Element<T> first;

	@Override
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

	public void add(T value) {
		Element<T> element = new Element<T>(value, null);
		if (first == null) {
			first = element;

		} else {
			element.setNext(first);
			first = element;
		}

	}

	public T get(int i) {
		if (first == null)
			return null;
		if (i != 0) {
			return getRec(first.getNext(), 1, i);
		} else {
			return first.getValue();
		}
	}

	private T getRec(Element<T> current, int counter, int elementNumber) {
		if (counter != elementNumber) {
			return getRec(current.getNext(), counter + 1, elementNumber);
		} else {
			return current.getValue();
		}
	}
}
