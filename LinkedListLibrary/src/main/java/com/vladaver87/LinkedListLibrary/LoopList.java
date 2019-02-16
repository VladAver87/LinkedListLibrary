package com.vladaver87.LinkedListLibrary;

public class LoopList<T> implements ILinkedList<T>{
	private Element<T> element;
	private Element<T> first;

	public interface IPredicate<T>{
		boolean apply(T value);
	}
	
	@Override
	public String toString() {
		element = first;
		String result = "";
		String last = "";
		while (element != null) {
			result += element.getValue() + ",";
			element = element.getNext();
			if (element.getNext() == null) {
				last = (String) element.getValue();
				result += last;
				break;
			}
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
	
	public LoopList<T> filter(IPredicate<T> predicate){
		LoopList<T> result = new LoopList<T>();
		element = first;
		while (element.getNext() == null) {
			if (predicate.apply(element.getValue())){
				result.add(element.getValue());
			}
			element = element.getNext();
		}
		return result;		
	}
	

}
