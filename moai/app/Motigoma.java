package moai.app;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import moai.app.koma.Koma;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;

public class Motigoma {

    private Map<Integer, Masu[][]> masus = new HashMap<Integer, Masu[][]>();

    public static Bitmap dai;

    public static final int RETURN_COUNT = 4;

    /**
     * コンストラクタ
     */
    public Motigoma() {
        masus.put(Koma.SENTE, new Masu[4][2]);
        masus.put(Koma.GOTE, new Masu[4][2]);

        initMasu();
    }

    /**
     * マス初期化
     */
    private void initMasu() {

        //先手
        //Xループ
        for (int i = 0; i < 4; i++) {
            //Yループ
            for (int j = 0; j < 2; j++) {
                Masu masu = new Masu();
                masu.x = ShogiBan.LEFT + ((i + 5) * ShogiBan.MASU) + ShogiBan.banDif;
                masu.y = ShogiBan.TOP + (j * ShogiBan.MASU) + ShogiBan.ban.getHeight() + ShogiBan.banDif;
                masus.get(Koma.SENTE)[i][j] = masu;
            }
        }

        //後手
        //Xループ
        for (int i = 0; i < 4; i++) {
            //Yループ
            for (int j = 0; j < 2; j++) {
                Masu masu = new Masu();
                masu.x = ShogiBan.LEFT + (i * ShogiBan.MASU) - ShogiBan.banDif;
                masu.y = ShogiBan.TOP + ((j - 2) * ShogiBan.MASU) - ShogiBan.banDif;
                masus.get(Koma.GOTE)[i][j] = masu;
            }
        }

    }

    /**
     * リソースロード
     * @param res
     */
    public static void loadResource(Resources res) {
        //持ち駒台イメージロード
        Motigoma.dai = BitmapFactory.decodeResource(res, R.drawable.motigoma);
    }

    /**
     * 持ち駒に駒を加えます。
     * @param koma 加える駒
     */
    public void addKoma(Koma koma) {

        for (Masu[] line : masus.get(koma.te)) {
            for (Masu masu : line) {
                if (masu.getKoma() == null) {
                    masu.setKoma(koma);
                    return;
                }
                if (koma.id == masu.getKoma().id) {
                    masu.plusCount();
                    return;
                }
            }
        }

        return;
    }

    /**
     * 将棋盤を描画します。
     * @param canvas
     */
    public void drawBan(Canvas canvas) {
        canvas.drawBitmap(dai,
                ShogiBan.LEFT - ShogiBan.banDif,
                ShogiBan.TOP - dai.getHeight() - ShogiBan.banDif,
                null);
        canvas.drawBitmap(dai,
                ShogiBan.LEFT + (ShogiBan.MASU * 5) + ShogiBan.banDif,
                ShogiBan.TOP + ShogiBan.ban.getHeight() + ShogiBan.banDif,
                null);
    }

    /**
     * キャンバスに持ち駒を描画します。
     * @param canvas
     * @param shogiLogic
     */
    public void drawMotigoma(Canvas canvas, ShogiLogic shogiLogic) {

        for (Entry<Integer, Masu[][]> box : masus.entrySet()) {
            for (Masu[] line : box.getValue()) {
                for (Masu masu : line) {
                    masu.drawKoma(canvas);
                }
            }
        }


    }


    /**
     * 指定の座標にマスがあれば取得。
     * なければnull
     * @return
     */
    public Masu getTouchedMasu(MotionEvent event) {
        int x = (int)event.getX();
        int y = (int)event.getY();

//        for (Masu[] line : senteban) {
//            for (Masu masu : line) {
//                if (masu.isTouched(x, y)) {
//                    return masu;
//                }
//            }
//        }
//        for (Masu[] line : goteban) {
//            for (Masu masu : line) {
//                if (masu.isTouched(x, y)) {
//                    return masu;
//                }
//            }
//        }

        for (Entry<Integer, Masu[][]> box : masus.entrySet()) {
            for (Masu[] line : box.getValue()) {
                for (Masu masu : line) {
                    if (masu.isTouched(x, y)) {
                        return masu;
                    }
                }
            }
        }

        return null;
    }

    /**
     * 駒を取ります。
     * @param koma
     */
    public void killKoma(Koma koma) {
        koma.change();
        koma.returnPre();
        koma.field = false;
        Log.v("Motigoma","add");
        addKoma(koma);
    }


}
