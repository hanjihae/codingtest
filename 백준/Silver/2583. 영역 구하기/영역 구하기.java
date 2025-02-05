import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// K개 직사각형 내부 제외한 나머지는 몇 개의 분리된 영역으로 나누어지는지 + 분리된 각 영역 넓이 출력
public class Main {
    static int m, n, k;
    static int[][] arr;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());   // 세로
        n = Integer.parseInt(st.nextToken());   // 가로
        k = Integer.parseInt(st.nextToken());   // 직사각형 개수
        arr = new int[m][n];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());    // 직사각형
            int x1 = Integer.parseInt(st.nextToken());  // 왼쪽 밑 x
            int y1 = Integer.parseInt(st.nextToken());  // 왼쪽 밑 y
            int x2 = Integer.parseInt(st.nextToken());  // 오른쪽위 x
            int y2 = Integer.parseInt(st.nextToken());  // 오른쪽 위 y
            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    arr[y][x] = 1;  // 직사각형 내부 채우기
                }
            }
        }
        List<Integer> list = new ArrayList<>(); // 0 영역 리스트
        for (int i=0; i < m; i++) {
            for (int j=0; j < n; j++) {
                if (arr[i][j] == 0) {   // 방문하지 않은 빈 공간일 때 bfs
                    list.add(bfs(i, j));    // 영역 크기 추가
                }
            }
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        for (int area : list) {
            sb.append(area).append(" ");
        }
        System.out.println(sb);
    }

    public static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y}); 
        arr[x][y] = 1;  // 0 > 1 방문처리
        int areaSize = 1;   // 시작점 포함하므로 1로 시작
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            for (int i=0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                // 좌표가 범위 내에 있고 방문하지 않은 빈 칸의 경우
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && arr[nx][ny] == 0) {
                    arr[nx][ny] = 1;
                    queue.add(new int[]{nx, ny});
                    areaSize++; // 영역 크기 증가
                }
            }
        }
        return areaSize;
    }
}
