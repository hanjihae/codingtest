package week2.day2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class bk7785 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> list = new HashSet<>();
        for (int i=0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
            String name = tokenizer.nextToken();
            String el = tokenizer.nextToken();
            if (el.equals("enter")) {
                list.add(name);
            } else {
                list.remove(name);
            }
        }
        ArrayList<String> list2 = new ArrayList<>(list);
        list2.sort(Collections.reverseOrder());
        for (String s : list2) {
            System.out.println(s);
        }
    }
}
