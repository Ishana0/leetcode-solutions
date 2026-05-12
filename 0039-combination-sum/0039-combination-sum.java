class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       backtrack(candidates, target, 0, new ArrayList<>());

        return result;
    }

    public void backtrack(int[] candidates, int target, int index, List<Integer> current) {
        if(target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if(target < 0) {
            return;
        }

        for(int i = index; i < candidates.length;i++) {
            current.add(candidates[i]);

            backtrack(candidates, target - candidates[i], i, current);

            current.remove(current.size() - 1);
        }
    }
}