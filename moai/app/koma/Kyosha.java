package moai.app.koma;

import java.util.ArrayList;

import util.MovablePoint;

/**
 * 香車
 * @author tk
 *
 */
public class Kyosha extends Koma {

    public Kyosha(int te) {
        preId = "kyo";
        nariId = "narikyo";
        id = preId;

        //イメージセット
        img = kyo_img;
        //移動方向セット
        movablePoint = new ArrayList<MovablePoint>();
        movablePoint.add(new MovablePoint(0,  -1, true));

        //成り前イメージセット
        preImg = kyo_img;
        //成り前移動方向セット
        preMovablePoint = new ArrayList<MovablePoint>();
        preMovablePoint.add(new MovablePoint(0,  -1, true));

        //成りイメージセット
        nariImg = narikyo_img;
        //成り移動方向セット
        nariMovablePoint = new ArrayList<MovablePoint>();
        nariMovablePoint.add(new MovablePoint(-1,  -1));
        nariMovablePoint.add(new MovablePoint(0 ,  -1));
        nariMovablePoint.add(new MovablePoint(1 ,  -1));
        nariMovablePoint.add(new MovablePoint(-1,  0));
        nariMovablePoint.add(new MovablePoint(1 ,  0));
        nariMovablePoint.add(new MovablePoint(0 ,  1));


        this.te = te;
        canNari = true;
    }

}
