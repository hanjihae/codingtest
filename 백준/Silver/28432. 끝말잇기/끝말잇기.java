import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        int idx = -1;
        String[] S = new String[N];
        for (int i=0; i < N; i++) {
            String str = br.readLine();
            if (!str.equals("?")) {
                set.add(str);
            } else {
                idx = i;
            }
            S[i] = str;
        }
        int M = Integer.parseInt(br.readLine());
        for (int i=0; i < M; i++) {
            String str2 = br.readLine();
            if (N == 1) {
                System.out.println(str2);
                break;
            }
            if (set.contains(str2)) continue;
            if (idx == 0) {
                if (S[idx+1].charAt(0) == str2.charAt(str2.length()-1)) {
                    System.out.println(str2);
                    break;
                }
            } else if (idx == N-1) {
                if (S[idx-1].charAt(S[idx-1].length()-1) == str2.charAt(0)) {
                    System.out.println(str2);
                    break;
                }
            } else {
                if (S[idx+1].charAt(0) == str2.charAt(str2.length()-1) &&
                        S[idx-1].charAt(S[idx-1].length()-1) == str2.charAt(0)) {
                    System.out.println(str2);
                    break;
                }
            }
        }
    }
}