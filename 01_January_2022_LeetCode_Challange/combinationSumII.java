/*
 * #Problem 40    Combination Sum II
 */

 class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        Arrays.sort(candidates);
        helper(result, curr, 0, target, candidates);
        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> curr, int start, int target, int[] candidates) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(curr));
            return;
        }
        if (target < 0) {
            return;
        }

        int prev = -1;
        for (int i = start; i < candidates.length; i++) {
            if (prev != candidates[i]) { // each time start from different element
                curr.add(candidates[i]);
                helper(result, curr, i + 1, target - candidates[i], candidates); // and use next element only
                curr.remove(curr.size() - 1);
                prev = candidates[i];
            }
        }
    }
}
