package org.example;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class TestDataProvider {

    // x < 1.7
    public static Stream<Arguments> testFirstBoundData() {
        return Stream.of(
                Arguments.of(1.4, 2.58609),
                Arguments.of(1.5,  3.95747),
                Arguments.of(1.6, 5.3081),
                Arguments.of(1.69, 6.52181)
        );
    }

    // x == 1.7
    public static Stream<Arguments> testSecondBoundData() {
        return Stream.of(
                Arguments.of(1.7, 16.49638)
        );
    }

    // x > 1.7
    public static Stream<Arguments> testThirdBoundData() {
        return Stream.of(
                Arguments.of(1.71, 1.03598),
                Arguments.of(1.8, 1.04889),
                Arguments.of(1.9, 1.06254),
                Arguments.of(2, 1.07553)
        );
    }

    public static Stream<Arguments> testXData() {
        return Stream.of(
                Arguments.of(0, 0.8),
                Arguments.of(180, 1.7),
                Arguments.of(240, 2)
        );
    }

    public static Stream<Arguments> testYData() {
        return Stream.of(
                Arguments.of(0, -8.92688),
                Arguments.of(180, 16.49638),
                Arguments.of(240, 1.07553)
        );
    }
}
