import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int tc=0; tc < t; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            int[] b = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int i=0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i=0; i < m; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(a);
            Arrays.sort(b);
            int cnt = 0;
            for (int i=0; i < n; i++) {
                cnt += binarySearch(b, a[i]);
            }
            System.out.println(cnt);
        }
    }

    // b배열에서 a[i]보다 작은 원소 개수 찾는 이분 탐색
    public static int binarySearch(int[] b, int target) {
        int start = 0;
        int end = b.length;
        while(start < end) {
            int mid = (start + end)/ 2;
            if (b[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;   // start == a[i]보다 작은 원소 개수
    }
}
