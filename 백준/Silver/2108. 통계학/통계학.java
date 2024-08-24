import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        // 데이터 입력 및 통계치 계산을 위한 초기화
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        // 1. 산술평균
        int avg = (int) Math.round((double) sum / n);

        // 2. 중앙값
        Arrays.sort(arr);
        int mid = arr[n / 2];

        // 3. 최빈값
        int mod = findMod(map, arr);

        // 4. 범위
        int range = arr[n - 1] - arr[0];

        // 결과 출력
        System.out.println(avg);
        System.out.println(mid);
        System.out.println(mod);
        System.out.println(range);
    }

    public static int findMod(Map<Integer, Integer> map, int[] arr) {
        // 빈도수 리스트를 준비합니다.
        ArrayList<Integer> modeList = new ArrayList<>();
        int maxFreq = 0;

        // 최대 빈도수를 구합니다.
        for (int freq : map.values()) {
            if (freq > maxFreq) {
                maxFreq = freq;
            }
        }

        // 최대 빈도수를 가진 숫자들을 리스트에 추가합니다.
        for (int num : map.keySet()) {
            if (map.get(num) == maxFreq) {
                modeList.add(num);
            }
        }

        // 여러 개일 경우, 두 번째로 작은 값을 찾기 위해 정렬
        Collections.sort(modeList);

        // 최빈값이 여러 개라면 두 번째로 작은 값을 반환합니다.
        if (modeList.size() > 1) {
            return modeList.get(1);
        } else {
            return modeList.get(0); // 하나라면 그것이 최빈값입니다.
        }
    }
}
