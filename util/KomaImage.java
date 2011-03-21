package util;

import moai.app.koma.Koma;
import android.graphics.Bitmap;

/**
 * 駒のイメージ
 * @author tk
 *
 */
public class KomaImage {

    private Bitmap sente_img ;
    private Bitmap gote_img ;

    /** コンストラクタ */
    public KomaImage(Bitmap sente, Bitmap gote) {
        sente_img = sente;
        gote_img = gote;
    }

    /**
     * 手番にあった画像を取得します。
     * @param te
     * @return
     */
    public Bitmap getImage(int te) {
        if (te == Koma.SENTE) {
            return sente_img;
        } else {
            return gote_img;
        }
    }
}
