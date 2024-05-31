package week2.day3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//  MenOfPassion(A[], n) {  // 루프가 n*n*n번 == O(n3)의 차수 3
//    sum <- 0;
//    for i <- 1 to n - 2       // nCr = n!/(n-r)!*r! = n*(n-1)(n-2)/6
//    for j <- i + 1 to n - 1
//    for k <- j + 1 to n
//    sum <- sum + A[i] × A[j] × A[k]; # 코드1
//    return sum;
//  }

public class bk24267 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        System.out.println((n*(n-1)*(n-2))/6);
        System.out.println(3);
    }
}
