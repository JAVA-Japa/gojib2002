import java.util.Scanner;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> dq = new LinkedList<>();
        int q = sc.nextInt();
        String a;
        StringBuilder sb = new StringBuilder();

        while(q-->0){
            a = sc.next();

            if(a.equals("push_front")){
                dq.addFirst(sc.nextInt());
            }
            else if(a.equals("push_back")){
                dq.addLast(sc.nextInt());
            }
            else if(a.equals("pop_front")){
                if(dq.isEmpty()) sb.append("-1\n");
                else sb.append(dq.pollFirst() + "\n");
            }
            else if(a.equals("pop_back")){
                if(dq.isEmpty()) sb.append("-1\n");
                else sb.append(dq.pollLast() + "\n");
            }
            else if(a.equals("size")){
                sb.append(dq.size() + "\n");
            }
            else if(a.equals("empty")){
                if(dq.isEmpty()) sb.append("1\n");
                else sb.append("0\n");
            }
            else if(a.equals("front")){
                if(dq.isEmpty()) sb.append("-1\n");
                else sb.append(dq.peekFirst() + "\n");
            }
            else{
                if(dq.isEmpty()) sb.append("-1\n");
                else sb.append(dq.peekLast() + "\n");
            }
        }

        System.out.print(sb);
    }
}
