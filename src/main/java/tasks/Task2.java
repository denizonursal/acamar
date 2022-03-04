package tasks;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * Given an integer array sorted in non-decreasing order,
 * return an array of the squares of each number sorted in non-decreasing order.
 *
 * Example input: [-4,-1,0,3,10]
 *
 * Expected output: [0,1,9,16,100]
 *
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 *
 * After sorting, it becomes [0,1,9,16,100].
 */
public class Task2 {

    private Task2() {}

    /**
     *
     * @param integerArray - input array.
     * @return - Square array sorted with natural order.
     */
    public static int[] solution(int[] integerArray) {

        final var squaredArray = Arrays.stream(integerArray)
                .map(i -> i * i)
                .toArray();

        final var indexOfFirstPositive = IntStream.range(0, integerArray.length)
                .filter(i -> Math.signum(integerArray[i]) == 1.0f || Math.signum(integerArray[i]) == 0f)
                .findFirst();

        return reorderArray(squaredArray, indexOfFirstPositive.orElse(integerArray.length));
    }

    private static int[] reorderArray(int[] partiallyOrderedArray, int indexOfFirstPositive) {

        var totalLength = partiallyOrderedArray.length;
        var orderedArray = new int[totalLength];

        var counter = 0;
        var forwardIndex = 0;
        var backwardIndex = 1;
        while (counter < totalLength && !(indexOfFirstPositive + forwardIndex == totalLength || indexOfFirstPositive - backwardIndex == -1)) {
            orderedArray[counter++] =
                    partiallyOrderedArray[indexOfFirstPositive + forwardIndex] < partiallyOrderedArray[indexOfFirstPositive - backwardIndex]
                            ? partiallyOrderedArray[indexOfFirstPositive + forwardIndex++]
                            : partiallyOrderedArray[indexOfFirstPositive - backwardIndex++];
        }

        final var untilEnd = indexOfFirstPositive - backwardIndex;
        Optional.of(indexOfFirstPositive + forwardIndex)
                .filter(i -> i == totalLength)
                .ifPresent(j ->
                    IntStream.iterate(untilEnd, i -> i > -1, i -> --i)
                            .forEach(i -> orderedArray[totalLength - 1 - i] = partiallyOrderedArray[i])
                );

        final var untilStart = indexOfFirstPositive + forwardIndex;
        Optional.of(indexOfFirstPositive - backwardIndex)
                .filter(i -> i == -1)
                .ifPresent(j ->
                        IntStream.iterate(untilStart, i -> i < totalLength, i -> ++i)
                                .forEach(i -> orderedArray[i] = partiallyOrderedArray[i])
                );

        return orderedArray;

    }
}
