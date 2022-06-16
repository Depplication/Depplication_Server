package com.project.Dion.global.utils;

public class UpdateUtil<T> {
    public T getUpdated(T origin, T newValue) {
        return (newValue != null) ? newValue : origin;
    }
}
