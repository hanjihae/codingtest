import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());    // 스위치 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n]; // 스위치 상태
        for (int i =0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int all = Integer.parseInt(br.readLine());  // 학생 수
        for (int i =0; i < all; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int gen = Integer.parseInt(st2.nextToken());
            int num = Integer.parseInt(st2.nextToken());
            if (gen == 1) { // 남자
                for (int j=0; j < n; j++) {
                    if ( (j+1) % num == 0) {  // 스위치 번호가 1부터 시작하므로
                        arr[j] = arr[j] == 0 ? 1 : 0;
                    }
                }
            } else {    // 여자
                int w = num-1;
                arr[w] = arr[w] == 0 ? 1 : 0;   // 여자 스위치 3번 0>1, 1>0
                for (int j=0; j < n/2; j++) {
                    if (w-j < 0 || w + j >= n) break;
                    if (arr[w-j] == arr[w+j]) { // 대칭이면 0>1, 1>0
                        arr[w-j] = arr[w-j] == 0 ? 1 : 0;
                        arr[w+j] = arr[w+j] == 0 ? 1 : 0;
                    } else {
                        break;
                    }
                }
            }
        }
        for (int i =0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            if ((i+1) % 20 == 0) {  // 1줄에 20개씩 / i=0일 때 줄바꿈 되므로 i+1
                System.out.println();
            }
        }
    }
}