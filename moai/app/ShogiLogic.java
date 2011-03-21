package moai.app;

import moai.app.koma.Koma;
import util.MovablePoint;
import android.graphics.Point;
import android.view.MotionEvent;

/**
 * 将棋ロジック
 * @author tk
 *
 */
public class ShogiLogic {

//    /** 盤上配置
//     *  左上から右に+X
//     *  下に+Y
//     **/
//    private Masu[][] masus = new Masu[9][9];

//    /**
//     * 手持ち配置
//     * 後手（１）
//     * ４５６７
//     * ０１２３
//     *
//     * 先手（０）
//     * 　　３２１０
//     * 　　７６５４
//     */
//    private Masu[][] temoti = new Masu[2][8];

    /** 将棋盤 */
    public ShogiBan shogiBan;
    /** 持ち駒 */
    public Motigoma motigoma = new Motigoma();


    /** 手番 */
    public int te;

    /** 持っている駒 */
    public Koma pickedKoma;
    /** 駒を持ち上げた場所のマス */
    private Masu pickedMasu;
    /** 光るマスの盤上座標 */
    public Point lightMasu;

    /**
     * コンストラクタ
     */
    public ShogiLogic() {
        init();
    }

    /**
     * 初期化
     */
    public void init() {
        // 手番初期化
        te = Koma.SENTE;
        // 持ち上げ駒初期化
        pickedKoma = null;
        // 将棋盤初期化
        shogiBan = new ShogiBan();

    }

    /**
     * 手番を入れ替えます。
     */
    public void changeTurn() {
        if (te == Koma.SENTE) {
            te = Koma.GOTE;
        } else {
            te = Koma.SENTE;
        }
    }

    /**
     * 駒を持ち上げる処理
     * @param e
     */
    public void pickKoma(MotionEvent event) {

        //タッチマス取得
        Masu masu = shogiBan.getTouchedMasu(event);
        if (masu != null && masu.getKoma() != null) {
            if (masu.getKoma().te == te) {
                //手番と一致する駒があれば持ち上げる
                pickedKoma = masu.pickKoma();
                pickedMasu = masu;
                return;
            }
        }

        //持ち駒アクション
        Masu motiMasu = motigoma.getTouchedMasu(event);
        if (motiMasu != null && motiMasu.getKoma() != null) {
            if (motiMasu.getKoma().te == te) {
                //手番と一致する駒があれば持ち上げる
                pickedKoma = motiMasu.pickKoma();
                pickedMasu = motiMasu;
            }
        }
    }

    /**
     * 持っている駒の管理
     * @param event
     * @param app
     */
    public void movePickedKoma(MotionEvent event, Shogi app) {
        //マス取得
        Masu masu = shogiBan.getTouchedMasu(event);

        //アップアクションの場合、駒を離す
        if (event.getAction() == MotionEvent.ACTION_UP) {
            if (masu == null) {
                shogiBan.moveKoma(pickedKoma, pickedMasu, motigoma);
            } else if (!pickedKoma.field) {
                //持ち駒の場合、設置（判定）
                putKoma(masu);
            } else if (canMove(masu.point)) {
                //出駒の場合で、設置可能な場合
                nari(masu.point, app);
                shogiBan.moveKoma(pickedKoma, masu, motigoma);
                changeTurn();
            } else {
                //元の位置に戻す
                shogiBan.moveKoma(pickedKoma, pickedMasu, motigoma);
            }
            pickedKoma = null;
            pickedMasu = null;
        } else {
            int x = (int)event.getX();
            int y = (int)event.getY();

            //アップアクション以外の場合、持ち上げ駒の座標更新
            pickedKoma.x = x - pickedKoma.getImage().getWidth() / 2;
            pickedKoma.y = y - pickedKoma.getImage().getHeight() / 2;
        }
    }

    /**
     * 光マスの座標をセットします。
     * @param event
     */
    public void lightMasu(MotionEvent event) {
        //アップアクションの場合、光マスをクリア
        if (event.getAction() == MotionEvent.ACTION_UP) {
            lightMasu = null;
            return;
        }

        //マス取得
        Masu masu = shogiBan.getTouchedMasu(event);
        if (masu != null) {
            lightMasu = masu.point;
        }
    }

    /**
     * 手中駒の設置
     * @param masu
     */
    private void putKoma(Masu masu) {
        if (canPut(masu.point)) {
            //持ち駒を置ける場合
            pickedKoma.field = true;
            shogiBan.moveKoma(pickedKoma, masu, motigoma);
            changeTurn();
        } else {
            //持ち駒を置けない場合
            motigoma.addKoma(pickedKoma);
        }
    }

    /**
     * 指定箇所にまだ駒がないことを判定します。
     * @param putPoint
     * @return
     */
    private boolean canPut(Point putPoint) {
        Masu masu = shogiBan.getMasu(putPoint.x, putPoint.y);
        if (masu.getKoma() != null) {
            return false;
        }
        return true;
    }

    /**
     * 駒を離した座標が移動範囲内かどうか判定します。
     * @param putPoint
     * @return
     */
    private boolean canMove(Point putPoint) {

        for (MovablePoint movablePoint : pickedKoma.getMovablePoints()) {
            if (canMove(putPoint, movablePoint)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 移動範囲内であるか判定します。
     * @param putPoint
     * @param movablePoint
     * @return
     */
    private boolean canMove(Point putPoint, MovablePoint movablePoint) {
        if (movablePoint.line) {
            //直線移動型の場合
            int pickedX = pickedMasu.point.x;
            int pickedY = pickedMasu.point.y;
            while(true) {
                pickedX += movablePoint.x;
                pickedY += movablePoint.y;

                //盤外ならNG
                if (!isCorrectPlace(new Point(pickedX, pickedY))) {
                    break;
                }

                Masu masu = shogiBan.getMasu(pickedX, pickedY);

                if (masu.getKoma() != null) {
                    //駒がある場合
                    if (putPoint.x == pickedX
                     && putPoint.y == pickedY
                     && masu.getKoma().te != pickedKoma.te) {
                        //敵駒でその地点が目的地の場合OK
                        return true;
                    } else {
                        //目的地で無い場合NG
                        return false;
                    }
                } else if(putPoint.x == pickedX
                       && putPoint.y == pickedY){
                    //駒が無く、目的地の場合OK
                    return true;
                }

            }
        } else {
            //単移動型の場合
            if (putPoint.x == pickedMasu.point.x + movablePoint.x
                && putPoint.y == pickedMasu.point.y + movablePoint.y) {
                Masu masu = shogiBan.getMasu(putPoint.x, putPoint.y);

                if (masu.getKoma() == null) {
                    //駒が無ければOK
                    return true;
                }
                if (masu.getKoma().te != pickedKoma.te) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 盤上であることを確認します。
     * @param point
     * @return
     */
    private boolean isCorrectPlace(Point point) {
        if (point.x < 0 || point.x > 8
         || point.y < 0 || point.y > 8) {
            return false;
        }
        return true;
    }

    /**
     * 成りの処理
     * @param putPoint
     */
    public void nari(final Point putPoint, Shogi application) {

        //成れない駒の場合
        if (!pickedKoma.canNari) {
            return;
        }

        if (pickedKoma.te == Koma.SENTE) {
            //先手成り判定
            if (putPoint.y > 2 && pickedMasu.point.y > 2) {
                //※成らない判定
                return;
            }
        } else {
            //後手成り判定
            if (putPoint.y < 6 && pickedMasu.point.y < 6) {
                //※成らない判定
                return;
            }
        }

        //成り確認と成り処理
        application.nariConfirm(pickedKoma);
    }

}
