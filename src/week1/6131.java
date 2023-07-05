import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;

        for(int a = 1; a <= 1000; a++){
            for(int b = 1; b <= a; b++){
                if(a * a - b * b == n){
                    cnt++;
                }
            }
        }

        System.out.print(cnt);
    }
}
