import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int[][] apt = new int[15][15];
        // 0층~k층, 1호~14호
        // 0층의 i호에는 i명이 산다.
        for (int i = 1; i < 15; i++) {
            apt[0][i] = i;
        }
        for (int i = 1; i < 15; i++) {
            for (int j = 1; j < 15; j++) {
                // apt[i][j-1] = i층 1호부터 j-1호까지의 거주인 수의 합
                // apt[i-1][j] = i-1층 1호부터 j호까지의 거주인 수의 합
                apt[i][j] = apt[i][j - 1] + apt[i - 1][j];
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());    // k층
            int n = Integer.parseInt(br.readLine());    // n호
            System.out.println(apt[k][n]);
        }
    }
}