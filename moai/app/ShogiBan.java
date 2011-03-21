package moai.app;

import moai.app.koma.Fuhyo;
import moai.app.koma.Ginsho;
import moai.app.koma.Gyokusho;
import moai.app.koma.Hisha;
import moai.app.koma.Kakugyo;
import moai.app.koma.Keima;
import moai.app.koma.Kinsho;
import moai.app.koma.Koma;
import moai.app.koma.Kyosha;
import util.KomaUtil;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.MotionEvent;

public class ShogiBan {

    /** 盤上配置
     *  左上から右に+X
     *  下に+Y
     **/
    private Masu[][] masus = new Masu[9][9];

    //リソース
    /** 将棋盤線画像 */
    public static Bitmap ban;
    /** 将棋盤材質画像 */
    public static Bitmap banBak;
    /** 光マス画像 */
    public static Bitmap lighting;


    /** 将棋盤余白 */
    public static int banDif;

    /** 将棋盤LEFT位置 */
    public static final int LEFT = 15;
    /** 将棋盤TOP位置 */
    public static final int TOP = 130;

    /** マスの大きさ */
    public static final int MASU = 50;

    /**
     * コンストラクタ
     */
    public ShogiBan() {
        // 盤上座標初期化
        initMasu();
    }

    /**
     * マスを初期化
     */
    private void initMasu() {
        // 盤上座標初期化
        masus = new Masu[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Masu masu = new Masu(i, j);
                masu.x = LEFT + (i * MASU);
                masu.y = TOP + (j * MASU);
                masus[i][j] = masu;

            }
        }

        //初期配置
        setKoma(new Gyokusho(Koma.SENTE), 4, 8);
        setKoma(new Kinsho(Koma.SENTE), 3, 8);
        setKoma(new Kinsho(Koma.SENTE), 5, 8);
        setKoma(new Ginsho(Koma.SENTE), 2, 8);
        setKoma(new Ginsho(Koma.SENTE), 6, 8);
        setKoma(new Keima(Koma.SENTE), 1, 8);
        setKoma(new Keima(Koma.SENTE), 7, 8);
        setKoma(new Kyosha(Koma.SENTE), 0, 8);
        setKoma(new Kyosha(Koma.SENTE), 8, 8);
        setKoma(new Hisha(Koma.SENTE), 7, 7);
        setKoma(new Kakugyo(Koma.SENTE), 1, 7);
        setKoma(new Fuhyo(Koma.SENTE), 0, 6);
        setKoma(new Fuhyo(Koma.SENTE), 1, 6);
        setKoma(new Fuhyo(Koma.SENTE), 2, 6);
        setKoma(new Fuhyo(Koma.SENTE), 3, 6);
        setKoma(new Fuhyo(Koma.SENTE), 4, 6);
        setKoma(new Fuhyo(Koma.SENTE), 5, 6);
        setKoma(new Fuhyo(Koma.SENTE), 6, 6);
        setKoma(new Fuhyo(Koma.SENTE), 7, 6);
        setKoma(new Fuhyo(Koma.SENTE), 8, 6);

