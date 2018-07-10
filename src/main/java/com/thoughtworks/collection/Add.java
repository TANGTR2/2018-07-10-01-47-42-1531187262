package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import java.util.stream.*;
import java.util.List;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        if (leftBorder < rightBorder) {
            List<Integer> list = IntStream.range(leftBorder, rightBorder).boxed().collect(Collectors.toList());
            list.add(rightBorder);
            int sum = list.stream()
                    .filter(x -> x % 2 == 0)
                    .reduce(0, (x, y) -> x + y);
            return sum;
        } else {
            List<Integer> list = IntStream.range(rightBorder, leftBorder).boxed().collect(Collectors.toList());
            list.add(leftBorder);
            int sum = list.stream()
                    .filter(x -> x % 2 == 0)
                    .reduce(0, (x, y) -> x + y);
            return sum;
        }
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        if (leftBorder < rightBorder) {
            List<Integer> list = IntStream.range(leftBorder, rightBorder).boxed().collect(Collectors.toList());
            list.add(rightBorder);
            int sum = list.stream()
                    .filter(x -> x % 2 == 1)
                    .reduce(0, (x, y) -> x + y);
            return sum;
        } else {
            List<Integer> list = IntStream.range(rightBorder, leftBorder).boxed().collect(Collectors.toList());
            list.add(leftBorder);
            int sum = list.stream()
                    .filter(x -> x % 2 == 1)
                    .reduce(0, (x, y) -> x + y);
            return sum;
        }
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        List<Integer> tripleAndAddTwoList = arrayList.stream()
                .map(x -> 3*x + 2).collect(Collectors.toList());
        int sum = tripleAndAddTwoList.stream()
                .reduce(0, (x, y) -> x + y);
        return sum;
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        throw new NotImplementedException();
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        throw new NotImplementedException();
    }
}
