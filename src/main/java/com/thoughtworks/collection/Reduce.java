package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        int index = arrayList.size() / 2;
        if (index % 2 == 0) {
            return arrayList.stream().skip(index - 1).limit(2).mapToInt(num -> num)
                    .average().getAsDouble();
        } else {
            return arrayList.stream().skip(index).findFirst().get();
        }
    }

    public int getFirstEven() {
        List<Integer> resultList = arrayList.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());
        Optional<Integer> firstEven = resultList.stream().findFirst();
        return firstEven.get();
    }

    public int getIndexOfFirstEven() {
        int firstEvent = arrayList.stream().filter(num -> num % 2 == 0).findFirst().get();
        return arrayList.indexOf(firstEvent);
    }

    public boolean isEqual(List<Integer> comarrayList) {
        Boolean isEqual = false;
        if (comarrayList.size() == arrayList.size()) {
            isEqual = IntStream.range(0, arrayList.size())
                    .allMatch(index -> comarrayList.get(index) == arrayList.get(index));
        }
        return isEqual;
    }

    //实现接口SingleLink
    public double getMedianInLinkList(SingleLink<Integer> singleLink) {

        int index = arrayList.size() / 2;

        if (arrayList.size() % 2 == 0) {
            return (singleLink.getNode(index) + singleLink.getNode(index + 1)) / 2.0;
        } else {
            return singleLink.getNode(index + 1);
        }
    }

    public int getLastOdd() {
        return arrayList.stream()
                .filter(num -> num % 2 != 0)
                .reduce((first, second) -> second).get();
    }

    public int getIndexOfLastOdd() {
        return arrayList.lastIndexOf(getLastOdd());
    }
}
