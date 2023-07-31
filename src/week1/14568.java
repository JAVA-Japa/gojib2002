import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                for(int k = 1; k <= n; k++){
                    if(i + j + k != n) continue;
                    if(k < j + 2) continue;
                    if(i % 2 == 1) continue;

                    cnt++;
                }
            }
        }

        System.out.print(cnt);
    }
}
