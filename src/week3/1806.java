import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n + 1];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int s = 0;
        int e = 0;
        int sum = arr[0];
        int ans = n + 1;
        while(e < n){
            if(sum >= m){
                ans = Math.min(ans, e - s + 1);

                sum -= arr[s];
                s++;
            }
            else{
                e++;
                sum += arr[e];
            }
        }

        if(ans == n + 1) ans = 0;

        System.out.print(ans);
    }
}
