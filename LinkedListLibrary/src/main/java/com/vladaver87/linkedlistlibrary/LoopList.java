package com.vladaver87.linkedlistlibrary;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Predicate;

public class LoopList<T> implements ILinkedList<T> {
	private Element<T> element;
	private Element<T> first;

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		element = first;
		if (element == null)
			result = null;
		while (element != null) {
			if (element.getNext() == null) {
				T last = element.getValue();
				result.append(last);
				break;
			}
			result.append(element.getValue() + ",");
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
		int count = 0;
		element = first;
		T value = null;
		if (first == null)
			return value;
		if (i == 0)
			value = first.getValue();
		while (element != null) {
			element = element.getNext();
			count++;
			if (count == i) {
				value = element.getValue();
				break;
			}
		}
		return value;
	}

	@Override
	public void add(T value) {
		element = new Element<>(value, null);
		if (first == null) {
			first = element;

		} else {
			element.setNext(first);
			first = element;
		}
	}

	@Override
	public void addLast(T value) {
		element = new Element<>(value, null);
		if (first == null) {
			first = element;

		} else {
			Element<T> current = first;
			while (current != null) {
				if (current.getNext() == null) {
					current.setNext(element);
					break;
				}
				current = current.getNext();
			}
		}
	}

	@Override
	public LoopList<T> filter(Predicate<T> p) {
		LoopList<T> result = new LoopList<>();
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
		LoopList<T> result = new LoopList<>();
		if (first == null || n == 0)
			throw new NullPointerException("List is empty or argument is null");
		if (n == 1) {
			result.add(first.getValue());
		}
		element = first;
		int counter = 0;
		while (element != null) {
			if (counter != n && n > 1) {
				counter++;
				result.add(element.getValue());
				element = element.getNext();
			} else {
				break;
			}
		}
		return result.reverse();
	}

	@Override
	public ILinkedList<T> takeWhile(Predicate<T> p) {
		LoopList<T> result = new LoopList<>();
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
		LoopList<T> result = new LoopList<>();
		element = first;
		while (element != null) {
			result.add(element.getValue());
			element = element.getNext();
		}
		return result;
	}

	@Override
	public <R> ILinkedList<R> map(Function<T, R> f) {
		LoopList<R> result = new LoopList<>();
		element = first;
		while (element != null) {
			R newElement = f.apply(element.getValue());
			result.add(newElement);
			element = element.getNext();
		}
		return result.reverse();
	}

	@Override
	public Iterator<T> iterator() {
		Iterator<T> iterator = new Iterator<T>() {

			private Element<T> current = first;
			private int counter = -1;

			@Override
			public boolean hasNext() {
				return current != null;

			}

			@Override
			public T next() {
				if (current == null) throw new NoSuchElementException("List is empty");
				T result = current.getValue();
				current = current.getNext();
				counter++;
				return result;
			}

			@Override
			public void remove() {
	
				remove(counter);
			}
			
			public T remove(int position) {
				T returnElement = null;
				if(position < 0) {
					return null;
				}
				
				if (position == 0) {
					returnElement  = first.getValue();
					first = first.getNext();
				}else {
					Element<T> previous = first;
					for (int i = 0; i < position - 1; i++) {
						previous = previous.getNext();
					}
					
					Element<T> toDelete = previous.getNext();
					returnElement = toDelete.getValue();
					previous.setNext(toDelete.getNext());
					toDelete.setNext(null);
					counter--;
				}
				return returnElement;
				
			}

		};

		return iterator;
	}

	public static void main(String[] args) {
		LoopList<String> list = new LoopList<>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		
		
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String temp = it.next();
			if(temp.equals("three")) {
				it.remove();
				break;
			}
		}
			list.forEach(System.out::println);
	}

}
