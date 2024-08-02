import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeSet<String> set = new TreeSet<>((o1, o2) -> {
           if (o1.length() != o2.length()) {
               return o1.length() - o2.length();
               // 길이가 짧은 순
               // 결과가 양수면 o2 - o1 , 음수면 o1 - o2 순서로 정렬
           } else {
               return o1.compareTo(o2); // 사전순 (원래 TreeSet을 활용하겠단 뜻)
           }
        });
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        List<String> list = new ArrayList<>(set);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}