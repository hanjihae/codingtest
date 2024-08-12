import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int index = 0;
        while(list.size() > 0) {
            index = (index + k - 1) % list.size();  // 현재 인덱스 + k-1만큼 이동 % 남은 인원
            sb.append(list.remove(index));  // 기록 후 해당 인덱스 삭제
            if (list.size() > 0) sb.append(", ");
        }
        sb.append(">");
        System.out.println(sb);
    }
}