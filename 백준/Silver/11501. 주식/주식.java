import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int c=0; c < t; c++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] stocks = new int[n];
            for (int i=0; i < n; i++) {
                stocks[i] = Integer.parseInt(st.nextToken());
            }
            int max = 0;
            long profit = 0;
            for (int i=n-1; i >= 0; i--) {
                if (stocks[i] > max) {  // 최대가격이 현재 주식보다 낮다면
                    max = stocks[i];    // 최대가격 갱신
                } else {    // 최대가격이 현재 주식보다 높다면
                    profit += max - stocks[i];  // 최대 이익 계산
                }
            }
            System.out.println(profit);
        }
    }
}
