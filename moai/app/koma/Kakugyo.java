package moai.app.koma;

import java.util.ArrayList;

import util.MovablePoint;

/**
 * 角行
 * @author tk
 *
 */
public class Kakugyo extends Koma {


    public Kakugyo(int te) {
        preId = "kaku";
        nariId = "uma";
        id = preId;

        //イメージセット
        img = kaku_img;
        //移動方向セット
        movablePoint = new ArrayList<MovablePoint>();
        movablePoint.add(new MovablePoint(1,  1, true));
        movablePoint.add(new MovablePoint(-1,  1, true));
        movablePoint.add(new MovablePoint(1,  -1, true));
        movablePoint.add(new MovablePoint(-1,  -1, true));

        //成り前イメージセット
        preImg = kaku_img;
        //成り前移動方向セット
        preMovablePoint = new ArrayList<MovablePoint>();
        preMovablePoint.add(new MovablePoint(1,  1, true));
        preMovablePoint.add(new MovablePoint(-1,  1, true));
        preMovablePoint.add(new MovablePoint(1,  -1, true));
        preMovablePoint.add(new MovablePoint(-1,  -1, true));

        //成りイメージセット
        nariImg = uma_img;
        //成り移動方向セット
        nariMovablePoint = new ArrayList<MovablePoint>();
        nariMovablePoint.add(new MovablePoint(0,  -1));
        nariMovablePoint.add(new MovablePoint(-1,  0));
        nariMovablePoint.add(new MovablePoint(1 ,  0));
        nariMovablePoint.add(new MovablePoint(0 ,  1));
        nariMovablePoint.add(new MovablePoint(1,  1, true));
        nariMovablePoint.add(new MovablePoint(-1,  1, true));
        nariMovablePoint.add(new MovablePoint(1,  -1, true));
        nariMovablePoint.add(new MovablePoint(-1,  -1, true));

        this.te = te;
        canNari = true;
    }

}
