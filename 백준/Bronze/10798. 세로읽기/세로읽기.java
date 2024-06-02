import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] arr = new char[5][15]; // 5줄, 줄 당 최대 15글자
        int max = 0;
        for (int i=0; i < arr.length; i++) {
            String input = br.readLine();
            if (input.length() > max) { // 각 줄마다 글자수가 다를 경우 글자수 최댓값 저장
                max = input.length();
            }
            for (int j=0; j < input.length(); j++) {
                arr[i][j] = input.charAt(j);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < max; i++) {   // 열
            for (int j=0; j < 5; j++) { // 행
                if (arr[j][i] == '\0') continue;    // 배열이 비어 있는 경우 무시하고 계속 진행
                sb.append(arr[j][i]);
            }
        }
        System.out.println(sb);
    }
}