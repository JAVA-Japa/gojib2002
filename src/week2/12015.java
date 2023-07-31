import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    static int n;
    static int[] arr;
    static ArrayList<Integer> v = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++){
            int s = 0;
            int e = v.size() - 1;
            int idx = -1;

            while(s <= e){
                int mid = (s + e) / 2;

                if(v.get(mid) >= arr[i]){
                    idx = mid;
                    e = mid - 1;
                }
                else{
                    s = mid + 1;
                }
            }

            if(idx == -1) v.add(arr[i]);
            else v.set(idx, arr[i]);
        }

        System.out.print(v.size());
    }
}
