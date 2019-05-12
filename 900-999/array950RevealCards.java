class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int l = deck.length;
        int[] result = new int[l];
        Arrays.sort(deck);
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < l; i++){
            if (i != 0){
                q.add(q.poll());
                q.add(deck[l - 1 - i]);
            }else{
                q.add(deck[l - 1 - i]);
            }
        }
        for (int j = 0; j < l; j++){
            result[l - 1 - j] = q.poll();
        }
        return result;
    }
}
