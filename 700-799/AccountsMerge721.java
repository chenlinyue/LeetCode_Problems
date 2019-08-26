/*
There are several ways to solve this question. Such as union find and DFS.
*/

class UnionFindSolution {
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> owner = new HashMap<>();
        Map<String, String> parent = new HashMap<>();
        Map<String, TreeSet<String>> unions = new HashMap<>();
        
        for (List<String> acc : accounts){
            for (int i = 1; i < acc.size(); i++){
                owner.put(acc.get(i), acc.get(0));
                parent.put(acc.get(i), acc.get(i));
            }
        }
        
        for (List<String> acc : accounts){
            String p = find(acc.get(1), parent);
            for (int i = 1; i < acc.size(); i++){
                parent.put(find(acc.get(i), parent), p);
            }
        }
        
        for (List<String> acc : accounts){
            String p = find(acc.get(1), parent);
            if (!unions.containsKey(p))
                unions.put(p, new TreeSet<String>());
            for (int i = 1; i < acc.size(); i++){
                unions.get(p).add(acc.get(i));
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        for (String p : unions.keySet()){
            ArrayList<String> acc = new ArrayList<>(unions.get(p));
            acc.add(0, owner.get(p));
            res.add(acc);
        }
        
        return res;
        
    }
    
    // function find returns the ultimate parent (temporately) of an email
    public String find(String s, Map<String, String> par){
        return par.get(s) == s ? s : find(par.get(s), par);
    }
}
