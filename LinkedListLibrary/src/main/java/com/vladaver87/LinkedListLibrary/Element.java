package com.vladaver87.LinkedListLibrary;


public class Element<T> {
	private T element;
	private Element<T> next;
	
	public Element(T element, Element<T> next) {
		this.element = element;
		this.next = next;
	}
	
	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public Element<T> getNext() {
		return next;
	}

	public void setNext(Element<T> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Element" +  " " + element;
	}
	
}
