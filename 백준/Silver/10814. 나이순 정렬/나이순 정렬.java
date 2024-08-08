import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Member {
    int age;
    String name;
    int order;

    Member(int age, String name, int order) {
        this.age = age;
        this.name = name;
        this.order = order;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Member[] members = new Member[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            members[i] =  new Member(age, name, i);
        }
        Arrays.sort(members, (a, b) -> {
            if (a.age == b.age) { // 만약 나이가 같다면
                // 먼저 가입한 사람순으로 정렬
                return Integer.compare(a.order, b.order);
            } else {    // 나이 오름차순 정렬
                return Integer.compare(a.age, b.age);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(members[i].age + " " + members[i].name + "\n");
        }
        System.out.println(sb);
    }
}
