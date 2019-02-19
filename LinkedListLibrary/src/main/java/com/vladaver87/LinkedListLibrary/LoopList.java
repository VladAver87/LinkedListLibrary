package com.vladaver87.LinkedListLibrary;

import java.util.function.Function;
import java.util.function.Predicate;

public class LoopList<T> implements ILinkedList<T> {
	private Element<T> element;
	private Element<T> first;

	@Override
	public String toString() {
		element = first;
		String result = "";
		T last = (T) "";
		while (element != null) {
			if (element.getNext() == null) {
				last = element.getValue();
				result += last;
				break;
			}
			result += element.getValue() + ",";
			element = element.getNext();
		}
		return "[" + result + "]";
	}

	@Override
	public int size() {
		int count = 0;
		element = first;
		while (element != null) {
			element = element.getNext();
			count++;
		}
		return count;
	}

	@Override
	public T get(int i) {
		if (i == 0 & first == null)
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

	@Override
	public void add(T value) {
		Element<T> element = new Element<T>(value, null);
		if (first == null) {
			first = element;

		} else {
			element.setNext(first);
			first = element;
		}
	}

	@Override
	public LoopList<T> filter(Predicate<T> p) {
		LoopList<T> result = new LoopList<T>();
		element = first;
		while (element != null) {
			if (p.test(element.getValue())) {
				result.add(element.getValue());
			}
			element = element.getNext();
		}
		return result;
	}

	public void reverseOld() {
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

	@Override
	public ILinkedList<T> take(int n) {
		LoopList<T> result = new LoopList<T>();
		if (first == null || n == 0)
			throw new NullPointerException("List is empty or argument is null");
		if (n == 1) {
			result.add(first.getValue());
		}
		element = first;
		int counter = 0;
		while (element != null) {
			if (counter != n & n > 1) {
				counter++;
				result.add(element.getValue());
				element = element.getNext();
			} else
				break;
		}
		return result.reverse();
	}

	@Override
	public ILinkedList<T> takeWhile(Predicate<T> p) {
		LoopList<T> result = new LoopList<T>();
		element = first;
		while (element != null) {
			if (p.test(element.getValue())) {
				result.add(element.getValue());
			} else {
				break;
			}
			element = element.getNext();
		}
		return result.reverse();
	}

	@Override
	public ILinkedList<T> reverse() {
		LoopList<T> result = new LoopList<T>();
		element = first;
		while (element != null) {
			result.add(element.getValue());
			element = element.getNext();
		}
		return result;
	}

	@Override
	public <R> ILinkedList<T> map(Function<T, R> f) {
		LoopList<T> result = new LoopList<T>();
		element = first;
		while (element != null) {
			result.add((T) f.apply(element.getValue()));
			element = element.getNext();
		}
		return result.reverse();
	}

}
