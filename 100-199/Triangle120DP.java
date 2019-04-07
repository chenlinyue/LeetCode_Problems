class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] minpath = new int[n];
        for (int k = 0; k < triangle.get(n - 1).size(); k++){
            minpath[k] = triangle.get(n - 1).get(k);
        }
        
        for (int i = n - 2; i >= 0; i--){
            for (int j = 0; j < triangle.get(i).size(); j++){
                minpath[j] = (minpath[j] > minpath[j + 1] ? minpath[j + 1] : minpath[j]) + triangle.get(i).get(j);
            }
        }
        return minpath[0];       
    }
}

// Takes the bottom-up solution to save more space.
