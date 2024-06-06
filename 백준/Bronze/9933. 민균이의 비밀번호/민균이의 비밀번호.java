import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];
        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
        }
        String ans = "";
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                String reverse = new StringBuilder(str[j]).reverse().toString();
                if (str[i].equals(reverse)) {
                    ans = str[i];
                }
            }
            if (ans.isEmpty()) {
                ans = str[0];
            }
        }
        System.out.println(ans.length() + " " + ans.charAt(ans.length()/2));
    }
}