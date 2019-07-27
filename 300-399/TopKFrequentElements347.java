public List<Integer> topKFrequent(int[] nums, int k) {
    int len = nums.length;
    // fre is used to store the frequency of every ele
    HashMap<Integer, Integer> fre = new HashMap<>();

    // get the frequency of every element
    for (int  n : nums){
        fre.put(n, fre.getOrDefault(n, 0) + 1);
    }

    List<Integer>[] posFre = new List[len + 1];
    /* Be careful about the lenth of posFre. Note that the frequency is going to start at 1 while the
    starting index of an array is 0. So we need to set the length of posFre to len + 1 instead of len.
    */

    for (int key : fre.keySet()){
        int frequency = fre.get(key);
        if (posFre[frequency] == null){
            posFre[frequency] = new ArrayList<Integer>();
        }
        posFre[frequency].add(key);
    }

    List<Integer> res = new ArrayList<>();

    for (int frePos = len; res.size() < k && frePos >= 0; frePos--){
        if (posFre[frePos] != null)
            res.addAll(posFre[frePos]);
    }

    return res;
}