        setKoma(new Gyokusho(Koma.GOTE), 4, 0);
        setKoma(new Kinsho(Koma.GOTE), 3, 0);
        setKoma(new Kinsho(Koma.GOTE), 5, 0);
        setKoma(new Ginsho(Koma.GOTE), 2, 0);
        setKoma(new Ginsho(Koma.GOTE), 6, 0);
        setKoma(new Keima(Koma.GOTE), 1, 0);
        setKoma(new Keima(Koma.GOTE), 7, 0);
        setKoma(new Kyosha(Koma.GOTE), 0, 0);
        setKoma(new Kyosha(Koma.GOTE), 8, 0);
        setKoma(new Hisha(Koma.GOTE), 1, 1);
        setKoma(new Kakugyo(Koma.GOTE), 7, 1);
        setKoma(new Fuhyo(Koma.GOTE), 0, 2);
        setKoma(new Fuhyo(Koma.GOTE), 1, 2);
        setKoma(new Fuhyo(Koma.GOTE), 2, 2);
        setKoma(new Fuhyo(Koma.GOTE), 3, 2);
        setKoma(new Fuhyo(Koma.GOTE), 4, 2);
        setKoma(new Fuhyo(Koma.GOTE), 5, 2);
        setKoma(new Fuhyo(Koma.GOTE), 6, 2);
        setKoma(new Fuhyo(Koma.GOTE), 7, 2);
        setKoma(new Fuhyo(Koma.GOTE), 8, 2);

    }

    /**
     * リソースロード
     * @param res
     */
    public static void loadResource(Resources res) {
        //盤イメージロード
        ban = BitmapFactory.decodeResource(res, R.drawable.shogiban);
        //盤背景イメージロード
        banBak = BitmapFactory.decodeResource(res, R.drawable.shogiban_bak);
        //光マスイメージロード
        lighting = BitmapFactory.decodeResource(res, R.drawable.masu);

        banDif = (banBak.getWidth() - ban.getWidth()) / 2;
    }

    /**
     * 将棋盤を描画します。
     * @param canvas
     */
    public void drawBan(Canvas canvas) {
        canvas.drawBitmap(banBak, LEFT - banDif, TOP - banDif, null);
        canvas.drawBitmap(ban, LEFT, TOP, null);
    }

    /**
     * 光るマスを描画します。
     * @param canvas
     */
    public void drawLight(Canvas canvas, Point masu) {
        if (masu == null) {
            return;
        }
        canvas.drawBitmap(lighting,
                          LEFT + (masu.x * MASU),
                          TOP + (masu.y * MASU),
                          null);
    }

    /**
     * キャンバスに駒を描画します。
     * @param canvas
     * @param shogiLogic
     */
    public void drawKoma(Canvas canvas ,ShogiLogic shogiLogic) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Koma koma = getMasu(i, j).getKoma();
                if (koma == null) {
                    continue;
                }

                canvas.drawBitmap(koma.getImage(),
                        LEFT + (i * MASU) + KomaUtil.centeringX(koma),
                        TOP + (j * MASU) + KomaUtil.centeringY(koma),
                        null);
            }
        }
    }

    /**
     * 指定の座標が将棋盤上であるか判定します。
     * @return
     */
    public boolean isInside(int x, int y) {
        if (x >= LEFT && x < (LEFT + ban.getWidth())
         && y >= TOP && y < (TOP + ban.getHeight())) {
            return true;
        }
        return false;
    }

    /**
     * タッチした駒を取得します。
     * @param event
     * @return
     */
    public Masu getTouchedMasu(MotionEvent event) {
        int x = (int)event.getX();
        int y = (int)event.getY();

        for (Masu[] line : masus) {
            for (Masu masu : line) {
                if (masu.isTouched(x, y)) {
                    return masu;
                }
            }
        }
        return null;
    }

    /**
     * 駒を指定の場所に置きます。
     * @param koma
     * @param x 1-9
     * @param y 一-九
     */
    public void setKoma(Koma koma, int x, int y) {
        masus[x][y].setKoma(koma);
    }

    /**
     * 指定の駒を指定のマスへ移動します。
     * @param koma
     * @param masu
     * @param moti
     */
    public void moveKoma(Koma koma, Masu masu, Motigoma moti) {
        Koma preKoma = masu.getKoma();

        //駒を取ります
        if (preKoma != null) {
            moti.killKoma(preKoma);
        }
        masu.setKoma(koma);
    }

    /**
     * 指定の場所のマスの駒を取得します。
     * @param x
     * @param y
     * @return
     */
    public Masu getMasu(int x, int y) {
        return masus[x][y];
    }

    /**
     * 駒を持ち上げます。
     * @param x
     * @param y
     * @return
     */
    public Koma pickKoma(int x, int y) {
        Koma koma = masus[x][y].getKoma();
        masus[x][y].setKoma(null);

        return koma;
    }

//    /**
//     * 駒を取ります。
//     * @param koma
//     */
//    public void killKoma(Koma koma) {
//        koma.change();
//        koma.returnPre();
////        motigoma.addKoma(koma);
//
//    }
}
