class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        // sort the candidates array first so in the process of dfs, we can stop the wrongly guessed route at once
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        dfs(candidates, 0, target, path, res);
        return res;
    }
    
    private void dfs(int[] cand, int start, int target, List<Integer> path, List<List<Integer>> res){
        if (target == 0){
            res.add(new ArrayList(path));
        }
        if (target < 0) return;
        for (int i = start; i < cand.length; i++){
            if (i > start && cand[i] == cand[i - 1]) continue;
            /*
            Pay attention to 'i > start' here cuz it's not just here to solve an ArrayIndexOutOfBoundsException.
            In the Note given by the problem, we know that the solution set must not contain duplicate combinations,
            meaning we should have path [1, 1, 6] contained,
            but there should not be two [1, 2, 5]s in the result at the same time.
            If two cands are in the same depth layer of dfs, the start number remains the same.
            When dfs getting deeper, the start number changes when dfs dive in, 
            and the num that is same as the num before will always be in the new start position.
            This means number b that is same as number a can be the part of continuing path of number a, 
            but number b will be passed if it serves as the part in the same level of a.
            */
            path.add(cand[i]);
            dfs(cand, i + 1, target - cand[i], path, res);
            path.remove(path.size() - 1);
        }
    }
}
