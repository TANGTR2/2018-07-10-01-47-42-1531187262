package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Comparator;
import java.util.stream.*;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        if(left < right) {
            List<Integer> list = IntStream.rangeClosed(left, right).boxed().collect(toList());
            return list;
        }else {
            List<Integer> list = IntStream.rangeClosed(right, left).boxed()
                    .sorted(Comparator.reverseOrder())
                    .collect(toList());
            return list;
        }
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        throw new NotImplementedException();
    }

    public List<Integer> popEvenElments(int[] array) {
        throw new NotImplementedException();
    }

    public int popLastElment(int[] array) {
        throw new NotImplementedException();
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        throw new NotImplementedException();
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        throw new NotImplementedException();
    }
}
