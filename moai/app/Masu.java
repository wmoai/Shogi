package moai.app;

import moai.app.koma.Koma;
import util.KomaUtil;
import android.graphics.Canvas;
import android.graphics.Point;

public class Masu {
    private Koma koma;

    /** 持ち駒専用、駒数 */
    private int count;

    public int x;
    public int y;

    /** 盤上座標 */
    public Point point;

    public Masu() {
        koma = null;
        point = new Point();
    }

    public Masu(int x, int y) {
        koma = null;
        point = new Point(x, y);
    }


    /**
     * マスの駒を取得します。
     * @return
     */
    public Koma getKoma() {
        return koma;
    }

    /**
     * マスに駒をおきます。
     * @param koma
     */
    public void setKoma(Koma koma) {
        this.koma = koma;
    }

    /**
     * 駒数を取得します。
     * @return
     */
    public int getCount() {
        return count;
    }

    /**
     * 駒数をセットします。
     * @param count
     */
    public void setCount(int count) {
        this.count = count;
    }


    /**
     * マス辺り判定
     * @param x
     * @param y
     * @return
     */
    public boolean isTouched(int x, int y) {
        if (this.x <= x && (this.x + ShogiBan.MASU) > x
         && this.y <= y && (this.y + ShogiBan.MASU) > y) {
            return true;
        }
        return false;
    }

    /**
     * 持ち駒数カウントアップ
     */
    public void plusCount() {
        count++;
    }
    /**
     * 持ち駒数カウントダウン
     */
    public void minusCount() {
        count--;
    }

    /**
     * 駒を描画します
     * @param canvas
     */
    public void drawKoma(Canvas canvas) {
        if (koma == null) {
            return;
        }

        canvas.drawBitmap(koma.getImage(),
                x + KomaUtil.centeringX(koma),
                y + KomaUtil.centeringY(koma),
                null);
    }

    /**
     * 駒を持ち上げます。
     * @return
     */
    public Koma pickKoma() {
        Koma pickedKoma = this.koma;
        //TODO
        if (count == 1 || count == 0) {
            this.koma = null;
        } else {
            count--;
        }

        return pickedKoma;
    }
}
