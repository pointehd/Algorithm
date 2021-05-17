package year2021.codingtest.startup;


import java.io.*;

public class Main1 {
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int count = Integer.parseInt(input);
        int start =0;
        int end = 1440;
        for(int i =0; i< count; i++){
            String time = br.readLine();
            start = Math.max(getTime(time.substring(0, time.indexOf('~')-1)), start);
            end = Math.min(getTime(time.substring(time.indexOf('~')+2)), end);
            if(start >= end){
                System.out.println("-1");
                return ;
            }
        }
        System.out.println(toTime(start) + " ~ " + toTime(end));
    }
    /**
     * 13:00 -> 60*13 + 0
     * -> 780
     * */
    public static int getTime(String start){
        int result = 0;
        result += Integer.parseInt(start.substring(start.indexOf(':')+1));
        result += 60*Integer.parseInt(start.substring(0,start.indexOf(':')));
        return result;
    }

    /**
     * 780 -> 13:00
     * */
    public static String toTime(int time){
        String hour = time/60 < 10 ? "0"+time/60 : time/60+"";
        String minute =time%60 < 10 ? "0"+time%60 : time%60+"";
        return hour+":"+minute;
    }
}
