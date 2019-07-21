// Dynamic Programming

public List<String> wordBreak(String s, List<String> wordDict) {
    HashMap<String, List<String>> hm = new HashMap<>();
    return dp(s, wordDict, hm);
}

public List<String> dp(String s, List<String> wordDict, HashMap<String, List<String>> hm){
    if (hm.containsKey(s)){
        return hm.get(s);
    }

    List<String> resSens = new ArrayList<>();
    if (s.length() == 0){
        resSens.add("");
        return resSens;
    }

    for (String word: wordDict){
        if (s.startsWith(word)){
            List<String> subString = dp(s.substring(word.length()), wordDict, hm);
            for (String sub: subString){
                resSens.add(word + (sub.isEmpty() ? "" : " " + sub));
            }
        }
    }

    hm.put(s, resSens);

    return resSens;
}
