class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int[] color = new int[n];

        Arrays.fill(color, -1);

        for(int i = 0; i < n; i++) {
            if(color[i] == -1) {
                if(!dfs(graph, color, i, 0)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int[][] graph, int[] color, int node, int currentColor) {
        color[node] = currentColor;

        for(int neighbor : graph[node]) {
            if(color[neighbor] == -1) {
                if(!dfs(graph, color, neighbor, 1 - currentColor)) {
                    return false;
                }
            } else if(color[neighbor] == currentColor) {

                return false;
            }
        }

        return true;
    }
}