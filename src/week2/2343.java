import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] arr;

    public static boolean check(int v){
        int sum = 0;
        int cnt = 1;

        for(int i = 0; i < n; i++){
            if(arr[i] > v) return false;

            if(sum + arr[i] > v){
                cnt++;
                sum = arr[i];
            }
            else{
                sum += arr[i];
            }
        }

        return cnt <= m;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 1;
        int e = 1000000000;
        int ans = 0;
        while(s <= e){
            int mid = (s + e) / 2;

            if(check(mid)){
                ans = mid;
                e = mid - 1;
            }
            else{
                s = mid + 1;
            }
        }

        System.out.print(ans);
    }
}
