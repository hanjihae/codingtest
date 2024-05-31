package week2.day3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bk1764 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> nList = new HashSet<>();
        TreeSet<String> list = new TreeSet<>();    // 자동으로 사전순 정렬
        for (int i = 0; i < N; i++) {   // 듣도 못한 사람 nList에 저장
            nList.add(br.readLine());
        }
        for (int i = 0; i < M; i++) {   // 보도 못한 사람
            String str = br.readLine();
            if (nList.contains(str)) {  // 듣도 못한 사람에 있는 이름이면 list에 저장
                list.add(str);
            }
        }
        System.out.println(list.size());
        for (String s : list) {
            System.out.println(s);
        }
    }
}
