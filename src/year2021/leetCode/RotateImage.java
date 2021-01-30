package year2021.leetCode;

/**
 * 문제설명 : 2차원배열 90도 회전
 * */
public class RotateImage {
    /**
     * 회전
     * 실행시간 : 0ms
     * 메모리 : 39.MB
     * */
    public void rotate(int[][] matrix){
        int length = matrix.length;
        int[][] rotateMatrix = new int[length][length];
        printmatrix(matrix);
        for(int i=0; i<length; i++) {
            for(int j=0; j<length; j++) {
                rotateMatrix[j][length-i-1] = matrix[i][j];
            }
        }
        for(int i=0; i<length; i++) {
            for(int j=0; j<length; j++) {
                matrix[i][j] = rotateMatrix[i][j];
            }
        }
    }
    /**
     * 2차원 배열 출력
     * */
    public void printmatrix(int[][] matrix){
        for(int[] arr: matrix){
            for(int num : arr){
                System.out.print(num + ", ");
            }
            System.out.println();
        }
        System.out.println("End");
    }
    /**
     * test main
     * */
    public static void main(String[] args) {
        RotateImage ri = new RotateImage();
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        ri.rotate(matrix);
    }
}
