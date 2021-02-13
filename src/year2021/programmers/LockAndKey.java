package year2021.programmers;

// TODO 빨라히자
public class LockAndKey {
	
	public static void main(String[] args) {
		LockAndKey lak = new LockAndKey();
//		System.out.println(0|1);  // | 비교로 확인가능 
		int[][] key = {{0,0,0}, {1,0,0}, {0,1,1}};
		int[][] lock = {{1,1,1}, {1,1,0}, {1,0,1}};
		lak.solution(key, lock);
	}
	
	public boolean solution(int[][] key, int[][] lock) {
		int[][] tempLock = tempLockMaker(lock, key.length);
		matchKey(key, tempLock);
		for(int i =0;i < 4; i++) {
			key = rotate(key);
			matchKey(key, tempLock);
		}
		return true;
	}
	
	public boolean matchKey(int[][] key, int[][] lock) {
		
		
//		key 출력 
//		for (int i=0; i< key.length; i++) {
//			for(int j=0; j<key[i].length; j++) {
//				System.out.print(key[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		return true;
	}
	
	/**
	 * key 를 모든 위치에서 매칭할수 있도록 lock 확장  
	 * */
	public int[][] tempLockMaker(int[][] lock, int keyLength){
		int tempLength = (keyLength-1) * 2 + lock.length;
		int lockLength = lock.length;
		int[][] tempLock = new int[tempLength][tempLength];
		for(int i =0; i<lockLength; i++) {
			for(int j =0; j<lockLength; j++) {
				tempLock[i+keyLength-1][j+keyLength-1] = lock[i][j];
			}
		}
		
		return tempLock;
	}
	
	/*
	 * 90도 시계방향 회전
	 * 1,1,0      0,0,1
	 * 0,1,1  ->  0,1,1
	 * 0,0,0      0,1,0
	 * */
	public int[][] rotate(int[][] key) {
		int length = key.length;
		int[][] rotateKey = new int[length][length];
		for(int i=0; i<length; i++) {
			for(int j=0; j<length; j++) {
				rotateKey[j][length-i-1] = key[i][j];
			}
		}
		return rotateKey;
	}
	
}
