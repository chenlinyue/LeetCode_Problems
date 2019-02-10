class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseCode = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> count = new HashSet<String>();
        for (int j = 0; j < words.length; j++){
            String result = "";
            for (char c: words[j].toCharArray()){
                result += morseCode[c - 'a'];
            }
            count.add(result);
        }
        return count.size();
    }
}
