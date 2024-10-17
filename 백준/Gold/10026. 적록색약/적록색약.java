import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static char[][] colors;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        colors = new char[n][n];
        for(int i=0; i < n; i++) {
            String str = br.readLine();
            for(int j=0; j < n; j++) {
                colors[i][j] = str.charAt(j);
            }
        }
        visited = new boolean[n][n];
        int cnt1 = 0;
        for(int i=0; i < n; i++) {
            for(int j=0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    cnt1++;
                }
            }
        }
        visited = new boolean[n][n];
        int cnt2 = 0;
        for(int i=0; i < n; i++) {
            for(int j=0; j < n; j++) {
                if (!visited[i][j]) {
                    bfsForBlind(i, j);
                    cnt2++;
                }
            }
        }
        System.out.println(cnt1 + " " + cnt2);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new int[] {x, y});
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nx = now[0];
            int ny = now[1];
            for (int i=0; i < 4; i++) {
                int a = nx + dx[i];
                int b = ny + dy[i];
                if(a >=0 && a < n && b >= 0 && b < n && colors[nx][ny] == colors[a][b] && !visited[a][b]) {
                    visited[a][b] = true;
                    queue.add(new int[] {a, b});
                }
            }
        }
    }

    public static void bfsForBlind(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new int[] {x, y});
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nx = now[0];
            int ny = now[1];
            for (int i=0; i < 4; i++) {
                int a = nx + dx[i];
                int b = ny + dy[i];
                if(a >= 0 && a < n && b >= 0 && b < n && !visited[a][b]) {
                    if(colors[nx][ny] == 'R' || colors[nx][ny] == 'G') {
                        if (colors[a][b] == 'R' || colors[a][b] == 'G') {
                            visited[a][b] = true;
                            queue.add(new int[] {a, b});
                        }
                    } else {
                        if (colors[nx][ny] == colors[a][b]) {
                            visited[a][b] = true;
                            queue.add(new int[] {a, b});
                        }
                    }
                }
            }
        }
    }
}
