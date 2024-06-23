import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer wh = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(wh.nextToken());
        int w = Integer.parseInt(wh.nextToken());
        int[] blocks = new int[w];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            blocks[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        for (int i = 1; i < w-1; i++) {
            int leftMax = Integer.MIN_VALUE;
            int rightMax = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {   // 현재 블록의 왼쪽 기둥 중 제일 높은 기둥
                leftMax = Math.max(leftMax, blocks[j]);
            }
            for (int j = i + 1; j < w; j++) {   // 현재 블록의 오른쪽 기둥 중 제일 높은 기둥
                rightMax = Math.max(rightMax, blocks[j]);
            }
            if (blocks[i] < leftMax && blocks[i] < rightMax) {  // 현재 블록이 제일 높은 기둥들보다 낮다면
                ans += Math.min(leftMax, rightMax) - blocks[i]; // 왼, 오 중 낮은 기둥 - 현재 기둥 빼서 더하기
            }
        }
        System.out.println(ans);
    }
}