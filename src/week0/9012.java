/*
괄호 종류가 하나라면 스택을 사용할 필요 없는 문제.
결국 vps의 조건은 '어느 순간에도 여는 괄호보다 닫는 괄호가 많으면 안된다' + '여는 괄호의 수와 닫는 괄호의 수가 같아야 한다'를 만족하면 되는거고, 이건 스택 없이 카운트만 해줘도 가능.
괄호 종류가 둘 이상이면 "([)]" 같은 입력을 걸러내기 위해 스택 필요.
*/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        String s;
        int cnt;
        String ans;

        n = sc.nextInt();
        while(n-->0){
            s = sc.next();

            cnt = 0;
            ans = "YES"; //일단 YES라고 가정.
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '(') cnt++;    //여는 괄호 수 - 닫는 괄호 수를 cnt에 저장.
                else cnt--;

                if(cnt < 0) ans = "NO";  //여는 괄호보다 닫는 괄호가 많아지는 시점이 있으면 매칭이 안되므로 답은 NO.
            }

            if(cnt != 0) ans = "NO";  //여는 괄호의 수와 닫는 괄호의 수가 다르면 답은 NO.

            System.out.println(ans);
        }
    }
}
