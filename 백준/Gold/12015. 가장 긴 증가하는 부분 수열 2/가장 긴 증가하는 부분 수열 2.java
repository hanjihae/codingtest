import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : a) {
            // 리스트가 비어있거나 마지막 원소보다 크면
            if (list.isEmpty() || list.get(list.size() - 1) < num) {
                list.add(num);  // 리스트에 추가
            } else {    // num이 들어갈 위치 이분탐색
                int idx = binarySearch(list, num);
                list.set(idx, num); // 해당 위치 num으로 변경
            }
        }
        System.out.println(list.size());
    }

    public static int binarySearch(ArrayList<Integer> list, int num) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid) >= num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
