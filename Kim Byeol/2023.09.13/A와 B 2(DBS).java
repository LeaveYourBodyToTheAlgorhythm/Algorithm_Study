import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        System.out.println(makeS(T,S));
    }

    static int makeS(String target, String start) {
        if(target.length() == start.length()) {
            if(target.equals(start)){
                return 1;
            }
            return 0;
        }

        int result = 0;

        if(target.charAt(0)=='B') {
            StringBuffer sb = new StringBuffer(target.substring(1));
            result += makeS(sb.reverse().toString(),start);
        }

        if(result != 1 && target.charAt(target.length()-1)=='A') {
            result +=makeS(target.substring(0,target.length()-1),start);
        }

        return result > 0? 1:0;
    }

}
