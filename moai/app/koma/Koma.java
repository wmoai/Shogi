package moai.app.koma;

import java.util.ArrayList;
import java.util.List;

import moai.app.R;
import util.KomaImage;
import util.MovablePoint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public abstract class Koma {

    /** 駒イメージ */
    public static KomaImage fu_img;
    public static KomaImage kyo_img;
    public static KomaImage kei_img;
    public static KomaImage gin_img;
    public static KomaImage kin_img;
    public static KomaImage kaku_img;
    public static KomaImage hisha_img;
    public static KomaImage gyoku_img;
    public static KomaImage to_img;
    public static KomaImage narikyo_img;
    public static KomaImage narikei_img;
    public static KomaImage narigin_img;
    public static KomaImage uma_img;
    public static KomaImage ryu_img;

    public static final int SENTE = 0;
    public static final int GOTE = 1;

    public String id;
    protected static String preId;
    protected static String nariId;

    /**
     * 駒画像をロードします。
     * @param res
     */
    public static void loadResource(Resources res) {
        fu_img = new KomaImage(BitmapFactory.decodeResource(res, R.drawable.sfu),
                               BitmapFactory.decodeResource(res, R.drawable.gfu));
        kyo_img = new KomaImage(BitmapFactory.decodeResource(res, R.drawable.skyo),
                                BitmapFactory.decodeResource(res, R.drawable.gkyo));
        kei_img = new KomaImage(BitmapFactory.decodeResource(res, R.drawable.skei),
                                BitmapFactory.decodeResource(res, R.drawable.gkei));
        gin_img = new KomaImage(BitmapFactory.decodeResource(res, R.drawable.sgin),
                                BitmapFactory.decodeResource(res, R.drawable.ggin));
        kin_img = new KomaImage(BitmapFactory.decodeResource(res, R.drawable.skin),
                                BitmapFactory.decodeResource(res, R.drawable.gkin));
        kaku_img = new KomaImage(BitmapFactory.decodeResource(res, R.drawable.skaku),
                                 BitmapFactory.decodeResource(res, R.drawable.gkaku));
        hisha_img = new KomaImage(BitmapFactory.decodeResource(res, R.drawable.shisha),
                                  BitmapFactory.decodeResource(res, R.drawable.ghisha));
        gyoku_img = new KomaImage(BitmapFactory.decodeResource(res, R.drawable.sou),
                                  BitmapFactory.decodeResource(res, R.drawable.gou));
        to_img = new KomaImage(BitmapFactory.decodeResource(res, R.drawable.sto),
                               BitmapFactory.decodeResource(res, R.drawable.gto));
        narikyo_img = new KomaImage(BitmapFactory.decodeResource(res, R.drawable.snkyo),
                                    BitmapFactory.decodeResource(res, R.drawable.gnkyo));
        narikei_img = new KomaImage(BitmapFactory.decodeResource(res, R.drawable.snkei),
                                    BitmapFactory.decodeResource(res, R.drawable.gnkei));
        narigin_img = new KomaImage(BitmapFactory.decodeResource(res, R.drawable.sngin),
                                    BitmapFactory.decodeResource(res, R.drawable.gngin));
        uma_img = new KomaImage(BitmapFactory.decodeResource(res, R.drawable.suma),
                                BitmapFactory.decodeResource(res, R.drawable.guma));
        ryu_img = new KomaImage(BitmapFactory.decodeResource(res, R.drawable.sryu),
                                BitmapFactory.decodeResource(res, R.drawable.gryu));
    }

    /** 自駒イメージ */
    protected KomaImage img;

    /**
     * 移動可能座標
     * 先手向時
     * 上：-Y
     * 右：+X
     */
    protected List<MovablePoint> movablePoint;

    /** 成り前駒イメージ */
    protected KomaImage preImg;
    /**
     * 成り前移動可能座標
     * 先手向時
     * 上：-Y
     * 右：+X
     */
    protected List<MovablePoint> preMovablePoint;

    /** 成りイメージ */
    protected KomaImage nariImg;
    /**
     * 成り移動可能座標
     * 先手向時
     * 上：-Y
     * 右：+X
     */
    protected List<MovablePoint> nariMovablePoint;


    /** 成り可不可 */
    public boolean canNari;
    /** 成り戻り可不可 */
    public boolean mustReturnPre = false;

    /** 先手後手 */
    public int te;
    /** 出駒or持ち駒 */
    public boolean field = true;

    /** 自由移動座標X */
    public int x;
    /** 自由移動座標Y */
    public int y;


    /** イメージを取得します。 */
    public Bitmap getImage() {
        return img.getImage(te);
    }

    /**
     * 移動可能位置リストを返します。
     */
    public List<MovablePoint> getMovablePoints() {
        if (te == Koma.SENTE) {
            return movablePoint;
        }
        List<MovablePoint> result = new ArrayList<MovablePoint>();
        for (MovablePoint point : movablePoint) {
            result.add(point.getRollPoint());
        }
        return result;
    }

    /**
     * 所持者を切り替えます。
     */
    public void change() {
        if (te == Koma.SENTE) {
            te = Koma.GOTE;
        } else {
            te = Koma.SENTE;
        }
    }

    /**
     * 成ります。
     */
    public void nari() {
        if (!canNari) {
            return;
        }
        //ID変更
        id = nariId;
        //イメージ変更
        img = nariImg;
        //移動力変更
        movablePoint = nariMovablePoint;
        //成り可フラグ変更
        canNari = false;
        mustReturnPre = true;
    }

    /**
     * 成り前の駒に戻します。
     */
    public void returnPre() {
        if (!mustReturnPre) {
            return;
        }
        //ID変更
        id = preId;
        //イメージ変更
        img = preImg;
        //移動力変更
        movablePoint = preMovablePoint;
        //成り可フラグ変更
        canNari = true;
        mustReturnPre = false;
    }


}
