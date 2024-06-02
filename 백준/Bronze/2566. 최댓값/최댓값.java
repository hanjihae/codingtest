import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[9][9];
        int max = Integer.MIN_VALUE;
        int[] maxArr = new int[2];
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] >= max) {
                    max = arr[i][j];
                    maxArr[0] = i+1;
                    maxArr[1] = j+1;
                }
            }
        }
        System.out.println(max);
        System.out.println(maxArr[0] + " " + maxArr[1]);
    }
}