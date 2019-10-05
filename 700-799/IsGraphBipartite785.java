/* 
The DFS of solving the problem:
Color the adjacent nodes with color black and white to see whether it works.
*/

public boolean isBipartite(int[][] graph) {
    int n = graph.length;
    int[] colors = new int[n];
    // 0 denotes not visited, 1 denotes black and -1 denotes white

    for (int i = 0; i < n - 1; i++){
        if (colors[i] == 0 && !isValid(graph, colors, 1, i))
            return false;
    }
    return true;
}

public boolean isValid(int[][] graph, int[] colors, int color, int node){
    if (colors[node] != 0){
        return colors[node] == color;
    }
    colors[node] = color;
    for (int adj : graph[node]){
        if (!isValid(graph, colors, -color, adj))
            return false;
    }
    return true;
}
