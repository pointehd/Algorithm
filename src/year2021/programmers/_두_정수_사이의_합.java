package year2021.programmers;

class _두_정수_사이의_합 {
    public long solution(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        long sum = 0;
        for (int i = min; i <= max; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
