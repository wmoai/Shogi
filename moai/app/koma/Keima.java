package moai.app.koma;

import java.util.ArrayList;

import util.MovablePoint;

/**
 * 桂馬
 * @author tk
 *
 */
public class Keima extends Koma {

    public Keima(int te) {
        preId = "kei";
        nariId = "narikei";
        id = preId;

        //イメージセット
        img = kei_img;
        //移動方向セット
        movablePoint = new ArrayList<MovablePoint>();
        movablePoint.add(new MovablePoint(-1,  -2));
        movablePoint.add(new MovablePoint(1 ,  -2));

        //イメージセット
        preImg = kei_img;
        //移動方向セット
        preMovablePoint = new ArrayList<MovablePoint>();
        preMovablePoint.add(new MovablePoint(-1,  -2));
        preMovablePoint.add(new MovablePoint(1 ,  -2));

        //成りイメージセット
        nariImg = narikei_img;
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
