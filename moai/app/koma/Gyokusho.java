package moai.app.koma;

import java.util.ArrayList;

import util.MovablePoint;

/**
 * 玉将
 * @author tk
 *
 */
public class Gyokusho extends Koma {

    public Gyokusho(int te) {
        preId = "gyoku";
        nariId = "";
        id = preId;

        //イメージセット
        img = gyoku_img;
        //移動方向セット
        movablePoint = new ArrayList<MovablePoint>();
        movablePoint.add(new MovablePoint(-1,  -1));
        movablePoint.add(new MovablePoint(0 ,  -1));
        movablePoint.add(new MovablePoint(1 ,  -1));
        movablePoint.add(new MovablePoint(-1,  0));
        movablePoint.add(new MovablePoint(1,  0));
        movablePoint.add(new MovablePoint(-1,  1));
        movablePoint.add(new MovablePoint(0,  1));
        movablePoint.add(new MovablePoint(1 ,  1));

        this.te = te;
        canNari = false;
    }

}