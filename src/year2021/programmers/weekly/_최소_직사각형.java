package year2021.programmers.weekly;

/**
 * Programmers. 최소 직사각형
 * https://programmers.co.kr/learn/courses/30/lessons/86491
 */
class _최소_직사각형 {
    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;
        for (int[] size : sizes) {
            int width = Math.min(size[0], size[1]);
            int height = Math.max(size[0], size[1]);
            maxHeight = Math.max(maxHeight, height);
            maxWidth = Math.max(maxWidth, width);
        }
        return maxHeight * maxWidth;
    }
}
