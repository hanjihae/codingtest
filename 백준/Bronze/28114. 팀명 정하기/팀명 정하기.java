import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer, String> map = new TreeMap<>(); // key 오름차순 자동정렬
        String[] years = new String[3];
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int score = Integer.parseInt(st.nextToken());   // 백준 점수
            years[i] = st.nextToken().substring(2); // 연도 뒤에서 2글자만 떼서 배열에 저장
            String name = st.nextToken();   // 선수 이름
            map.put(score, name);   // Treeset key:백준 점수, value:선수 이름
        }
        Arrays.sort(years); // 연도 오름차순 정렬
        String year = "";
        for (int i = 0; i < years.length; i++) {
            year += years[i];
        }
        StringBuilder sb = new StringBuilder();
        for (String value : map.values()) { // 백준점수 오름차순 정렬 기준 선수 이름 첫글자만 떼서 이어 붙인 sb
            sb.append(value.substring(0,1));
        }
        String teamName = sb.reverse().toString();  // sb 거꾸로 뒤집어 문자열로 변환
        System.out.println(Integer.parseInt(year));
        System.out.println(teamName);
    }
}