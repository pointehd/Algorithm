package year2021.codingtest.startup;

import java.io.*;
public class Main2 {

    public static int count = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        boolean[] booleanPoint = new boolean[size];
        for(int i=0; i< booleanPoint.length; i++){
            booleanPoint[i] = (char)br.read() == '1';
        }
        nextPoint(0, booleanPoint);

        System.out.println(count);
    }
    public static void nextPoint(int now, boolean[] points){
        if(now >= points.length || !points[now]){
            return ;
        }
        if(now == points.length-1){
            count ++;
            return ;
        }
        nextPoint(now+1, points);
        nextPoint(now+2, points);
    }
}
