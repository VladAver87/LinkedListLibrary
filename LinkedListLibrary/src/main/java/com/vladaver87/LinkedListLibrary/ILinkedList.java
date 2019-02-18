package com.vladaver87.LinkedListLibrary;

import java.util.function.Predicate;

public interface ILinkedList<T> {
	public int size();
	public void add(T value);
	public T get(int i);
	public ILinkedList<T> filter(Predicate<T> p);
	public void reverse();
	public ILinkedList<T> take(int n);
	public ILinkedList<T> takeWhile(Predicate<T> p);

}
