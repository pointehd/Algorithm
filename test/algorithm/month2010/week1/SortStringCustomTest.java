package algorithm.month2010.week1;

import static org.junit.Assert.*;

import org.junit.Test;

import month2010.week1.SortStringCustom;


public class SortStringCustomTest {
	
	
	SortStringCustom ssc = new SortStringCustom();

	@Test
	public void test() {
		assertEquals(ssc.sortString(new String[]{"sun", "bed", "car"}, 1), new String[] {"car","bed", "sun"});
		System.out.println();
		assertEquals(ssc.sortString(new String[]{"axp","sxun","axb","sxun", "ax", "cxar"}, 1), 
				new String[] {"ax","axb","axp","cxar","sxun", "sxun"});
		System.out.println();
	}

}
