import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] gnome = new int[9];
        int sum = 0;
        for (int i=0; i < 9; i++) {
            gnome[i] = Integer.parseInt(br.readLine());
            sum += gnome[i];    // 아홉 난쟁이 키의 합
        }
        for (int i=0; i < 8; i++) {
            for (int j=i+1; j < 9; j++) {
                if (sum - gnome[i] - gnome[j] == 100) { // 모든 난쟁이 키의 합에서 두 난쟁이의 키를 뺐을 때 100인 경우
                    gnome[i] = 0;
                    gnome[j] = 0;
                    Arrays.sort(gnome); // 오름차순 정렬
                    // 오름차순 정렬시 0 처리된 두 난쟁이의 인덱스는 각가 0, 1이므로 gnome[2]~gnome[8] 출력
                    for (int k=2; k < 9; k++) {
                        System.out.println(gnome[k]);
                    }
                    return; // 가짜 난쟁이 찾았으면 프로그램 종료
                }
            }
        }
    }
}