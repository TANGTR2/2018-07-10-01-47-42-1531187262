package com.thoughtworks.collection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Flaten {

    Integer[][] array;
    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
        List<Integer> resultList = Arrays.stream(array)
                .flatMap(x -> Arrays.stream(x))
                .collect(Collectors.toList());
        return resultList;
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        List<Integer> resultList = Arrays.stream(array)
                .flatMap(x -> Arrays.stream(x))
                .distinct()
                .collect(Collectors.toList());
        return resultList;
    }
}
