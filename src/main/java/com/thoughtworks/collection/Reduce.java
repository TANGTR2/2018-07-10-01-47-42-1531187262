package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        int max = arrayList.stream()
                .max(Integer::compare).get();
        return max;
    }

    public double getMinimum() {
        int min = arrayList.stream()
                .min(Integer::compare).get();
        return min;
    }

    public double getAverage() {
        Double avarage = arrayList.stream()
                .collect(Collectors.averagingInt(x -> x));
        return avarage;
    }

    public double getOrderedMedian() {
        throw new NotImplementedException();
    }

    public int getFirstEven() {
        List<Integer> resultList = arrayList.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());
        Optional<Integer> firstEven = resultList.stream().findFirst();
        return firstEven.get();
    }

    public int getIndexOfFirstEven() {
        throw new NotImplementedException();
    }

    public boolean isEqual(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public Double getMedianInLinkList(SingleLink singleLink) {
        throw new NotImplementedException();
    }

    public int getLastOdd() {
        throw new NotImplementedException();
    }

    public int getIndexOfLastOdd() {
        throw new NotImplementedException();
    }
}
