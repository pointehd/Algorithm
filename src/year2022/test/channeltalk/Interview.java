package year2022.test.channeltalk;

/*
* (30 mins)

Stack 클래스를 하나 작성해주세요.
Stack에 1개 넣기, 여러개 넣기, 하나 빼기, 정해진 갯수만큼 빼기, 모두 빼기, 현재 사이즈 함수를 지원해야 합니다.
Stack은 생성시 Stack의 최대 용량을 입력받습니다.

- 지금 작성되는 코드는 라이브러리화 되어 배포된다고 가정하고, 코드를 작성해주세요.
- 질문 사항이 있으면 면접관에게 질문 해주세요.
*
*
*
* -> 질문
* 어떤 형식이 들어가야하나요? String 으로해주세용
* 라이브러리로 배포한다는게 어떤 의미인지 궁금하오
*
*
* => 면접관질문
* maxSize에 final 준이유 -> 변경되면 안되는 값이기 때문에 ..? 왜줬을까 ㅋ.ㅋ
* 필드를 private로 선언한이유 -> 해당 객체를 외부에서 조작할 수 있으면 제가만든 클래스의 일관성이 깨집니다.
* null값을 넣었을경우 어떻게되요? -> 미쳐 생각하지 못한것같습니다.
* stackSizeError private 메서드를 만들었는데 pop 에서는 사용하지 않은 이유
*
*
* 아쉬운점(내생각)
* throw new IllegalArgumentException(); 메시지를 넣어줬으면 좋았을것을..
*
5시51분
*/
public class Interview {
    public static class Stack {
        private String[] stack;
        private int size;
        private final int maxSize;

        public Stack(int maxSize) {
            this.stack = new String[maxSize];
            this.size = 0;
            this.maxSize = maxSize;
        }

        public void put(String str) {
            stackSizeError(1);
            stack[size++] = str;
        }

        public void putAll(String... strs) {
            stackSizeError(strs.length);
            for (String str : strs) {
                stack[size++] = str;
            }
        }

        private void stackSizeError(int count) {
            if (size + count >= this.maxSize) {
                throw new IllegalArgumentException();
            }
        }

        public int size() {
            return this.size;
        }

        public String pop() {
            stackSizeError(-1);
            return stack[--size];
        }

        public String[] popCount(int count) {
            if (count < 1) {
                throw new IllegalArgumentException();
            }
            stackSizeError(-count);
            String[] result = new String[count];
            for (int i = 0; i < count; i++) {
                result[i] = this.stack[--size];
            }
            return result;
        }

        public String[] popAll() {
            String[] result = new String[size];
            int totalSize = size;
            for (int i = 0; i < totalSize; i++) {
                result[i] = stack[--size];
            }
            return result;
        }


    }

    public static void main(String[] args) {
        Stack stack = new Stack(4);
        stack.put("test1");
        stack.putAll("test2", "test3", "test4");
        System.out.println(stack.size());
        String[] result = stack.popAll();
        for (String s : result) {
            System.out.println(s);
        }

        System.out.println(stack.size());
    }

}
