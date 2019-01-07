package com.solo;

import java.util.LinkedList;

/**
 * @Author gaojian
 * @Date 2018/10/17
 */
public class MyStack<T> {
    private LinkedList<T> storage = new LinkedList<T>();

    public synchronized void push(T e) {//需要加上同步
        storage.addFirst(e);
    }

    public T peek() {
        return storage.getFirst();
    }

    public void pop() {
        storage.removeFirst();
    }

    public boolean empty() {
        return storage.isEmpty();
    }

    public void clear(){
        storage.clear();
    }

    @Override
    public String toString() {
        return storage.toString();
    }
}
