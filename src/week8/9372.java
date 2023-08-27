import java.util.Scanner;

public class Main {
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-->0){
            n = sc.nextInt();
            m = sc.nextInt();
            for(int i = 0; i < m; i++){
                sc.nextInt();
                sc.nextInt();
            }

            System.out.println(n - 1);
        }
    }
}
