package week2.day3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//  MenOfPassion(A[], n) {  // 루프가 n*n == O(n2)의 차수2
//    sum <- 0;
//    for i <- 1 to n - 1   // 1~6 만큼
//    for j <- i + 1 to n   // i가 한 번 돌 때 i+1~n 만큼 ==> 등차수열 n(n+1)/2 ==> (n-1)(n-1+1)/2 ==> n(n-1)/2
//    sum <- sum + A[i] × A[j]; # 코드1
//    return sum;
//  }

public class bk24265 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(br.readLine());
        System.out.println((n*(n-1))/2);
        System.out.println(2);
    }
}
