import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] room;
    static int cnt = 0; // 청소한 칸의 개수
    static int[] dx = {-1, 0, 1, 0}; // 북, 동, 남, 서
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());   // 0=북, 1=동, 2=남, 3=서
        room = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {   // 0=청소 안됨, 1=벽 있음
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        clean(r, c, d);
        System.out.println(cnt);
    }

    public static void clean(int x, int y, int dir) {
        // 1. 현재 위치 청소
        if (room[x][y] == 0) { // 청소가 안 된 경우만 청소
            room[x][y] = -1; // 청소 완료
            cnt++;
        }
        // 2. 주변 4칸 확인
        for (int i = 0; i < 4; i++) {
            dir = (dir + 3) % 4; // 반시계 방향 회전
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && room[nx][ny] == 0) {
                clean(nx, ny, dir);
                return; // 이동 후 다시 4방향 확인
            }
        }
        // 3. 네 방향 모두 청소 완료 or 벽인 경우, 후진 시도
        int backDir = (dir + 2) % 4;
        int bx = x + dx[backDir];
        int by = y + dy[backDir];
        // 후진할 수 없으면 종료
        if (bx < 0 || by < 0 || bx >= n || by >= m || room[bx][by] == 1) {
            return;
        }
        // 후진하면서 방향 유지
        clean(bx, by, dir);
    }
}
