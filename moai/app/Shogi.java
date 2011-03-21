package moai.app;

import moai.app.koma.Koma;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;

public class Shogi extends Activity {

    private ShogiView shogiView;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //リソースロード
        loadResource();

//        shogiView = new ShogiView(getApplication());
        shogiView = new ShogiView(getApplication());

        shogiView.application = this;

        setContentView(shogiView);
    }

    /**
     * リソースロード
     */
    private void loadResource() {
        //リソースロード
        Resources res = getResources();
        //将棋盤のリソース
        ShogiBan.loadResource(res);
        //持ち駒台のリソース
        Motigoma.loadResource(res);
        //駒イメージロード
        Koma.loadResource(res);
    }

    /**
     * 成り確認ダイアログ
     * @param koma 成り対象駒
     */
    public void nariConfirm(final Koma koma) {
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setMessage("成りますか？");

        adb.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                //成る
                koma.nari();
                shogiView.draw();
            }
        });
        adb.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                //成らない
            }
        });

        adb.show();
    }



}