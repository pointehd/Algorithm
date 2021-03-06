package year2021.programmers;

import java.util.*;

public class ChangeWord {
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(new ChangeWord().solution(begin, target, words));
    }

    int minCount = 51; // max

    public int solution(String begin, String target, String[] words) {
        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        if (wordList.contains(target)) {
            findNextWord(begin, target, 0, wordList, new boolean[wordList.size()]);
        }
        return minCount > 50 ? 0 : minCount;
    }

    /**
     * 다음 진행 가능한 문자열로 변경
     * 조건 1자 이상 다른문자 사용하지않은 문자로
     */
    public void findNextWord(String nowWord, String target, int count, List<String> words, boolean[] checkUse) {
        if (nowWord.equals(target)) {
            minCount = Math.min(minCount, count);
            return;
        }
        for (int i = 0; i < words.size(); i++) {
            if (!checkUse[i] && changeAvailable(nowWord, words.get(i))) {
                checkUse[i] = true;
                findNextWord(words.get(i), target, count + 1, words, checkUse);
                checkUse[i] = false;
            }
        }
    }

    /**
     * 문자열 비교하여 1자 다른지 비교
     * 같을경우 접근 안함
     * 1자 다를경우 : true
     * 2자 이상 다를경우 : false
     */
    public boolean changeAvailable(String str1, String str2) {
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                if (++count > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
