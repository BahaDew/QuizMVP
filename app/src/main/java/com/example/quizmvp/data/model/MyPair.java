package com.example.quizmvp.data.model;

import androidx.annotation.NonNull;

import java.util.Objects;

public class MyPair<F, S, T> {
    public final F first;
    public final S second;
    public final T three;

    public MyPair(F first, S second, T three) {
        this.first = first;
        this.second = second;
        this.three = three;
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MyPair)) {
            return false;
        }
        MyPair<?, ?, ?> p = (MyPair<?, ?, ?>) o;
        return Objects.equals(p.first, first) && Objects.equals(p.second, second) && Objects.equals(p.three, three);
    }

    @Override
    public int hashCode() {
        return (first == null ? 0 : first.hashCode()) ^ (second == null ? 0 : second.hashCode()) ^ (three == null ? 0 : three.hashCode());
    }

    @NonNull
    @Override
    public String toString() {
        return first + ", " + second + ", " + three;
    }
}
