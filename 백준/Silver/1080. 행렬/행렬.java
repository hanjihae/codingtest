import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] a;
    static int[][] b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n][m];
        b = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = line.charAt(j) - '0';
            }
        }
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                b[i][j] = line.charAt(j) - '0';
            }
        }
        int cnt = 0;
        for (int i=0; i < n-2; i++) {
            for (int j=0; j < m-2; j++) {
                if (a[i][j] != b[i][j]) {
                    flip(i, j);
                    cnt++;
                }
            }
        }
        if (isSame()) { // A와 B가 같으면 cnt 출력
            System.out.println(cnt);
        } else {
            System.out.println(-1); // 변환 불가능
        }
    }

    static void flip(int x, int y) {    // 뒤집기
        for (int i=x; i < x+3; i++) {
            for (int j=y; j < y+3; j++) {
                a[i][j] = 1 - a[i][j];  // 0 > 1, 1 > 0
            }
        }
    }

    static boolean isSame() {   // A와 B가 같은지 확인
        for (int i=0; i < n; i++) {
            for (int j=0; j < m; j++) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
