import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int R = Integer.parseInt(br.readLine());
        for (int i = 0; i < R; i++) {
            String[] S = br.readLine().split(" ");
            int num = Integer.parseInt(S[0]);
            String str = S[1];
            StringBuilder ans = new StringBuilder();
            for (int j=0; j < str.length(); j++) {
                char c = str.charAt(j);
                for (int k=0; k < num; k++) {
                    ans.append(c);
                }
            }
            System.out.println(ans);
        }
    }
}