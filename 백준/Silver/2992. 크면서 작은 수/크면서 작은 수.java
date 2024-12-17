import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int x;
    static char[] arr;
    static boolean[] visited;
    static int max = 1000000;
    static int min = max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        x = Integer.parseInt(input);
        arr = input.toCharArray();
        visited = new boolean[arr.length];
        char[] nums = new char[arr.length];
        backtracking(nums, 0);
        System.out.println(min == max ? 0 : min);   // 없으면 0 출력
    }

    public static void backtracking(char[] nums, int depth) {
        if (depth == arr.length) {  // 자릿수 맞추면
            int res = Integer.parseInt(String.valueOf(nums));
            if (x < res) {  // x보다 큰 수일 때
                min = Math.min(min, res);   // 가장 작은 수 찾기
            }
            return;
        }
        for (int i=0; i < arr.length; i++) {
            if (!visited[i]) {  // 방문하지 않은 자릿수일 때
                visited[i] = true;
                nums[depth] = arr[i];   // 현재 깊이에 해당 자릿수 저장
                backtracking(nums, depth + 1);  // 다음 깊이로
                visited[i] = false; // 해당 자릿수 사용 후 방문 해제
            }
        }
    }
}
