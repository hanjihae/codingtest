package week2.day3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class bk25192 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (str.equals("ENTER")) {  // 새로운 사람 들어오면 그 전 set.size() 저장 후 set 리셋
                ans += set.size();
                set.clear();
            } else {    // ENTER 이후 이름 중복없이 저장
                set.add(str);
            }
        }
        ans += set.size();  // reset 후 저장된 set.size() 더하기
        System.out.println(ans);
    }
}
