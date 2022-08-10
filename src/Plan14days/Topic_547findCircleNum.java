package Plan14days;

public class Topic_547findCircleNum {
    public int findCircleNum(int[][] isConnected) {
        int provinces  = isConnected.length;
        boolean[] visited = new boolean[provinces];
        int ans = 0;
        for(int i = 0; i < provinces; i++){
            if (!visited[i]){
                DFS(isConnected, visited, provinces, i);
                ans++;
            }
        }
        return ans;
    }

    private void DFS(int[][] isConnected, boolean[] visited, int provinces, int i) {
        for (int j = 0; j < provinces; j++){
            if (isConnected[i][j] == 1 && !visited[j]){
                visited[j] = true;
                DFS(isConnected, visited, provinces, j);
            }
        }
    }

    public static void main(String[] args) {
        Topic_547findCircleNum solution = new Topic_547findCircleNum();
        int[][] isConnected = {{1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}};
        System.out.println(solution.findCircleNum(isConnected));
    }
}
