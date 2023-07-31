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
        int cnt = 0;
        while(e < n){
            if(sum == m) cnt++;

            if(sum < m){
                e++;
                sum += arr[e];
            }
            else{
                sum -= arr[s];
                s++;
            }
        }

        System.out.print(cnt);
    }
}
