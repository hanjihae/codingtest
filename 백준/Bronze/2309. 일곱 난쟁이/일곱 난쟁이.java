import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] gnome = new int[9];   // 9명 중 2명 가짜
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            gnome[i] = Integer.parseInt(br.readLine());
            sum += gnome[i];
        }
        for (int i = 0; i < 8; i++) {
            for (int j = i+1; j < 9; j++) {
                if (sum - gnome[i] - gnome[j] == 100) { // 합계에서 2명 난쟁이 키 제외했을 때 100이면 그 2명이 가짜
                    gnome[i] = 0;
                    gnome[j] = 0;
                    Arrays.sort(gnome);
                    for(int k=2; k < 9; k++) {  // 가짜 제외하고 출력
                        System.out.println(gnome[k]);
                    }
                    return; // 조건에 맞는 가짜 2명 찾으면 종료
                }
            }
        }
    }
}
