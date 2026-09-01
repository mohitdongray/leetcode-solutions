import java.util.*;

class Solution {
    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};

    class State {
        int r, c, energy, mask;
        State(int r, int c, int energy, int mask) {
            this.r = r;
            this.c = c;
            this.energy = energy;
            this.mask = mask;
        }
    }

    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        int maxEnergy = energy;

        int[][] litterBit = new int[m][n];
        for (int[] row : litterBit) Arrays.fill(row, -1);

        int litterCount = 0;
        int startR = -1, startC = -1;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                char cell = classroom[r].charAt(c);
                if (cell == 'S') {
                    startR = r;
                    startC = c;
                } else if (cell == 'L') {
                    litterBit[r][c] = litterCount;
                    litterCount++;
                }
            }
        }

        if (litterCount == 0) return 0;
        int allCollected = (1 << litterCount) - 1;

        Queue<State> queue = new ArrayDeque<>();
        boolean[][][][] visited = new boolean[m][n][1 << litterCount][maxEnergy + 1];

        queue.offer(new State(startR, startC, maxEnergy, 0));
        visited[startR][startC][0][maxEnergy] = true;

        int moves = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                State cur = queue.poll();

                if (cur.mask == allCollected) return moves;

                if (cur.energy == 0) continue;

                for (int d = 0; d < 4; d++) {
                    int nr = cur.r + dr[d];
                    int nc = cur.c + dc[d];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                    if (classroom[nr].charAt(nc) == 'X') continue;

                    int newEnergy;
                    if (classroom[nr].charAt(nc) == 'R') {
                        newEnergy = maxEnergy;
                    } else {
                        newEnergy = cur.energy - 1;
                        if (newEnergy < 0) continue;
                    }

                    int newMask = cur.mask;
                    if (classroom[nr].charAt(nc) == 'L') {
                        newMask |= (1 << litterBit[nr][nc]);
                    }

                    if (!visited[nr][nc][newMask][newEnergy]) {
                        visited[nr][nc][newMask][newEnergy] = true;
                        queue.offer(new State(nr, nc, newEnergy, newMask));
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}
