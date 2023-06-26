import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> dq = new ArrayDeque<>();  //LinkedList로 하니 메모리 초과. 가비지 컬렉터가 delete해주기 전에 할당을 너무 많이 하는것 같아서 ArrayDeque으로 변경.
        int n = sc.nextInt();
        int[] arr = new int[n];
        int idx;

        //입력 받으면서 각 풍선을 deque에 저장. dq의 Front에 있는게 현재 풍선.
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();

            dq.addLast(i);
        }

        while(!dq.isEmpty()){
            idx = dq.pollFirst();  //지금 보려는 풍선을 일단 찾아서 출력.

            System.out.print((idx + 1) + " ");

            if(dq.isEmpty()) break;

            //만약 이번 풍선이 +1이면 그냥 그대로 두면 다음 풍선이 알아서 나오고, +3이면 두개를 뒤로 보내줘야 합니다.
            //만약 이번 풍선이 -1이면 맨뒤에 있던걸 맨앞으로 한번 보내줘야 되고, -3이면 세개를 앞으로 보내줘야 합니다.
            //따라서 음수면 abs(arr[idx])만큼, 양수면 arr[idx] - 1만큼 이동시켜야 하니 양수면 한번 -- 해준 뒤 그 수만큼 이동.
            if(arr[idx] > 0) arr[idx]--;
            for(int i = 0; i < Math.abs(arr[idx]); i++){
                if(arr[idx] < 0) dq.addFirst(dq.pollLast());
                else dq.addLast(dq.pollFirst());
            }
        }
    }
}
