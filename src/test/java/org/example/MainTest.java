package org.example;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MainTest {

    public final static double EPS = 1e-3;
    double start = 0.8;
    double end = 2;
    double step = 0.005;
    Main main;

    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @ParameterizedTest
    @MethodSource({
            "org.example.TestDataProvider#testFirstBoundData",
            "org.example.TestDataProvider#testSecondBoundData",
            "org.example.TestDataProvider#testThirdBoundData"
    })
    @DisplayName("Test mathematical function result")
    void testFunctionResult(double x, double expected) {
        double actual = main.secondFunction(x);

        assertThat(actual).isEqualTo(expected, Offset.offset(EPS));
    }

    @Test
    @DisplayName("count steps in range [`start`, `end`] with the step value `step`.")
    void testSteps() {
        int expected = 240;
        int actual = main.countSteps(start, end, step);

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("org.example.TestDataProvider#testXData")
    @DisplayName("test x value under the element number of the array in the given range, with the given step")
    void testX(int elementNum, double expectedX) {
        double actualX = main.getArrayOfXinRange(start, end, step)[elementNum];

        assertThat(actualX).isEqualTo(expectedX, Offset.offset(EPS));
    }

    @ParameterizedTest
    @MethodSource("org.example.TestDataProvider#testYData")
    @DisplayName("test y value under the element number of the array in the given range, with the given step")
    void testY(int elementNum, double expectedY) {
        double actualY = main.getArrayOfYinRange(start, end, step)[elementNum];
        assertThat(actualY).isEqualTo(expectedY, Offset.offset(EPS));
    }

    @Test
    @DisplayName("find max value of the array in the given range, with the given step")
    void findMax() {
        double actualMaxValue = main.findMaxValueInRange(start, end, step);
        double expectedMaxValue = 16.49638;

        assertThat(actualMaxValue).isEqualTo(expectedMaxValue, Offset.offset(EPS));
    }

    @Test
    @DisplayName("find min value of the array in the given range, with the given step")
    void findMin() {
        double actualMinValue = main.findMinValueInRange(start, end, step);
        double expectedMinValue = -8.92688;

        assertThat(actualMinValue).isEqualTo(expectedMinValue, Offset.offset(EPS));
    }

    @Test
    @DisplayName("find average value of the array in the given range, with the given step")
    void findAverage() {
        double actualAverageValue = main.findAverageValueInRange(start, end, step);
        double expectedAverageValue = 0.27934;

        assertThat(actualAverageValue).isEqualTo(expectedAverageValue, Offset.offset(EPS));
    }

    @Test
    @DisplayName("find sum of the array in the given range, with the given step")
    void findSum() {
        double actualSum = main.findSumInRange(start, end, step);
        double expectedSum = 67.32209;

        assertThat(actualSum).isEqualTo(expectedSum, Offset.offset(EPS));
    }
}
