package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        List<Integer> tripleList = array.stream()
                .map(x -> 3*x ).collect(toList());
        return tripleList;
    }

    public List<String> mapLetter() {
        throw new NotImplementedException();
    }

    public List<String> mapLetters() {
        throw new NotImplementedException();
    }

    public List<Integer> sortFromBig() {
        List<Integer> sortFromBigList = array.stream()
                .sorted(Comparator.reverseOrder())
                .map(x -> x).collect(toList());
        return sortFromBigList;
    }

    public List<Integer> sortFromSmall() {
        throw new NotImplementedException();
    }
}
