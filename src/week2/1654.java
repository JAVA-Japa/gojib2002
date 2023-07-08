import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int k, n;
    static int[] arr;

    public static boolean check(long v){
        long cnt = 0;

        for(int i = 0; i < k; i++){
            cnt += arr[i] / v;
        }

        return cnt >= n;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[k];
        for(int i = 0; i < k; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        long s = 1;
        long e = 1L << 50;
        long ans = 1;
        while(s <= e){
            long mid = (s + e) / 2;

            if(check(mid)){
                ans = mid;
                s = mid + 1;
            }
            else{
                e = mid - 1;
            }
        }

        System.out.print(ans);
    }
}
