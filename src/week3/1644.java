import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] isPrime = new boolean[n + 1];
        ArrayList<Integer> v = new ArrayList<>();

        for(int i = 2; i <= n; i++) isPrime[i] = true;

        for(int i = 2; i * i <= n; i++){
            if(!isPrime[i]) continue;

            for(int j = i * i; j <= n; j += i){
                isPrime[j] = false;
            }
        }

        for(int i = 2; i <= n; i++){
            if(isPrime[i]) v.add(i);
        }

        v.add(-1);

        int s = 0;
        int e = 0;
        int sum = v.get(0);
        int cnt = 0;
        while(v.get(e) != -1){
            if(sum == n) cnt++;

            if(sum > n){
                sum -= v.get(s);
                s++;
            }
            else{
                e++;
                sum += v.get(e);
            }
        }

        System.out.print(cnt);
    }
}
