import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] arr;

    public static boolean check(int v){
        int sum = 0;

        for(int i = 0; i < n; i++){
            sum += Math.min(arr[i], v);
        }

        return sum <= m;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int s = 0;
        int e = 0;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());

            e = Math.max(e, arr[i]);
        }
        m = Integer.parseInt(br.readLine());

        int ans = 0;
        while(s <= e){
            int mid = (s + e) / 2;

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
