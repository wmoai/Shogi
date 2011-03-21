package moai.app;

import util.KomaUtil;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

public class ShogiView extends View {

    public Shogi application;

    /** 将棋ロジック */
    private ShogiLogic shogiLogic;

    public ShogiView(Context context) {
        super(context);

        shogiLogic = new ShogiLogic();
    }

    /**
     * タッチイベント
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        shogiLogic.motigoma.getTouchedMasu(event);

        //光マス処理
        shogiLogic.lightMasu(event);

        //盤上駒持ち上げ
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            shogiLogic.pickKoma(event);
        }

        //持ち上げている駒管理
        if (shogiLogic.pickedKoma != null) {
            shogiLogic.movePickedKoma(event, application);
        }

        invalidate();

        return true;
    }

    /**
     * 描画処理
     */
    public void onDraw(Canvas canvas) {

        Paint paint = new Paint();
        paint.setColor(Color.rgb(51, 51, 51));
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(new Rect(0,0,getWidth(),getHeight()), paint);

        shogiLogic.shogiBan.drawBan(canvas);
        shogiLogic.shogiBan.drawLight(canvas, shogiLogic.lightMasu);
        shogiLogic.shogiBan.drawKoma(canvas, shogiLogic);
        shogiLogic.motigoma.drawBan(canvas);
        shogiLogic.motigoma.drawMotigoma(canvas, shogiLogic);

        //駒を持っている場合
        if (shogiLogic.pickedKoma != null) {
            //元画像サイズ
            Rect src = new Rect(0,
                    0,
                    shogiLogic.pickedKoma.getImage().getWidth(),
                    shogiLogic.pickedKoma.getImage().getHeight());
            //拡大画像サイズ
            Rect dst = KomaUtil.scaleKoma(shogiLogic.pickedKoma, 1.25);
            //持っている駒を拡大表示
            canvas.drawBitmap(shogiLogic.pickedKoma.getImage(), src, dst, null);
        }
    }

    public void draw() {
        invalidate();
    }
}
