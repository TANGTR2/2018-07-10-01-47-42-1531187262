package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {}

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int number) {
        List<Integer> result = new ArrayList<>();
        int randomNumber = random.nextInt(3);

        IntStream.rangeClosed(1, number / randomNumber )
                .reduce(number, (reducedNum, index) -> {
                    int readucedValue = reducedNum - randomNumber;
                    result.add(readucedValue);
                    return readucedValue;
                });
        return result;
    }
}
