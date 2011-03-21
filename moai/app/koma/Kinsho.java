package moai.app.koma;

import java.util.ArrayList;

import util.MovablePoint;

/**
 * 金将
 * @author tk
 *
 */
public class Kinsho extends Koma {

    public Kinsho(int te) {
        preId = "kin";
        nariId = "";
        id = preId;

        //イメージセット
        img = kin_img;

        //移動方向セット
        movablePoint = new ArrayList<MovablePoint>();
        movablePoint.add(new MovablePoint(-1,  -1));
        movablePoint.add(new MovablePoint(0 ,  -1));
        movablePoint.add(new MovablePoint(1 ,  -1));
        movablePoint.add(new MovablePoint(-1,  0));
        movablePoint.add(new MovablePoint(1 ,  0));
        movablePoint.add(new MovablePoint(0 ,  1));

        this.te = te;
        canNari = false;
    }

}
