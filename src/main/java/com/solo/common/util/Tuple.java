package com.solo.common.util;

import java.io.Serializable;

/**
 * tuple impl, use for pass two object.
 *
 * @author yaowu.zhang
 */
public class Tuple<K, V> implements Serializable {

    private static final long serialVersionUID = -5605226584503008964L;

    private K firstValue;

    private V secondValue;

    public Tuple() {
    }

    public Tuple(K firstValue, V secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    @Override
    public String toString() {
        return "Tuple{" + "firstValue=" + firstValue + ", secondValue=" + secondValue + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Tuple<?, ?> tuple = (Tuple<?, ?>) o;

        if (firstValue != null ? !firstValue.equals(tuple.firstValue) : tuple.firstValue != null)
            return false;
        return secondValue != null ? secondValue.equals(tuple.secondValue) : tuple.secondValue == null;

    }

    @Override
    public int hashCode() {
        int result = firstValue != null ? firstValue.hashCode() : 0;
        result = 31 * result + (secondValue != null ? secondValue.hashCode() : 0);
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

}
