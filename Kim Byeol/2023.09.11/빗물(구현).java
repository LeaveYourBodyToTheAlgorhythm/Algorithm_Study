import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int H = Integer.parseInt(inputs[0]);
        int W = Integer.parseInt(inputs[1]);

        int[] arr = new int[W];

        String[] heights = br.readLine().split(" ");
        for(int i=0;i<W;i++) {
            arr[i] = Integer.parseInt(heights[i]);
        }

        int left = 0;
        int right = 1;
        int rains = 0;
        int block = 0;

        while(left <= right && right<W) {
          if(arr[left] > arr[right]) {
              block+=arr[right];
              right++;
              continue;
          }
          int height = Math.min(arr[left],arr[right]);
          rains+=(right-left-1)*height-block;
          block=0;
          left=right;
          right=left+1;
        }

        // 반대편에서 고인 경우      
        left = W-2;
        right = W-1;
        block = 0;

        while(left <= right && left>=0) {
            if(arr[left] <= arr[right]) {
                block+=arr[left];
                left--;
                continue;
            }
            int height = Math.min(arr[left],arr[right]);
            rains+=(right-left-1)*height-block;
            block=0;
            right=left;
            left=right-1;
        }

        System.out.println(rains);
    }

}
