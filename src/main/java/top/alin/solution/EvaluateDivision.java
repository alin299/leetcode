package top.alin.solution;

import java.util.*;

public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = 0;
        Map<String, Integer> map = new HashMap<>();
        for (List<String> list : equations) {
            for (String s : list) {
                if (!map.containsKey(s)) {
                    map.put(s, n++);
                }
            }
        }

        double[][] graph = new double[n][n];
        for (String s : map.keySet()) {
            int a = map.get(s);
            graph[a][a] = 1.0;
        }
        int index = 0;
        for (List<String> equation : equations) {
            graph[map.get(equation.get(0))][map.get(equation.get(1))] = values[index];
            graph[map.get(equation.get(1))][map.get(equation.get(0))] = 1 / values[index++];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (j == k || graph[j][k] != 0) {
                        continue;
                    }
                    if (graph[j][i] != 0 && graph[i][k] != 0) {
                        graph[j][k] = graph[j][i] * graph[i][k];
                    }
                }
            }
        }

        index = 0;
        double[] ans = new double[queries.size()];
        for (List<String> query : queries) {
            if(map.containsKey(query.get(0)) && map.containsKey(query.get(1))) {
                double v = graph[map.get(query.get(0))][map.get(query.get(1))];
                ans[index++] = v != 0 ? v : -1;
            } else {
                ans[index++] = -1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(new ArrayList<String>(){{
            add("a");
            add("b");
        }});
        equations.add(new ArrayList<String>(){{
            add("b");
            add("c");
        }});
        double[] values = new double[]{2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(new ArrayList<String>(){{
            add("a");
            add("c");
        }});
        queries.add(new ArrayList<String>(){{
            add("b");
            add("a");
        }});
        queries.add(new ArrayList<String>(){{
            add("a");
            add("e");
        }});
        queries.add(new ArrayList<String>(){{
            add("a");
            add("a");
        }});
        queries.add(new ArrayList<String>(){{
            add("x");
            add("x");
        }});

        EvaluateDivision solution = new EvaluateDivision();
        System.out.println(Arrays.toString(solution.calcEquation(equations, values, queries)));
    }
}
