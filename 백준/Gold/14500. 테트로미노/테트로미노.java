import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

/*
 * ㅡ (x, y), (x, y+1), (x, y+2), (x, y+3)
 * ㄴ (x, y), (x-1, y), (x-2, y), (x-2, y+1)
 * ㄹ (x, y), (x-1, y), (x-1, y+1), (x-2, y+1)
 * ㅁ (x, y), (x, y+1), (x-1, y), (x-1, y+1)
 * ㅜ (x, y), (x, y+1), (x, y+2), (x-1, y+1)
 * */

public class Main {
    static int n, m;
    static int[][] arr;
    static int[][][] tetromino = {
            { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } },
            { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 0, 3 } },
            { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 3, 0 } },
            { { 0, 0 }, { 0, 1 }, { 0, 2 }, { -1, 2 } },
            { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 2, 1 } },
            { { 0, 0 }, { 1, 0 }, { 0, 1 }, { 0, 2 } },
            { { 0, 0 }, { 0, 1 }, { 1, 1 }, { 2, 1 } },
            { { 0, 0 }, { 0, 1 }, { -1, 1 }, { -1, 2 } },
            { { 0, 0 }, { 1, 0 }, { 1, 1 }, { 2, 1 } },
            { { 0, 0 }, { 0, 1 }, { 0, 2 }, { -1, 1 } },
            { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 1, 1 } },
            { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 1 } },
            { { 0, 0 }, { 0, 1 }, { -1, 1 }, { 1, 1 } },
            { { 0, 0 }, { 0, 1 }, { 1, 1 }, { 1, 2 } },
            { { 0, 0 }, { 1, 0 }, { 1, -1 }, { 2, -1 } },
            { { 0, 0 }, { 1, 0 }, { 1, 1 }, { 1, 2 } },
            { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 2, 0 } },
            { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 2 } },
            { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 2, -1 } }
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i=0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i < n; i++) {
            for(int j=0; j < m; j++) {
                for(int[][] shape : tetromino) {
                    int sum = findMax(i, j, shape);
                    max = Math.max(sum, max);
                }
            }
        }
        System.out.println(max);
    }

    public static int findMax(int x, int y, int[][] shape) {
        int sum = 0;
        for (int[] dir : shape) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                sum += arr[nx][ny];
            } else {    // 좌표가 배열 범위에서 벗어난 경우
                return 0;
            }
        }
        return sum;
    }
}
