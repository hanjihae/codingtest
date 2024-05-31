import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> nList = new HashSet<>();
        TreeSet<String> list = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            nList.add(br.readLine());
        }
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (nList.contains(str)) {
                list.add(str);
            }
        }
        System.out.println(list.size());
        for (String s : list) {
            System.out.println(s);
        }
    }
}