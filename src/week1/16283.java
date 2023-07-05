import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, n, w;
        int ans = -1;

        a = sc.nextInt();
        b = sc.nextInt();
        n = sc.nextInt();
        w = sc.nextInt();

        for(int i = 1; i < n; i++){
            if(a * i + b * (n - i) == w){
                //ans가 -1이 아니다 => 가능한 답이 이미 나온적 있다 => 답이 둘 이상이다 => -1 출력 후 종료.
                if(ans != -1){
                    System.out.print(-1);
                    return;
                }

                ans = i;
            }
        }

        if(ans == -1) System.out.print(-1);
        else System.out.print(ans + " " + (n - ans));
    }
}
