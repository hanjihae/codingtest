import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static boolean[][] chess;
    public static int minCount = 64;    // 8*8 최댓값 저장
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        chess = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'W') { // W일 때 true
                    chess[i][j] = true;
                } else {    // B일 때 false
                    chess[i][j] = false;
                }
            }
        }
        int row = N - 7, col = M - 7;   // 8*8 크기의 체스판만 필요하므로
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) { // 모든 경우의 수의 최솟값을 구함
                findMinValue(i, j);
            }
        }
        System.out.println(minCount);
    }

    public static void findMinValue(int x, int y) {
        int endX = x + 8, endY = y + 8;
        int count = 0;
        boolean tf = chess[x][y];   // 첫 번째 칸의 색
        for (int i = x; i < endX; i++) {
            for (int j = y; j < endY; j++) {
                if (chess[i][j] != tf) {    // 올바른 색이 아닐 경우 +1
                    count++;
                }
                tf = (!tf); // 다음 칸은 색이 바뀌므로
            }
            tf = (!tf); // 위 칸과 색이 교차해야 하므로
        }
        // 첫 번째 칸을 기준으로 색칠할 개수와 그 반대색을 기준으로 색칠할 개수 중 최솟값
        count = Math.min(count, 64 - count);
        // 모든 경우의 수에서 나온 최솟값 중 가장 작은 값 저장
        minCount = Math.min(minCount, count);
    }
}