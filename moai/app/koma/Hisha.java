package moai.app.koma;

import java.util.ArrayList;

import util.MovablePoint;

/**
 * 飛車
 * @author tk
 *
 */
public class Hisha extends Koma {

    public Hisha(int te) {
        preId = "hisha";
        nariId = "ryu";
        id = preId;

        //イメージセット
        img = hisha_img;
        //移動方向セット
        movablePoint = new ArrayList<MovablePoint>();
        movablePoint.add(new MovablePoint(0,  1, true));
        movablePoint.add(new MovablePoint(1,  0, true));
        movablePoint.add(new MovablePoint(0,  -1, true));
        movablePoint.add(new MovablePoint(-1,  0, true));

        //成り前イメージセット
        preImg = hisha_img;
        //成り前移動方向セット
        preMovablePoint = new ArrayList<MovablePoint>();
        preMovablePoint.add(new MovablePoint(0,  1, true));
        preMovablePoint.add(new MovablePoint(1,  0, true));
        preMovablePoint.add(new MovablePoint(0,  -1, true));
        preMovablePoint.add(new MovablePoint(-1,  0, true));

        //成りイメージセット
        nariImg = ryu_img;
        //成り移動方向セット
        nariMovablePoint = new ArrayList<MovablePoint>();
        nariMovablePoint.add(new MovablePoint(-1,  -1));
        nariMovablePoint.add(new MovablePoint(1 ,  -1));
        nariMovablePoint.add(new MovablePoint(-1 ,  1));
        nariMovablePoint.add(new MovablePoint(1 ,  1));
        nariMovablePoint.add(new MovablePoint(0,  1, true));
        nariMovablePoint.add(new MovablePoint(1,  0, true));
        nariMovablePoint.add(new MovablePoint(0,  -1, true));
        nariMovablePoint.add(new MovablePoint(-1,  0, true));

        this.te = te;
        canNari = true;
    }

}