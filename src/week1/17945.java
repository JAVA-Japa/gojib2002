import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b;

        a = sc.nextInt();
        b = sc.nextInt();

        for(int x = -1000; x <= 1000; x++){
            if(x * x + 2 * a * x + b == 0){
                System.out.print(x + " ");
            }
        }
    }
}
