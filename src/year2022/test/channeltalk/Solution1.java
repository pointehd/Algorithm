package year2022.test.channeltalk;

class Solution1 {
    public int solution(int a, int b, int budget) {
        int answer = 0;
        int max = Math.max(a,b);
        int min = Math.min(a, b);
        int maxBuyCount = budget / max + 1;

        for (int i = 0; i < maxBuyCount; i++) {
            int sum = max * i;
            int result = budget - sum;
            if(result % min ==0){
                answer ++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(new Solution1().solution(3000, 5000, 23000));
    }
}
