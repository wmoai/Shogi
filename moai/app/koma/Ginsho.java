package moai.app.koma;

import java.util.ArrayList;

import util.MovablePoint;

/**
 * 銀将
 * @author tk
 *
 */
public class Ginsho extends Koma {

    public Ginsho(int te) {
        preId = "gin";
        nariId = "narigin";
        id = preId;

        //イメージセット
        img = gin_img;
        //移動方向セット
        movablePoint = new ArrayList<MovablePoint>();
        movablePoint.add(new MovablePoint(-1,  -1));
        movablePoint.add(new MovablePoint(0 ,  -1));
        movablePoint.add(new MovablePoint(1 ,  -1));
        movablePoint.add(new MovablePoint(-1,  1));
        movablePoint.add(new MovablePoint(1 ,  1));

        //成り前イメージセット
        preImg = gin_img;
        //成り前移動方向セット
        preMovablePoint = new ArrayList<MovablePoint>();
        preMovablePoint.add(new MovablePoint(-1,  -1));
        preMovablePoint.add(new MovablePoint(0 ,  -1));
        preMovablePoint.add(new MovablePoint(1 ,  -1));
        preMovablePoint.add(new MovablePoint(-1,  1));
        preMovablePoint.add(new MovablePoint(1 ,  1));

        //成りイメージセット
        nariImg = narigin_img;
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
