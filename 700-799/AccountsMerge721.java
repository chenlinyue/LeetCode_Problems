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


class DFSSolution {
    // this is the DFS solution
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // a graph is created to represent emails, emails are nodes and ther are connected if they show up in the same account
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, String> owner = new HashMap<>();
        // first, create the graph and connect owner and email
        for (List<String> acc : accounts){
            for (int i = 1; i < acc.size(); i++){
                owner.put(acc.get(i), acc.get(0));
                // graph is being created
                if (!graph.containsKey(acc.get(i))) graph.put(acc.get(i), new HashSet<String>());
                if (i == 1) continue;
                graph.get(acc.get(i)).add(acc.get(i - 1));
                graph.get(acc.get(i - 1)).add(acc.get(i));
            }
        }
        
        Set<String> visited = new HashSet<>();
        List<List<String>> res = new ArrayList<>();
        
        for (String email : owner.keySet()){
            if (!visited.contains(email)){
                List<String> line = new ArrayList<>();
                dfs(email, graph, visited, line);
                Collections.sort(line);
                line.add(0, owner.get(email));
                res.add(line);
            }
        }
        return res;
    }
     
    // function dfs get the all emails that belongs to the same owner together in the list
    public void dfs(String email, Map<String, Set<String>> graph, Set<String> visited, List<String> list){
        list.add(email);
        visited.add(email);
        for (String neighbour : graph.get(email)){
            if (!visited.contains(neighbour)){
                dfs(neighbour, graph, visited, list);
            }
        }
    }
}
