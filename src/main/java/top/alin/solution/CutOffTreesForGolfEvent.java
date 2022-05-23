package top.alin.solution;

import java.util.*;

public class CutOffTreesForGolfEvent {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int cutOffTree(List<List<Integer>> forest) {
        List<int[]> treeList = new ArrayList<>();
        for(int i = 0; i < forest.size(); i++) {
            for(int j = 0; j < forest.get(i).size(); j++) {
                if (forest.get(i).get(j) > 1) {
                    treeList.add(new int[]{i , j});
                }
            }
        }
        Collections.sort(treeList, (a, b) -> forest.get(a[0]).get(a[1]) - forest.get(b[0]).get(b[1]));
        int ans = 0;
        int sx = 0;
        int sy = 0;
        for (int[] tree : treeList) {
            int tx = tree[0];
            int ty = tree[1];
            int distance = bfs(forest, sx, sy, tx, ty);
            if (distance == -1) {
                return -1;
            }
            ans += distance;
            sx = tx;
            sy = ty;
        }
        return ans;
    }

    int bfs(List<List<Integer>> forest, int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty) {
            return 0;
        }
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy});
        int distance = 0;
        int row = forest.size();
        int col = forest.get(0).size();
        boolean[][] visited = new boolean[row][col];
        while(!q.isEmpty()) {
            distance++;
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for(int[] direction : directions) {
                    int nx = curr[0] + direction[0];
                    int ny = curr[1] + direction[1];
                    if (nx < 0 || nx >= row || ny < 0 || ny >= col || forest.get(nx).get(ny) == 0 ||visited[nx][ny]) {
                        continue;
                    }
                    if (nx == tx && ny == ty) {
                        return distance;
                    }
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return -1;
    }
}
