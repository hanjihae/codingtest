import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i=0; i < n; i++) {
            arr[i] = br.readLine();
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 1. 길이가 짧은 것부터
                if(o1.length() != o2.length()) {
                  return o1.length() - o2.length();
                }
                // 2. 길이가 같으면, 모든 자리 수의 합이 작은 것부터
                int s1 = getSum(o1);
                int s2 = getSum(o2);
                if (s1 != s2) return s1 - s2;
                // 3. 사전순 정렬
                return o1.compareTo(o2);
            }
            // 문자열 안의 숫자 합 구하기
            public int getSum(String str) {
                int sum = 0;
                for (char c : str.toCharArray()) {
                    if (Character.isDigit(c)) { // 해당 문자가 숫자면 true, 아니면 false
                        sum += c - '0';
                    }
                }
                return sum;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i=0; i < n; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }
}
