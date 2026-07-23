class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int maxArea = 0;

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            int[] heights = matrix[i].clone();

            Arrays.sort(heights);

            for (int j = 0; j < cols; j++) {
                int height = heights[j];
                int width = cols - j;

                int area = height * width;

                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
}