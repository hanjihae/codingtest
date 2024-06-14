import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for(int i=0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {   // 회의 종료 시간이 같다면
                    return o1[0] - o2[0];   // 회의 시작 시간이 빠른 순으로 정렬
                }
                return o1[1] - o2[1];   // 회의 종료 시간 빠른 순 정렬
            }
        });
        int cnt = 0;
        int prevEnd = 0;
        for (int i = 0; i < n; i++) {
            if (prevEnd <= arr[i][0]) { // 회의 종료 시간이 다음 회의 시작 시간보다 작거나 같다면 갱신
                prevEnd = arr[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}