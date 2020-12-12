package month2012.week2;

public class SortColors {
	public int[] sortColor(int[] nums) {
		int[] numCount = new int[3];
		for (int i=0; i<nums.length; i++) {
			numCount[nums[i]]++;
		}
		int index = 0;
		for(int i=0; i<numCount.length; i++) {
			for(int j=0; j<numCount[i]; j++) {
				nums[index++] = i;
			}
		}
		return nums;
	}
}
