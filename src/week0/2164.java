import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> que = new LinkedList<>();
        int n = sc.nextInt();

        //1번부터 n번까지 모든 카드를 큐에 저장.
        for(int i = 1; i <= n; i++){
            que.add(i);
        }

        //맨 위의 카드를 버린다 => 큐에서 하나를 지운다.
        //맨 위의 카드를 맨 아래로 내린다 => 큐의 맨앞에 있는걸 맨뒤로 보낸다.
        while(que.size() > 1){
            que.poll();
            que.add(que.poll());
        }

        System.out.print(que.peek());
    }
}
