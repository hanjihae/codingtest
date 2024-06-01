import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        int idx = -1;   // ? 위치
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
            if (N == 1) {   // 끝말잇기가 ? 하나라면 처음 후보 바로 출력
                System.out.println(str2);
                break;
            }
            if (set.contains(str2)) continue;   // 끝말잇기에 나온 단어들과 중복되는 후보 제외
            if (idx == 0) { // ?가 처음 나온다면
                // ? 다음 단어의 첫 글자 == ? 후보의 마지막 글자
                if (S[idx+1].charAt(0) == str2.charAt(str2.length()-1)) {
                    System.out.println(str2);
                    break;
                }
            } else if (idx == N-1) {    // ?가 마지막에 나온다면
                // ? 이전 단어의 마지막 글자 == ? 후보의 첫 글자
                if (S[idx-1].charAt(S[idx-1].length()-1) == str2.charAt(0)) {
                    System.out.println(str2);
                    break;
                }
            } else {    // ?가 중간에 있다면
                // ? 다음 단어의 첫 글자 == ? 후보의 마지막 글자 && ? 이전 단어의 마지막 글자 == ? 후보의 첫 글자
                if (S[idx+1].charAt(0) == str2.charAt(str2.length()-1) &&
                        S[idx-1].charAt(S[idx-1].length()-1) == str2.charAt(0)) {
                    System.out.println(str2);
                    break;
                }
            }
        }
    }
}