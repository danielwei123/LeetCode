// 39. Combination Sum

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // DFS
        // each layer i represent how many candidates[i] will be used
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        DFS(candidates, target, 0, tmp, res);
        return res;
    }
    
    private void DFS(int[] candidates, int target, int index, List<Integer> tmp, List<List<Integer>>res) {
        if (target == 0) {
            List<Integer> newTmp = new ArrayList<>();
            for (int i = 0; i < tmp.size(); i++) {
                newTmp.add(tmp.get(i));
            }
            res.add(newTmp);
            return;
        } else if (target < 0 || index >= candidates.length) {
            return;
        } else {
            for (int i = 1; i <= target / candidates[index]; i++) {
                // Add i copies of candidates[i]
                for (int j = 0; j < i; j++) {
                    tmp.add(candidates[index]);
                }
                DFS(candidates, target - candidates[index] * i, index + 1, tmp, res);
                // Remove i copies of candidates[i]
                for (int j = 0; j < i; j++) {
                    tmp.remove(tmp.size() - 1);
                }
            }
            DFS(candidates, target, index + 1, tmp, res);
        }
    }
}