package month2010.week3;

import java.math.BigInteger;

public class MutiplyStrings {
	
	/**
	 * 실행시간 : 11 ms
	 * 메모리 : 39.5 MB
	 * 
	 * BigInteger 사용불가 라고써져있다.
	 * @date 2020. 10. 12
	 * */
	public static String mutiply(String num1, String num2) {
		BigInteger big = new BigInteger(num1);
		BigInteger big2 = new BigInteger(num2);
		return big.multiply(big2).toString();
	}

}
