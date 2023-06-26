import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> que = new LinkedList<>();
        int q = sc.nextInt();
        String a;
        StringBuilder sb = new StringBuilder();
        int last = -1;

        while(q-->0){
            a = sc.next();

            if(a.equals("push")){
                last = sc.nextInt();

                que.add(last);
            }
            else if(a.equals("pop")){
                if(que.isEmpty()) sb.append("-1\n");
                else sb.append(que.poll() + "\n");
            }
            else if(a.equals("size")){
                sb.append(que.size() + "\n");
            }
            else if(a.equals("empty")){
                if(que.isEmpty()) sb.append("1\n");
                else sb.append("0\n");
            }
            else if(a.equals("front")){
                if(que.isEmpty()) sb.append("-1\n");
                else sb.append(que.peek() + "\n");
            }
            else{
                if(que.isEmpty()) sb.append("-1\n");
                else sb.append(last + "\n");
            }
        }

        System.out.print(sb);
    }
}
