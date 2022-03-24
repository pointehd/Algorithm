package year2022.test.channeltalk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * 정확성 테스트
 * 테스트 1 〉 통과 (0.69ms, 76.6MB)
 * 테스트 2 〉 통과 (0.62ms, 76.3MB)
 * 테스트 3 〉 통과 (0.69ms, 71.2MB)
 * 테스트 4 〉 통과 (0.62ms, 72.4MB)
 * 테스트 5 〉 실패 (런타임 에러)
 * 테스트 6 〉 통과 (0.70ms, 75MB)
 * 테스트 7 〉 통과 (0.58ms, 76.5MB)
 * 테스트 8 〉 실패 (런타임 에러)
 * 테스트 9 〉 통과 (0.79ms, 76.7MB)
 * 테스트 10 〉 통과 (0.66ms, 75.4MB)
 * 테스트 11 〉 통과 (0.53ms, 75.3MB)
 * 테스트 12 〉 통과 (0.95ms, 81.1MB)
 * 테스트 13 〉 실패 (런타임 에러)
 * 테스트 14 〉 통과 (0.86ms, 77MB)
 * 테스트 15 〉 실패 (런타임 에러)
 * 테스트 16 〉 통과 (0.86ms, 90.5MB)
 * 테스트 17 〉 통과 (7.46ms, 87.4MB)
 * 테스트 18 〉 통과 (9.05ms, 75.4MB)
 * 테스트 19 〉 통과 (7.65ms, 78MB)
 * 테스트 20 〉 통과 (7.53ms, 77.6MB)
 * 테스트 21 〉 통과 (6.62ms, 77.7MB)
 * 테스트 22 〉 통과 (0.57ms, 71.4MB)
 * 효율성 테스트
 * 테스트 1 〉 실패 (런타임 에러)
 * 테스트 2 〉 실패 (시간 초과)
 * 테스트 3 〉 실패 (런타임 에러)
 * 테스트 4 〉 실패 (시간 초과)
 * 테스트 5 〉 실패 (런타임 에러)
 * */
class Solution2 {
    public int [][] solution(int [][] L) {
        Arrays.sort(L,(o1, o2)->{
            if(o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }else {
                return Integer.compare(o1[0], o2[0]);
            }
        });
//        Arrays.sort((L), ((o1, o2) -> ));
        Arrays.stream(L).forEach((e) -> {
            System.out.println(Arrays.toString(e));
        });
//        System.out.println("========================");

        List<int[]> resultList = new ArrayList<>();
        List<int[]> list = new ArrayList<>(asList(L));

        int[][] result = new int[L.length][2];
        int index = 0;

        while(true){
            int[] tmp = list.get(index);
            if(tmp[1]<=0) {
                resultList.add(tmp);
                list.remove(tmp);
                break;
            }else{
                index++;
            }
        }
        index =0;
        while(!list.isEmpty()){
            int a = list.get(index)[0];
            int b = list.get(index)[1];
            int count =0;
            for (int[] ints : resultList) {
                if (a <= ints[0]) {
                    count++;
                }
            }
            if(count==b){
                resultList.add(list.get(index));
                list.remove(index);
                index =0;

//                resultList.stream().forEach(e -> {
//                    System.out.println(Arrays.toString(e));
//                });
            }else{
//                System.out.println("false ============================= count"+count + ", index: "+ index);
                index++;
            }

        }

        for(int i=0;i<resultList.size();i++){
            result[i] = resultList.get(i);
        }
        return result;
    }


    public static void main(String[] args) {
        int[][] answer = {{7,0},{5,0},{5,3},{6,1}};
        int[][] answer1 = {{3,0},{3,1},{3,2}};
        int[][] answer2 = {{5,0},{7,0},{5,2},{6,1}, {4,4}, {7,1}};
        int[][] results  =new Solution2().solution(answer);
//        System.out.println("+++++++++++++++++++++++++");
        for(int[] result: results)
            System.out.println(Arrays.toString(result));
    }
}