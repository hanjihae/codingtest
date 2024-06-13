public class Main {
    public static void main(String[] args) {
        boolean[] selfOrNot = new boolean[10001];
        for (int i=1; i < 10001; i++) {
            int n = d(i);
            if (n < 10001) {   // 생성자가 있으면 true
                selfOrNot[n] = true;
            }
        }
        for (int i=1; i < 10001; i++) {    // 생성자 없는 숫자 = 셀프넘버
            // selfOrNot[i] == false 인 숫자 출력
            if (!selfOrNot[i]) System.out.println(i);
        }
    }

    public static int d(int n) {
        int sum = n;
        while (n != 0) {
            sum = sum + (n % 10);   // 첫째 자릿수
            n = n/10;   // 10을 나눠 첫째 자릿수 제거
        }
        return sum;
    }
}