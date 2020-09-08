package month2009.day08;

public class Solution1 {	
	public static void main(String[] args) {
		int n = 6;
		int[] lost = {1, 2, 6};
		int[] reserve = {2, 3, 4, 5};
		
		System.out.println("노답 "+ solution(n, lost, reserve));
	}
	
	/*
	 * 테스트 1 〉	실패 (0.02ms, 69.9MB)
	테스트 2 〉	실패 (0.04ms, 69.4MB)
	테스트 3 〉	실패 (0.02ms, 69.3MB)
	테스트 4 〉	통과 (0.03ms, 69MB)
	테스트 5 〉	실패 (0.02ms, 68.6MB)
	테스트 6 〉	실패 (0.02ms, 68.7MB)
	테스트 7 〉	실패 (0.03ms, 68.5MB)
	테스트 8 〉	통과 (0.03ms, 70.3MB)
	테스트 9 〉	통과 (0.02ms, 68.8MB)
	테스트 10 〉	실패 (0.02ms, 68.9MB)
	테스트 11 〉	통과 (0.02ms, 68.1MB)
	테스트 12 〉	실패 (0.04ms, 69.3MB)*/
	public static int solution(int n, int[] lost, int[] reserve) {
		int result = 0;
		int i =0;
		int j =0;
		while(i<lost.length && j<lost.length){
			int lostIndex = lost[i];
			for(int k =j; k<reserve.length&&lostIndex <=reserve[k]+1; k++){
                if(lostIndex == reserve[k]){
                    j++;
                    result ++;
                    System.out.println("악 ");
                    break;
                }
                if(lostIndex == reserve[k]-1){
                	if(i+1==lost.length){
                    	System.out.println("악 ");
                        j = k+1;
					result++;
					break;
                    }
                    if(i+1< lost.length && lost[i+1] != reserve[k]){
                        j = k+1;
                        System.out.println("악 ");
					result++;
					break;
                        
                    }
                    
                    
                }
				if ( lostIndex == reserve[k]+1){
					if(i-1<0){
                        j = k+1;
                        System.out.println("악 ");
                        result++;
                        break; 
                    }
                    if(i-1>= 0 && lost[i-1] != reserve[k]){
                    	System.out.println("악 ");
                       j = k+1;
                        result++;
                        break; 
                    }
                    
				}
			}
			i++;
		}
		return n - lost.length + result;
	}
}
