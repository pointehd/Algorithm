package month2010.week3;

import java.math.BigInteger;
import java.util.Arrays;

public class MutiplyStrings {
	public static void main(String[] args) {
		String num1 = "999999999";
		String num2 = "333333333";
		System.out.println(mutiply(num1, num2));
	}
	
	/**
	 * 실행시간 : 8 ms
	 * 메모리 :39.2 MB
	 * */
	public static String mutiply(String num1, String num2) {
		String[] strArr1 = num1.split("");
		String[] strArr2 = num2.split("");
		if(num1.equals("0") || num2.equals("0")) {
			return "0";
		}
		int[] numArr1 = new int[strArr1.length];
		for(int i =0; i< strArr1.length; i++) {
			numArr1[i] = Integer.parseInt(strArr1[i]);
		}
		int[] numArr2 = new int[strArr2.length];
		for(int i =0; i< strArr2.length; i++) {
			numArr2[i] = Integer.parseInt(strArr2[i]);
		}
		
		
		int[] result = new int[strArr1.length * strArr2.length +1];
		int degit1 = 0;
		for(int i = numArr1.length-1; i>= 0; i--) {
			int degit2 = 0;
			for(int j = numArr2.length-1; j>= 0; j--) {
				int mutiply = numArr1[i] * numArr2[j];
				result[degit1+degit2] = result[degit1+degit2] + mutiply;
				degit2++;
			}
			degit1++;
		}
		
		for(int i =0; i< result.length ;i++) {
			if(result[i] > 9) {
				System.out.println(result[i+1]+ " : " + result[i]/10);
				result[i+1] = result[i+1] + result[i]/10;
				result[i] = result[i]%10;
			}
		}
		boolean start =false;
		StringBuffer resultBuffer = new StringBuffer();
		for(int i = result.length-1; i>=0; i--) {
			if(result[i] != 0) {
				start = true;
			}
			if(start) {
				resultBuffer.append(result[i]);
			}
		}
		
		return resultBuffer.toString();
	}
	
	/**
	 * 실행시간 : 11 ms
	 * 메모리 : 39.5 MB
	 * 
	 * BigInteger 사용불가 라고써져있다.
	 * @date 2020. 10. 12
	 * */
	public static String mutiply1(String num1, String num2) {
		BigInteger big = new BigInteger(num1);
		BigInteger big2 = new BigInteger(num2);
		return big.multiply(big2).toString();
	}

}
