package tasks;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
import static tasks.Task1.solution;

class FirstTaskTest {

    @Test
    void testAgainstGivenCase() {
        final var helloWold = "Hello World!";
        final var length = solution(helloWold);

        assertEquals(6, length);
    }

}