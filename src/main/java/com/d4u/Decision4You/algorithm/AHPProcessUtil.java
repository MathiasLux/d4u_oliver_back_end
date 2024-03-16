package com.d4u.Decision4You.algorithm;

/**
 * The Analytic Hierarchy Process (AHP) algorithm is a multi-user, multi-criteria decision-making method that uses
 * pairwise comparisons to determine the relative importance of criteria and alternatives.
 *
 * <p>This class provides utility methods to perform the AHP process, including aggregating pairwise comparisons,
 * normalizing the consensus matrix, calculating criteria weights, and scoring alternatives.</p>
 */

public abstract class AHPProcessUtil {

    /**
     * Step 1: Aggregates individual pairwise comparison matrices from all users to create a consensus matrix.
     *
     * @param criteriaComparison A 3D array containing the pairwise comparisons for criteria from multiple users.
     * @return A 2D array representing the aggregated matrix for criteria.
     */
    public static double[][] aggregateCriteria(double[][][] criteriaComparison) {

        // The number of users is the length of the first dimension of the 3D array.
        int numOfUsers = criteriaComparison.length;

        // The number of criteria is the length of the second dimension of the 3D array.
        int numOfCriteria = criteriaComparison[0].length;

        // The consensus matrix is a 2D array with the same number of criteria as the input.
        double[][] consensusMatrix = new double[numOfCriteria][numOfCriteria];

        // Average the pairwise comparisons for each criterion across all users.
        for (int i = 0; i < numOfCriteria; i++) {
            for (int j = 0; j < numOfCriteria; j++) {
                double sum = 0;
                for (double[][] doubles : criteriaComparison) {
                    sum += doubles[i][j];
                }
                consensusMatrix[i][j] = sum / numOfUsers;
            }
        }

        // Return the consensus matrix.
        return consensusMatrix;
    }


    /**
     * Step 2: Normalizes the consensus matrix to prepare for calculating criteria weights.
     *
     * @param consensusMatrix A 2D array representing the aggregated matrix for criteria.
     * @return A 2D array representing the normalized consensus matrix.
     */
    public static double[][] normalizeConsensusMatrix(double[][] consensusMatrix) {

        // The number of criteria is the length of the first dimension of the 2D array.
        int numOfCriteria = consensusMatrix.length;

        // The normalized matrix is a 2D array with the same number of criteria as the input.
        double[][] normalizedMatrix = new double[numOfCriteria][numOfCriteria];

        // An array to store the sum of each column in the consensus matrix.
        double[] columnSums = new double[numOfCriteria];

        // Calculate column sums
        for (int j = 0; j < numOfCriteria; j++) {
            for (double[] matrix : consensusMatrix) {
                columnSums[j] += matrix[j];
            }
        }

        // Normalize the matrix by dividing each element by the sum of its column.
        for (int i = 0; i < numOfCriteria; i++) {
            for (int j = 0; j < numOfCriteria; j++) {
                normalizedMatrix[i][j] = consensusMatrix[i][j] / columnSums[j];
            }
        }

        // Return the normalized matrix.
        return normalizedMatrix;
    }


    /**
     * Step 3: Calculates weights for each criterion based on the normalized consensus matrix.
     *
     * @param normalizedMatrix A 2D array representing the normalized consensus matrix.
     * @return An array of weights for each criterion.
     */
    public static double[] calculateCriteriaWeights(double[][] normalizedMatrix) {
        // The number of criteria is the length of the first dimension of the 2D array.
        int numOfCriteria = normalizedMatrix.length;

        // An array to store the weights for each criterion.
        double[] criteriaWeights = new double[numOfCriteria];

        // A variable to store the total sum of the weights.
        double totalSum = 0;

        // Sum each row to get initial weights
        for (int i = 0; i < numOfCriteria; i++) {
            for (int j = 0; j < numOfCriteria; j++) {
                criteriaWeights[i] += normalizedMatrix[i][j];
            }
            totalSum += criteriaWeights[i];
        }

        // Normalize the weights
        for (int i = 0; i < numOfCriteria; i++) {
            criteriaWeights[i] = criteriaWeights[i] / totalSum;
        }

        // Return the criteria weights.
        return criteriaWeights;
    }


    /**
     * Step 4: Calculates the final scores for each alternative based on the criteria weights and the creator's assessments.
     *
     * @param criteriaWeights An array of weights for each criterion.
     * @param creatorAssessment A 2D array where each row represents an alternative and columns represent the creator's assessments.
     * @return An array of final scores for each alternative.
     */
    public static double[] scoreAlternatives(double[] criteriaWeights, double[][] creatorAssessment) {

        // An array to store the final scores for each alternative.
        double[] finalScores = new double[creatorAssessment.length];

        // Calculate the final score for each alternative based on the criteria weights and creator's assessments.
        for (int alt = 0; alt < creatorAssessment.length; alt++) {
            double score = 0;
            // Multiply each criterion weight by the creator's assessment for the alternative.
            for (int crit = 0; crit < criteriaWeights.length; crit++) {
                score += criteriaWeights[crit] * creatorAssessment[alt][crit];
            }
            finalScores[alt] = score;
        }

        // Return the final scores.
        return finalScores;
    }
}
