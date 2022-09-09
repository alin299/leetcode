package top.alin.solution;

public class CrawlerLogFolder {
    public int minOperations(String[] logs) {
        int depth = 0;
        for(String log : logs) {
            if ("../".equals(log)) {
                depth = depth > 0 ? depth - 1 : 0;
            } else if (!"./".equals(log)) {
                depth++;
            }
        }
        return depth;
    }
}
