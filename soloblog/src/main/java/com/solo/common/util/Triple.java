package com.solo.common.util;

import java.io.Serializable;

/**
 * Triple impl, use for pass three object.
 *
 * @author yaowu.zhang
 */
public class Triple<K, V, T> implements Serializable {

    private static final long serialVersionUID = 3772796817404378598L;

    private K firstValue;

    private V secondValue;

    private T thirdValue;

    public Triple() {
    }

    public Triple(K firstValue, V secondValue, T thirdValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        this.thirdValue = thirdValue;
    }

    @Override
    public String toString() {
        return "Triple{" + "firstValue=" + firstValue + ", secondValue=" + secondValue + ", thirdValue="
                + thirdValue + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Triple<?, ?, ?> triple = (Triple<?, ?, ?>) o;

        if (firstValue != null ? !firstValue.equals(triple.firstValue) : triple.firstValue != null)
            return false;
        if (secondValue != null ? !secondValue.equals(triple.secondValue) : triple.secondValue != null)
            return false;
        return thirdValue != null ? thirdValue.equals(triple.thirdValue) : triple.thirdValue == null;

    }

    @Override
    public int hashCode() {
        int result = firstValue != null ? firstValue.hashCode() : 0;
        result = 31 * result + (secondValue != null ? secondValue.hashCode() : 0);
        result = 31 * result + (thirdValue != null ? thirdValue.hashCode() : 0);
        return result;
    }

    public K getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(K firstValue) {
        this.firstValue = firstValue;
    }

    public V getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(V secondValue) {
        this.secondValue = secondValue;
    }

    public T getThirdValue() {
        return thirdValue;
    }

    public void setThirdValue(T thirdValue) {
        this.thirdValue = thirdValue;
    }

}
