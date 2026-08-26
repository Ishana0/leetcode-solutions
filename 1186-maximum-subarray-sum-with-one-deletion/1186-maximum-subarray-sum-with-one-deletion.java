class Solution {
    public int maximumSum(int[] arr) {
        int noDelete = arr[0];
        int oneDelete = arr[0];

        int answer = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int oldNoDelete = noDelete;
            int oldOneDelete = oneDelete;

            noDelete = Math.max(
                arr[i],
                oldNoDelete + arr[i]
            );

            oneDelete = Math.max(
                oldNoDelete,
                oldOneDelete + arr[i]
            );

            answer = Math.max(
                answer,
                Math.max(noDelete, oneDelete)
            );
        }

        return answer;
    }
}