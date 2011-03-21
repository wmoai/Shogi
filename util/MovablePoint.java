package util;

import android.graphics.Point;

public class MovablePoint extends Point {
    /** 直線移動 */
    public boolean line;

    public MovablePoint(int x, int y) {
        super(x, y);
        this.line = false;
    }

    public MovablePoint(int x, int y, boolean line) {
        super(x, y);
        this.line = line;
    }

    /**
     * 反転したものを返します。
     * @return
     */
    public MovablePoint getRollPoint() {
        return new MovablePoint(-x, -y, line);
    }
}
