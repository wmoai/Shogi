package moai.app.koma;

import java.util.ArrayList;

import util.MovablePoint;

/**
 * 歩兵
 * @author tk
 *
 */
public class Fuhyo extends Koma {

    public Fuhyo(int te) {
        preId = "fu";
        nariId = "to";
        id = preId;

        //イメージセット
        img = fu_img;
        //移動方向セット
        movablePoint = new ArrayList<MovablePoint>();
        movablePoint.add(new MovablePoint(0 ,  -1));

        //成り前イメージセット
        preImg = fu_img;
        //成り前移動方向セット
        preMovablePoint = new ArrayList<MovablePoint>();
        preMovablePoint.add(new MovablePoint(0 ,  -1));

        //成りイメージセット
        nariImg = to_img;
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