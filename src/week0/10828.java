import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack<>();
        int q = sc.nextInt();
        String a;
        StringBuilder sb = new StringBuilder(); //sout이 느려서 매번 출력시 시간초과 => StringBuilder에 이어붙인 뒤 한번만 출력

        while(q-->0){
            a = sc.next();

            if(a.equals("push")){
                st.push(sc.nextInt());
            }
            else if(a.equals("pop")){
                if(st.isEmpty()) sb.append(-1 + "\n");
                else sb.append(st.pop() + "\n");
            }
            else if(a.equals("size")){
                sb.append(st.size() + "\n");
            }
            else if(a.equals("empty")){
                if(st.isEmpty()) sb.append(1 + "\n");
                else sb.append(0 + "\n");
            }
            else{
                if(st.isEmpty()) sb.append(-1 + "\n");
                else sb.append(st.peek() + "\n");
            }
        }

        System.out.print(sb);
    }
}
