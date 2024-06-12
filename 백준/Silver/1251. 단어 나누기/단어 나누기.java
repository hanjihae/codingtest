import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        TreeSet<String> set = new TreeSet<>();
        // 단어의 길이 적어도 1이상이어야
        for (int i = 2; i < str.length(); i++) {
            for (int j = 1; j < i; j++) {
                StringBuilder sb1 = new StringBuilder(str.substring(0, j)); // str 0~j-1
                StringBuilder sb2 = new StringBuilder(str.substring(j, i)); // str j~i-1
                StringBuilder sb3 = new StringBuilder(str.substring(i));    // str i~str.length()-1
                String ans = sb1.reverse().toString() + sb2.reverse().toString() + sb3.reverse().toString();
                set.add(ans);
            }
        }
        String res = set.stream().findFirst().orElse(null); // 사전순 정렬된 단어 중 가장 앞서는 단어
        System.out.println(res);
    }
}