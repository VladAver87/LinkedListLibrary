package com.vladaver87.linkedlistlibrary;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Predicate;

public class RecList<T> implements ILinkedList<T> {
	private Element<T> first;
	Element<T> element;

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		if (first == null) {
			result = null;
		}
		return toStringRec(first, result);
	}

	private String toStringRec(Element<T> current, StringBuilder result) {
		if (current != null) {
			if (current.getNext() == null) {
				return toStringRec(current.getNext(), result.append(current.getValue()));
			}
			return toStringRec(current.getNext(), result.append(current.getValue() + ","));
		} else {
			return "[" + result + "]";
		}
	}
	
	@Override
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
			addLastRec(first, element);
		}
	}
	
	private void addLastRec(Element<T> current, Element<T> element) {
		if (current.getNext() == null) {
			current.setNext(element);
		}else {
			addLastRec(current.getNext(), element);
		}
	}
	
	@Override
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

	@Override
	public ILinkedList<T> filter(Predicate<T> p) {
		RecList<T> result = new RecList<>();
		return filterRec(first, p, result);
	}
	
	private ILinkedList<T> filterRec(Element<T> current, Predicate<T> p, RecList<T> result){	
		if (current != null) {
		if (p.test(current.getValue())) {
			result.add(current.getValue());
			return filterRec(current.getNext(), p, result);
		} else {
			return filterRec(current.getNext(), p, result);
		}
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
		RecList<T> result = new RecList<>();
		if (first == null || n == 0) throw new NullPointerException ("List is empty or argument is null");

		return takeRec(first, 0, n, result);
		
	}
	
	private ILinkedList<T> takeRec(Element<T> current, int counter, int elementsToReturn, RecList<T> result){
		if(elementsToReturn == 1) result.add(current.getValue());
		if (counter != elementsToReturn && elementsToReturn > 1) {
			result.add(current.getValue());
			return takeRec(current.getNext(), counter +1, elementsToReturn, result);
		}
		return result.reverse();
	}

	@Override
	public ILinkedList<T> takeWhile(Predicate<T> p) {
		RecList<T> result = new RecList<>();
		return takeWhileRec(first, p, result);
	}
	
	private ILinkedList<T> takeWhileRec(Element<T> current, Predicate<T> p, RecList<T> result) {
		if (current != null) {
		if (p.test(current.getValue())) {
			result.add(current.getValue());
			return takeWhileRec(current.getNext(), p, result);
		}else {
			return takeWhileRec(null, p, result);
		}
		}
		return result.reverse();
	}

	@Override
	public ILinkedList<T> reverse() {
		RecList<T> result = new RecList<>();
		return reverseRec(first, result);
	}
	
	private ILinkedList<T> reverseRec(Element<T> current, RecList<T> result) {
		if(current != null) {
			result.add(current.getValue());
			return reverseRec(current.getNext(), result);
		}
		return result;
	}

	@Override
	public <R> ILinkedList<R> map(Function<T, R> f) {
		RecList<R> result = new RecList<>();
		return mapRec(first, f, result);

	}
	
	private <R> ILinkedList<R> mapRec(Element<T> current, Function<T, R> f, RecList<R> result){
		if (current != null) {
			R newElement = f.apply(current.getValue());
			result.add(newElement);
			return mapRec(current.getNext(), f, result);
		}		
		return result.reverse();
	}

	@Override
	public Iterator<T> iterator() {
		Iterator<T> iterator = new Iterator<T>() {
			
			private Element<T> preFirst = first;
			private Element<T> current = null;
			private Element<T> previous = null;

			@Override
			public boolean hasNext() {
				return preFirst != null;

			}

			@Override
			public T next() {
				if (preFirst == null)
					throw new NoSuchElementException("List is empty");
				T result = preFirst.getValue();
				previous = current;
				current = preFirst;
				preFirst = preFirst.getNext();
				return result;

			}

			@Override
			public void remove() {
				if (first == null) {
					throw new NoSuchElementException("List is empty");
				}

				if (first.getNext() == null) {
					first = first.getNext();

				} if (previous == null){
					Element<T> del = current.getNext();
					current.setValue(del.getValue());
					current.setNext(del.getNext());		
					
				}else {	
					previous.setNext(current.getNext());

				}
			}
		};

		return iterator;
	}

}