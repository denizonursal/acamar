package tasks;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
import static tasks.Task2.solution;

class SecondTaskTest {

    @Test
    void testAgainstGivenCase() {
        final var solution = solution(new int[]{-4, -1, 0, 3, 10});
        assertArrayEquals(new int[]{0,1,9,16,100}, solution);
    }

    @Test
    void testAgainstEqualNumberOfPositiveAndNegative() {
        Random generator = new Random();
        final var ints = IntStream.generate(() -> generator.nextInt(100) - 50)
                .limit(20)
                .toArray();

        Arrays.sort(ints);

        final var solution = solution(ints);

        final var squares = Arrays.stream(ints)
                .map(i -> i * i)
                .toArray();

        Arrays.sort(squares);

        assertArrayEquals(squares, solution);
    }

    @Test
    void testAgainstAllPositive() {
        Random generator = new Random();
        final var ints = IntStream.generate(() -> generator.nextInt(100))
                .limit(20)
                .toArray();

        Arrays.sort(ints);

        final var solution = solution(ints);

        final var squares = Arrays.stream(ints)
                .map(i -> i * i)
                .toArray();

        Arrays.sort(squares);

        assertArrayEquals(squares, solution);
    }

    @Test
    void testAgainstAllNegative() {
        Random generator = new Random();
        final var ints = IntStream.generate(() -> generator.nextInt(100) - 100)
                .limit(20)
                .toArray();

        Arrays.sort(ints);

        final var solution = solution(ints);

        final var squares = Arrays.stream(ints)
                .map(i -> i * i)
                .toArray();

        Arrays.sort(squares);

        assertArrayEquals(squares, solution);
    }
}