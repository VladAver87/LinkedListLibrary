package com.vladaver87.linkedlistlibrary;

import java.util.function.Predicate;
import java.util.function.Function;

public interface ILinkedList<T> {
	public int size();
	public void add(T value);
	public T get(int i);
	public ILinkedList<T> filter(Predicate<T> p);
	public ILinkedList<T> reverse();
	public ILinkedList<T> take(int n);
	public ILinkedList<T> takeWhile(Predicate<T> p);
	public <R> ILinkedList<R> map(Function<T, R> f);
	public void addLast(T value);

}
