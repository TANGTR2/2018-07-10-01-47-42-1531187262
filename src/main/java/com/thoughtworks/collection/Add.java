package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        if (leftBorder < rightBorder) {
            List<Integer> list = IntStream.range(leftBorder, rightBorder).boxed().collect(toList());
            list.add(rightBorder);
            int sum = list.stream()
                    .filter(x -> x % 2 == 0)
                    .reduce(0, (x, y) -> x + y);
            return sum;
        } else {
            List<Integer> list = IntStream.range(rightBorder, leftBorder).boxed().collect(toList());
            list.add(leftBorder);
            int sum = list.stream()
                    .filter(x -> x % 2 == 0)
                    .reduce(0, (x, y) -> x + y);
            return sum;
        }
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        if (leftBorder < rightBorder) {
            List<Integer> list = IntStream.range(leftBorder, rightBorder).boxed().collect(toList());
            list.add(rightBorder);
            int sum = list.stream()
                    .filter(x -> x % 2 == 1)
                    .reduce(0, (x, y) -> x + y);
            return sum;
        } else {
            List<Integer> list = IntStream.range(rightBorder, leftBorder).boxed().collect(toList());
            list.add(leftBorder);
            int sum = list.stream()
                    .filter(x -> x % 2 == 1)
                    .reduce(0, (x, y) -> x + y);
            return sum;
        }
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        List<Integer> tripleAndAddTwoList = arrayList.stream()
                .map(x -> 3*x + 2).collect(toList());
        int sum = tripleAndAddTwoList.stream()
                .reduce(0, (x, y) -> x + y);
        return sum;
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        List result = arrayList;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 2 != 0) {
                result.set(i, arrayList.get(i) * 3 + 2);
            }
        }
        return result;
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        List<Integer> processedOddsList = arrayList.stream()
                .filter(x -> x % 2 == 1)
                .map(x -> 3*x + 5).collect(toList());
        int sum = processedOddsList.stream()
                .reduce(0, (x, y) -> x + y);
        return sum;
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        List<Integer> resultList =  arrayList.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x).collect(toList());
        int median;
        int size = resultList.size();
        if (size % 2 == 0) {
            median = (resultList.get(size / 2) + resultList.get(size / 2 - 1)) / 2;
        } else {
            median = resultList.get(size / 2);
        }

        return median;

    }

    public double getAverageOfEven(List<Integer> arrayList) {
        List<Integer> result = arrayList.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x).collect(toList());
        double sum = 0;
        for (Integer aResult : result) {
            sum += aResult;
        }
        return sum / result.size();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        List<Integer> result = arrayList.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x).collect(toList());
        for (Integer aResult : result) {
            if (aResult.equals(specialElment)) {
                return true;
            }
        }
        return false;
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        List evenList = arrayList.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x).collect(toList());
        List result = new ArrayList<>();
        result.add(evenList.get(0));
        for (Object anEvenList : evenList) {
            if (!result.contains(anEvenList)) {
                result.add(anEvenList);
            }
        }
        return result;
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> evensList = arrayList.stream()
                .filter(x -> x % 2 == 0)
                .sorted()
                .map(x -> x).collect(toList());
        List<Integer> oddsList = arrayList.stream()
                .filter(x -> x % 2 == 1)
                .sorted(Comparator.reverseOrder())
                .map(x -> x).collect(toList());
        List<Integer> result = evensList;
        for (Object anoddList : oddsList)
            result.add(anoddList.hashCode());
        return result;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arrayList.size() - 1; i++) {
            Integer resultElement = (arrayList.get(i) + arrayList.get(i + 1)) * 3;
            result.add(resultElement);
        }
        return result;
    }
}
