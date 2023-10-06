import java.util.*;
import java.io.*;

public class Main {
    static class Path {
        Map<String, Path> map = new TreeMap<>();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Path root = new Path();

        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split("\\\\");
            Path p = root;
            for (String input : inputs) {
                if (!p.map.containsKey(input)) {
                    Path child = new Path();
                    p.map.put(input, child);
                    p = child;
                } else {
                    p = p.map.get(input);
                }
            }
        }

        for (String key : root.map.keySet()) {
            System.out.println(key);
            searchNext(root.map.get(key), " ");
        }
    }

    private static void searchNext(Path child, String depth) {
        for (String key : child.map.keySet()) {
            System.out.println(depth + key);
            searchNext(child.map.get(key), depth + " ");
        }
    }
    
}
