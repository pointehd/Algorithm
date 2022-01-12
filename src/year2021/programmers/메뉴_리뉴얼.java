package year2021.programmers;

import java.util.*;
import java.util.stream.Collectors;

public class 메뉴_리뉴얼 {


    /**
     * Programmers. 메뉴 리뉴얼
     * https://programmers.co.kr/learn/courses/30/lessons/72411
     *
     * 테스트 1 〉	통과 (22.35ms, 75.9MB)
     * 테스트 2 〉	통과 (23.62ms, 90.1MB)
     * 테스트 3 〉	통과 (36.47ms, 79.6MB)
     * 테스트 4 〉	통과 (30.29ms, 87.1MB)
     * 테스트 5 〉	통과 (24.71ms, 85.5MB)
     * 테스트 6 〉	통과 (35.71ms, 90.2MB)
     * 테스트 7 〉	통과 (43.76ms, 80.3MB)
     * 테스트 8 〉	통과 (121.71ms, 131MB)
     * 테스트 9 〉	통과 (102.42ms, 129MB)
     * 테스트 10 〉	통과 (80.34ms, 124MB)
     * 테스트 11 〉	통과 (57.32ms, 113MB)
     * 테스트 12 〉	통과 (56.95ms, 109MB)
     * 테스트 13 〉	통과 (112.58ms, 132MB)
     * 테스트 14 〉	통과 (99.42ms, 125MB)
     * 테스트 15 〉	통과 (79.90ms, 120MB)
     * 테스트 16 〉	통과 (87.08ms, 125MB)
     * 테스트 17 〉	통과 (109.62ms, 134MB)
     * 테스트 18 〉	통과 (152.72ms, 139MB)
     * 테스트 19 〉	통과 (130.24ms, 134MB)
     * 테스트 20 〉	통과 (137.84ms, 127MB)
     * */
    public String[] solution(String[] orders, int[] course) {
        CourseCounter couseCounter = new CourseCounter(course);
        for (String order : orders) {
            couseCounter.findCourse("", 0, order, new HashSet<>());
        }
        Arrays.stream(couseCounter.getCourses())
            .forEach(System.out::println);
        return couseCounter.getCourses();
    }


    public static class CourseCounter {
        Map<String, Integer> courseCount = new HashMap<>();
        List<Integer> countList;

        public CourseCounter(int[] course) {
            this.countList = Arrays.stream(course).boxed().collect(Collectors.toList());
        }

        public void findCourse(String now, int courseIndex, String order, Set<String> checkCourse) {
            now = Arrays.stream(now.split("")).sorted().collect(Collectors.joining());
            if (!checkCourse.contains(now)) {
                checkCourse.add(now);
                putCourse(now);
            }
            if (courseIndex < order.length()) {
                findCourse(now + order.charAt(courseIndex), courseIndex + 1, order, checkCourse);
                findCourse(now, courseIndex + 1, order, checkCourse);
            }
        }

        private void putCourse(String course) {
            if (countList.contains(course.length())) {
                courseCount.put(course, courseCount.getOrDefault(course, 0) + 1);
            }
        }

        public void printAll() {
            for (String key : courseCount.keySet()) {
                System.out.println(key + ": " + courseCount.get(key));
            }
        }

        public String[] getCourses() {
            List<String> courseList = new ArrayList<>();
            for (int count : countList) {
                courseList.addAll(getCourseByCount(count));
            }
            Collections.sort(courseList);
            return courseList.toArray(new String[courseList.size()]);
        }

        private List<String> getCourseByCount(int n) {
            List<String> courses = new ArrayList<>();
            int maxSize = 2;
            for (String course : courseCount.keySet()) {
                if (course.length() != n || maxSize > courseCount.get(course)) {
                    continue;
                }
                if (maxSize < courseCount.get(course)) {
                    maxSize = courseCount.get(course);
                    courses.clear();
                }
                courses.add(course);
            }
            return courses;
        }
    }
    public static void main(String[] args) {
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};
        new 메뉴_리뉴얼().solution(orders, course);
    }



    /**
     *
     * 이전 푼코
     * 테스트 1 〉	통과 (19.90ms, 53.9MB)
     * 테스트 2 〉	통과 (21.80ms, 53.1MB)
     * 테스트 3 〉	통과 (20.04ms, 53.2MB)
     * 테스트 4 〉	통과 (21.07ms, 52.7MB)
     * 테스트 5 〉	통과 (20.90ms, 53.1MB)
     * 테스트 6 〉	통과 (23.28ms, 53.4MB)
     * 테스트 7 〉	통과 (31.09ms, 54.6MB)
     * 테스트 8 〉	통과 (66.15ms, 61.5MB)
     * 테스트 9 〉	통과 (51.54ms, 60.5MB)
     * 테스트 10 〉	통과 (47.16ms, 55.5MB)
     * 테스트 11 〉	통과 (39.64ms, 53.8MB)
     * 테스트 12 〉	통과 (38.79ms, 53.6MB)
     * 테스트 13 〉	통과 (40.81ms, 60.5MB)
     * 테스트 14 〉	통과 (53.47ms, 58.3MB)
     * 테스트 15 〉	통과 (59.05ms, 56.6MB)
     * 테스트 16 〉	통과 (38.74ms, 59.1MB)
     * 테스트 17 〉	통과 (40.67ms, 57.5MB)
     * 테스트 18 〉	통과 (51.80ms, 59.9MB)
     * 테스트 19 〉	통과 (32.98ms, 54.9MB)
     * 테스트 20 〉	통과 (46.57ms, 57.4MB)
 */
    static Map<String, Integer> courseCount  = new HashMap<>();
    static int max = 1;
    public String[] solution2(String[] orders, int[] course){
        Map<Integer, Integer> courseMax = new HashMap<>();
        List<String> result = new ArrayList<>();
        for(int count : course){
            for(String order : orders){
                find(0, "", count, 0, order);
            }
            if(max <2){
                continue;
            }
            for(String key :  courseCount.keySet()){
                if(key.length() == count && courseCount.get(key) == max){
                    result.add(key);
                }
            }
            max = 1;
        }

        Collections.sort(result);
        return result.stream().toArray(String[] :: new);
    }

    static void find(int cnt,String str,int targetNum,int idx,String word){
        if (cnt==targetNum){
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String temps="";
            for (int i=0;i<c.length;i++)
                temps+=c[i];
            courseCount.put(temps,courseCount.getOrDefault(temps,0)+1);
            max = Math.max(max,courseCount.get(temps));
            return;
        }
        for (int i=idx;i<word.length();i++){
            char now =word.charAt(i);
            find(cnt+1,str+now,targetNum,i+1,word);
        }
    }
}
