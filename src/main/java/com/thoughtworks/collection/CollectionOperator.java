package com.thoughtworks.collection;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;


public class CollectionOperator {
    private List<Integer> getListOfReducedOfTwoNums(int leftBorder, int rightBorder, Function<Integer, Boolean> isContinue) {
        return leftBorder < rightBorder
                ? getListOfReducedBetweenBigAndsmallNum(leftBorder, rightBorder, isContinue)
                : getListOfReducedBetweenBigAndsmallNum(rightBorder, leftBorder, isContinue);
    }

    private List<Integer> getListOfReducedBetweenBigAndsmallNum(int smallNum, int bigNum, Function<Integer, Boolean> isContinue) {
        return IntStream.rangeClosed(smallNum, bigNum)
                .filter(isContinue::apply)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Integer> getListByInterval(int left, int right) {
        List<Integer> reducedOfTwoNumsList = this.getListOfReducedOfTwoNums(left, right, num -> true);
        return left < right ? reducedOfTwoNumsList : reducedOfTwoNumsList.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        List<Integer> reducedOfTwoNumsList = this.getListOfReducedOfTwoNums(left, right, num -> num % 2 == 0);
        return left < right ? reducedOfTwoNumsList : reducedOfTwoNumsList.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
    }

    public List<Integer> popEvenElments(int[] array) {
        return Arrays.stream(array).boxed()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());
    }


    public int popLastElment(int[] array) {
        return array[array.length - 1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        return Arrays.stream(firstArray).boxed()
                .filter(numInFirst ->
                        Arrays.stream(secondArray).boxed()
                                .anyMatch(numInSecond -> numInSecond.equals(numInFirst)))
                .collect(Collectors.toList());
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> unCommonList = Arrays.stream(secondArray)
                .filter(num -> !Arrays.stream(firstArray)
                        .anyMatch(numInFirst -> numInFirst.equals(num)))
                .collect(Collectors.toList());
        List<Integer> results = Arrays.stream(firstArray).collect(Collectors.toList());
        results.addAll(unCommonList);
        return results;
    }
}
