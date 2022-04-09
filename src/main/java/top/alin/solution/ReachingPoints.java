package top.alin.solution;

public class ReachingPoints {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while(tx > sx && ty > sy) {
            if (tx > ty) {
                tx %= ty;
            } else {
                ty %= tx;
            }
        }

        if (tx == sx && ty == sy) {
            return true;
        } else if (tx == sx) {
            return ty > sy && (ty - sy) % sx == 0;
        } else if (ty == sy) {
            return tx > sx && (tx - sx) % sy == 0;
        } else {
            return false;
        }
    }
}
