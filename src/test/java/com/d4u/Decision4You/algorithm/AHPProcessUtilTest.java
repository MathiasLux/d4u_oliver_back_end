package com.d4u.Decision4You.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AHPProcessUtilTest {

    @Test
    public void testAggregateCriteria() {
        double[][][] input = {{{1, 2}, {0.5, 1}}, {{1, 1}, {1, 1}}};
        double[][] expected = {{1, 1.5}, {0.75, 1}};
        double[][] result = AHPProcessUtil.aggregateCriteria(input);
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], result[i], 0.01);
        }
    }

    @Test
    public void testNormalizeConsensusMatrix() {
        double[][] input = {{1, 1.5}, {0.75, 1}};
        double[][] expected = {{0.57, 0.6}, {0.43, 0.4}};
        double[][] result = AHPProcessUtil.normalizeConsensusMatrix(input);
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], result[i], 0.01);
        }
    }

    @Test
    public void testCalculateCriteriaWeights() {
        double[][] input = {{0.57, 0.6}, {0.43, 0.4}};
        double[] expected = {0.585, 0.415};
        double[] result = AHPProcessUtil.calculateCriteriaWeights(input);
        assertArrayEquals(expected, result, 0.01);
    }

    @Test
    public void testScoreAlternatives() {
        double[] weights = {0.585, 0.415};
        double[][] assessments = {{9, 8}, {7, 9}};
        double[] expected = {8.585, 7.83};
        double[] result = AHPProcessUtil.scoreAlternatives(weights, assessments);
        assertArrayEquals(expected, result, 0.01);
    }
}
