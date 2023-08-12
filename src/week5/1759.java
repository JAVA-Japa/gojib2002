import java.util.Scanner;
import java.util.Arrays;

public class Main {
    static int n, m;
    static String[] v;
    static String[] arr;

    public static int aeiou(String s){
        if(s.charAt(0) == 'a' || s.charAt(0) == 'e' || s.charAt(0) == 'i' || s.charAt(0) == 'o' || s.charAt(0) == 'u') return 1;
        else return 0;
    }

    public static void recur(int cur, int cnt, int a, int b){
        if(cnt == n){
            if(a >= 1 && b >= 2){
                for(int i = 0; i < n; i++){
                    System.out.print(arr[i]);
                }
                System.out.println();
            }
            return;
        }

        if(cur == m) return;

        arr[cnt] = v[cur];
        recur(cur + 1, cnt + 1, a + aeiou(v[cur]), b + (1 ^ aeiou(v[cur])));
        recur(cur + 1, cnt, a, b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        v = new String[m];
        for(int i = 0; i < m; i++){
            v[i] = sc.next();
        }

        Arrays.sort(v);

        arr = new String[n];
        recur(0, 0, 0, 0);
    }
}
