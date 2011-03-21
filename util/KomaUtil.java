package util;

import moai.app.ShogiBan;
import moai.app.koma.Koma;
import android.graphics.Rect;

public class KomaUtil {


    /**
     * 駒をセンタリングする差分Xを取得します。
     * @param koma
     * @return
     */
    public static float centeringX(Koma koma) {
        return (ShogiBan.MASU - koma.getImage().getWidth()) / 2;
    }

    /**
     * 駒をセンタリングする差分Yを取得します。
     * @param koma
     * @return
     */
    public static float centeringY(Koma koma) {
        return (ShogiBan.MASU - koma.getImage().getHeight()) / 2;
    }

    public static Rect scaleKoma(Koma koma, double scale) {
        double deltaX = koma.getImage().getWidth() / 2 * (scale - 1);
        double deltaY = koma.getImage().getHeight() / 2 * (scale - 1);

        return new Rect((int)(koma.x - deltaX),
                        (int)(koma.y - deltaY),
                        (int)(koma.x + koma.getImage().getWidth() + deltaX),
                        (int)(koma.y + koma.getImage().getHeight() + deltaY));
    }

}
