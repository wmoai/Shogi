package moai.app;

import java.util.ArrayList;
import java.util.List;

import moai.app.koma.Koma;
import util.KomaUtil;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

public class Masu {
    private List<Koma> koma;

    public int x;
    public int y;

    /** 盤上座標 */
    public Point point;

    public Masu() {
        this.koma = new ArrayList<Koma>();
        point = new Point();
    }

    public Masu(int x, int y) {
        this.koma = new ArrayList<Koma>();
        this.point = new Point(x, y);
    }


    /**
     * マスの駒を見ます。
     * @return
     */
    public Koma showKoma() {
        Koma result = null;
        if (this.koma.size() > 0) {
            result = this.koma.get(this.koma.size() - 1);
        }
        return result;
    }

    public int getKomaCount() {
        return this.koma.size();
    }

    /**
     * マスに駒を加えます。
     * @param koma
     */
    public void setKoma(Koma koma) {
        this.koma.add(koma);
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
     * 駒を描画します
     * @param canvas
     */
    public void drawKoma(Canvas canvas) {
        if (koma.size() == 0) {
            return;
        }
        Koma drawKoma = this.koma.get(this.koma.size() - 1);

        canvas.drawBitmap(drawKoma.getImage(),
                x + KomaUtil.centeringX(drawKoma),
                y + KomaUtil.centeringY(drawKoma),
                null);
        //駒数描画
        if (this.koma.size() > 1) {
            canvas.drawText(this.koma.size() + "",
                    x + KomaUtil.centeringX(drawKoma),
                    y + KomaUtil.centeringY(drawKoma) + (ShogiBan.MASU / 4),
                    new Paint());
        }
    }

    /**
     * 駒を持ち上げます。（取得＆削除）
     * @return
     */
    public Koma pickKoma() {
        Koma pickKoma = null;
        if (this.koma.size() > 0) {
            pickKoma = this.koma.get(this.koma.size() - 1);
            this.koma.remove(this.koma.size() - 1);
        }
        return pickKoma;
    }
}
