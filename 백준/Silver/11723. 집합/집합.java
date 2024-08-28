import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            String s = str[0];
            int x = 0;
            if (str.length == 1) {
                if (s.equals("all")) {
                    list.clear();
                    for (int j=1; j <= 20; j++) {
                        list.add(j);
                    }
                } else if (s.equals("empty")) {
                    list.clear();
                }
            } else {
                x = Integer.parseInt(str[1]);
            }
            if (s.equals("add")) {
                if (!list.contains(x)) {
                    list.add(x);
                }
            } else if (s.equals("remove")) {
                if (!list.isEmpty() && list.contains(x)) {
                    int index = list.indexOf(x);
                    list.remove(index);
                }
            } else if (s.equals("check")) {
                if (!list.isEmpty() && list.contains(x)) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            } else if (s.equals("toggle")) {
                if (list.contains(x)) {
                    int index = list.indexOf(x);
                    list.remove(index);
                } else {
                    list.add(x);
                }
            }
        }
        System.out.println(sb);
    }
}
