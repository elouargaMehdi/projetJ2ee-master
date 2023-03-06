package com.example.projetj2e.ws.converter;

import java.util.List;
import java.util.stream.Collectors;

public  abstract  class AbstractConverter<T, T1> {

    public abstract T1 toDto(T item);

    public abstract T toItem(T1 dto);

    public List<T> toItem(List<T1> list){
        List<T> result = null;
        if (list != null) {
            result = list.stream().map(e ->toItem(e)).collect(Collectors.toList());
        }
        return result;
    }
    public List<T1> toDto(List<T> list){
        List<T1> result = null;
        if (list != null) {
            result = list.stream().map(e ->toDto( e)).collect(Collectors.toList());
        }
        return result;
    }
}