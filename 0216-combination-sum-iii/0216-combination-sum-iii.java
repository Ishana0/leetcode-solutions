class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> answer = new ArrayList<>();

        backtrack(1, k, n, new ArrayList<>(), answer);

        return answer;
    }

    public void backtrack(int start, int k, int target, List<Integer> path, List<List<Integer>> answer) {
        if(path.size() == k) {
            if(target == 0) {
                answer.add(new ArrayList<>(path));
            }

            return;
        }

        for(int i = start; i <= 9; i++) {
            if(i > target) {
                break;
            }

            path.add(i);

            backtrack(i + 1, k, target - i, path, answer);

            path.remove(path.size() - 1);
        }
    }
}