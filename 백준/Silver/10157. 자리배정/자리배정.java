import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());    // 대기번호
        if (k > c * r) { // 대기번호가 총 좌석 수를 초과하면 0 출력
            System.out.println(0);
            return;
        }
        int[][] seats = new int[r][c];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int x = 0, y = 0;   // 초기 위치
        int dir = 0;    // 방향
        for (int i = 1; i <= k; i++) {
            seats[y][x] = i;
            if (i == k) { // k번째 좌석을 찾으면 출력
                System.out.println((x + 1) + " " + (y + 1));
                return;
            }
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            // 범위 밖에 있거나 이미 방문한 좌석일 경우
            if (nx < 0 || ny < 0 || nx >= c || ny >= r || seats[ny][nx] != 0) {
                dir = (dir + 1) % 4; // 방향 전환
                nx = x + dx[dir];
                ny = y + dy[dir];
            }
            // 위치 갱신
            x = nx;
            y = ny;
        }
    }
}
