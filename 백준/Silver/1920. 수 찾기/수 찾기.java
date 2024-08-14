import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arrA = new int[n];
        for (int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrA);
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            int yn = findNumber(arrA, num) ? 1: 0;
            sb.append(yn + "\n");
        }
        System.out.println(sb);
    }

    public static boolean findNumber(int[] arr, int num) {
        int start = 0;
        int end = arr.length-1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == num) {
                return true;
            } else {
                if (arr[mid] > num) {
                    end = mid - 1;
                } else if (arr[mid] < num){
                    start = mid + 1;
                }
            }
        }
        return false;
    }
}