package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

public class Add {
    private int getEvenSumOfReducedOfTwoNums(int smallNum, int bigNum, Function<Integer, Boolean> isContinue) {
        return IntStream.rangeClosed(smallNum, bigNum)
                .filter(isContinue::apply)
                .reduce((num1, num2) -> num1 + num2)
                .getAsInt();
    }

    private int getSumOfReducedOfTwoNums(int leftBorder, int rightBorder, Function<Integer, Boolean> isContinue) {
        return leftBorder < rightBorder
                ? getEvenSumOfReducedOfTwoNums(leftBorder, rightBorder, isContinue)
                : getEvenSumOfReducedOfTwoNums(rightBorder, leftBorder, isContinue);
    }
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        Function<Integer, Boolean> isContinue = num -> num % 2 == 0;
        return getSumOfReducedOfTwoNums(leftBorder, rightBorder, isContinue);
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        Function<Integer, Boolean> isContinue = num -> num % 2 != 0;
        return getSumOfReducedOfTwoNums(leftBorder, rightBorder, isContinue);
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        List<Integer> tripleAndAddTwoList = arrayList.stream().map(x -> 3*x + 2).collect(toList());
        return tripleAndAddTwoList.stream().reduce(0, (x, y) -> x + y);
        // return arrayList.stream().mapToInt(num -> num * 3 + 2).sum();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream()
                .map(num -> num % 2 != 0 ? num * 3 + 2 : num)
                .collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        List<Integer> processedOddsList = arrayList.stream()
                .filter(x -> x % 2 == 1)
                .map(x -> 3*x + 5).collect(toList());
        return processedOddsList.stream().reduce(0, (x, y) -> x + y);
//      return arrayList.stream().filter(num -> num % 2 != 0).mapToInt(num -> num * 3 + 5).sum();
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        List<Integer> resultList =  arrayList.stream()
                .filter(x -> x % 2 == 0)
                .collect(toList());
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
        Double avarage = arrayList.stream()
                .filter(x -> x%2==0)
                .collect(Collectors.averagingInt(x -> x));
        return avarage;
    }

    private List<Integer> getEvenList(List<Integer> arrayList) {
        return arrayList.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
    }
    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        List<Integer> result = this.getEvenList(arrayList);
        return result.stream().anyMatch(num -> num.equals(specialElment));
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        List<Integer> result = new ArrayList<>();
        this.getEvenList(arrayList).forEach(num -> {
            if (arrayList.stream().filter(filterNum -> filterNum.equals(num)).count() == 1) {
                result.add(num);
            }
        });
        return result;
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> evensList = arrayList.stream()
                .filter(x -> x % 2 == 0)
                .sorted()
                .collect(toList());
        List<Integer> oddsList = arrayList.stream()
                .filter(x -> x % 2 == 1)
                .sorted(Comparator.reverseOrder())
                .collect(toList());
        evensList.addAll(oddsList);
        return evensList;

    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> result = new ArrayList<>();
        arrayList.stream().reduce((resultElement1, resultElement2) -> {
                    Integer resultElement = (resultElement1 + resultElement2) * 3;
                    result.add(resultElement);
                    return resultElement2;
                }
        );
        return result;
    }
}
