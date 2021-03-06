package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Filter {

    List<Integer>  array;

    public Filter(List<Integer> array) {
     this.array = array;
    }

    public List<Integer> filterEven() {
        List<Integer> resultList = array.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());
        return resultList;
    }

    public List<Integer> filterMultipleOfThree() {
        List<Integer> resultList = array.stream()
                .filter(x -> x % 3 == 0)
                .collect(Collectors.toList());
        return resultList;
    }

    public List<Integer> getCommonElements(List<Integer> firstList, List<Integer> secondList) {
        return firstList.stream()
                .filter(num -> secondList.stream()
                        .anyMatch(num::equals))
                .collect(Collectors.toList());
    }

    public List<Integer> getDifferentElements() {
        List<Integer> resultList = array.stream()
                .distinct()
                .collect(Collectors.toList());
        return resultList;
    }
}