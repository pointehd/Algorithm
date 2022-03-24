package year2022.test.socar;

class Solution2 {
    int result = Integer.MAX_VALUE;
    public int solution(int[] numbers, int K) {
        cycle(numbers, K, 0, 0);
        return result;
    }

    public void cycle(int[] numbers, int K, int start, int count) {
        if(count > result) {
            return ;
        }
        boolean falg = true;
        for(int i = 0; i<numbers.length; i++) {
            if (!match(numbers, i, K)) {
                falg = false;
                for (int j = i + 1; j < numbers.length; j++) {
                    int[] swapNumbers = swap(numbers, i, j);
                    if (match(swapNumbers, i, K)) {
                        cycle(swapNumbers, K, i + 1, count + 1);
                    }
                }
            }
        }
        if(falg) {
            result = Math.min(count, result);
        }
    }

    public int[] swap(int[] numbers, int i, int j) {
        int[] swapNumber = numbers.clone();
        int temp = swapNumber[i];
        swapNumber[i] = swapNumber[j];
        swapNumber[j] = temp;
        return swapNumber;
    }



    public boolean match(int[] numbers, int i, int K) {
        int left = i - 1;
        int right = i + 1;
        boolean leftFlag = true;
        boolean rightFlag = true;
        if( left >= 0) {
            leftFlag = Math.abs(numbers[i] - numbers[left]) <= K;
        }
        if ( right < numbers.length) {
            rightFlag = Math.abs(numbers[i] - numbers[right]) <= K;
        }
        return leftFlag && rightFlag;
    }

    public static void main(String[] args) {
        int[] numbers = {10, 40, 30, 20};
        int K = 20;
        System.out.println(new Solution2().solution(numbers, K));
    }


}
