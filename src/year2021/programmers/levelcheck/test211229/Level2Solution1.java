package year2021.programmers.levelcheck.test211229;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Programmers Level2
 * 오픈 채팅방 ㅠㅠ 지난 주에 푼내용 ㅠ
 *
 * */
public class Level2Solution1 {
    public String[] solution(String[] record) {
        Map<String, String> actMap = new HashMap<>();
        actMap.put("Enter", "님이 들어왔습니다.");
        actMap.put("Leave", "님이 나갔습니다.");
        actMap.put("Change", "님이 들어왔습니다.");

        Map<String, String> uidToNameMap  = new HashMap<>();
        List<List<String>> results = new ArrayList<>();
        for (String line : record) {
            String[] text = line.split(" ");
            if(text.length > 2){
                uidToNameMap.put(text[1], text[2]);
            }
            if("Change".equals(text[0])){
                continue;
            }
            List<String>  reco =  new ArrayList<>();
            reco.add(text[1]);
            reco.add(actMap.get(text[0]));
            results.add(reco);
        }
        return results.stream()
                .map(result -> uidToNameMap.get(result.get(0)) + result.get(1))
                .toArray(String[]::new);
    }


}
