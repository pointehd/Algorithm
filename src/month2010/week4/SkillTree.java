package month2010.week4;

public class SkillTree {
	public static void main(String[] args) {
		String skill = "CBD";
		String[]  skillTrees = {"BACDE", "CBADF", "AECB", "BDA"};
		SkillTree tree = new SkillTree();
		tree.skillTree(skill, skillTrees);
	}
	
	/**
	 *  테스트 1 〉	통과 (0.15ms, 52.3MB)
		테스트 2 〉	통과 (0.15ms, 52.1MB)
		테스트 3 〉	통과 (0.15ms, 55.7MB)
		테스트 4 〉	통과 (0.16ms, 52.1MB)
		테스트 5 〉	통과 (0.17ms, 60.9MB)
		테스트 6 〉	통과 (0.15ms, 52.8MB)
		테스트 7 〉	통과 (0.16ms, 52.9MB)
		테스트 8 〉	통과 (0.17ms, 52MB)
		테스트 9 〉	통과 (0.25ms, 53.4MB)
		테스트 10 〉	통과 (0.19ms, 53.4MB)
		테스트 11 〉	통과 (0.18ms, 52.8MB)
		테스트 12 〉	통과 (0.42ms, 54.2MB)
		테스트 13 〉	통과 (0.21ms, 52.8MB)
		테스트 14 〉	통과 (0.14ms, 52.3MB)*/
	public int skillTree(String skill, String[] skill_trees) {
		int result = 0;
		String[] skillArr = skill.split("");
		for(String tree : skill_trees) {
			int[] countArr = new int[skill.length()];
			for(int i = 0; i<skillArr.length; i++) {
				countArr[i] =  tree.indexOf(skillArr[i]);
			}
			for(int i=0; i<countArr.length-1; i++) {
				if(countArr[i] > countArr[i+1]) {
					if(countArr[i+1] == -1) {
						continue;
					}
					result--;
					break;
				}else if(countArr[i] < countArr[i+1]) {
					if(countArr[i] == -1) {
						result--;
						break;
					}
				}
			}
			result++;
		}
		return result;
	}
}
