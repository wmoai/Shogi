package moai.app;


public class MotigomaDai {
//
//    /**
//     * 手持ち配置
//     * 後手（１）
//     * ４５６７
//     * ０１２３
//     *
//     * 先手（０）
//     * 　　３２１０
//     * 　　７６５４
//     */
//    private Masu[][] temoti = new Masu[2][8];
//
//
//    public static Bitmap motiDai;
//
//    public static final int RETURN_COUNT = 4;
//
//    /**
//     * 将棋盤を描画します。
//     * @param canvas
//     */
//    public void drawBan(Canvas canvas) {
//        canvas.drawBitmap(motiDai,
//                ShogiBan.LEFT - ShogiBan.banDif,
//                ShogiBan.TOP - motiDai.getHeight() - ShogiBan.banDif,
//                null);
//        canvas.drawBitmap(motiDai,
//                ShogiBan.LEFT + (ShogiBan.MASU * 5) + ShogiBan.banDif,
//                ShogiBan.TOP + ShogiBan.ban.getHeight() + ShogiBan.banDif,
//                null);
//    }
//
//    /**
//     * キャンバスに持ち駒を描画します。
//     * @param canvas
//     * @param shogiLogic
//     */
//    public void drawMotigoma(Canvas canvas, ShogiLogic shogiLogic) {
//        int senteCnt = 0;
//        int goteCnt = 0;
//
//        Map<String, List<Koma>> senteMap = shogiLogic.motigoma.getMotigomaMap(Koma.SENTE);
//        Map<String, List<Koma>> goteMap = shogiLogic.motigoma.getMotigomaMap(Koma.GOTE);
//
//        Iterator<String> senteIte = senteMap.keySet().iterator();
//        Iterator<String> goteIte = goteMap.keySet().iterator();
//
//        Paint paint = new Paint();
//        paint.setAntiAlias(true);
//        paint.setTextSize(20);
//        paint.setTypeface(Typeface.DEFAULT_BOLD);
//        paint.setColor(Color.BLUE);
//
//        // 先手番描画
//        while(senteIte.hasNext()) {
//            String key = senteIte.next();
//            List<Koma> list = senteMap.get(key);
//            if (list == null || list.size() == 0) {
//                continue;
//            }
//
//            Koma koma = list.get(0);
//            senteCnt++;
//
//            Bitmap image = koma.getImage();
//            canvas.drawBitmap(image,
//                    ShogiBan.LEFT + ShogiBan.ban.getWidth() + ShogiBan.banDif - (ShogiBan.MASU * (senteCnt - (senteCnt / 5 * RETURN_COUNT))) + KomaUtil.centeringX(koma),
//                    ShogiBan.TOP + ShogiBan.ban.getHeight() + ShogiBan.banDif + KomaUtil.centeringY(koma) + (senteCnt / 5 * ShogiBan.MASU),
//                    null);
//
//            //駒数描画
//            if (list.size() > 1) {
//                canvas.drawText(list.size() + "",
//                        ShogiBan.LEFT + ShogiBan.ban.getWidth() + ShogiBan.banDif - (ShogiBan.MASU * (senteCnt - (senteCnt / 5 * RETURN_COUNT))),
//                        ShogiBan.TOP + ShogiBan.ban.getHeight() + ShogiBan.banDif +  (senteCnt / 5 * ShogiBan.MASU) + ShogiBan.MASU,
//                    paint);
//            }
//        }
//
//        // 後手番描画
//        while(goteIte.hasNext()) {
//            String key = goteIte.next();
//            List<Koma> list = goteMap.get(key);
//            if (list == null || list.size() == 0) {
//                continue;
//            }
//
//            Koma koma = list.get(0);
//            goteCnt++;
//
//            Bitmap image = koma.getImage();
//            canvas.drawBitmap(image,
//                    ShogiBan.LEFT - ShogiBan.banDif + (ShogiBan.MASU * (goteCnt - (goteCnt / 5 * 4) - 1)) + KomaUtil.centeringY(koma),
//                    ShogiBan.TOP - ShogiBan.banDif + KomaUtil.centeringY(koma) - (goteCnt / 5 * ShogiBan.MASU) - ShogiBan.MASU,
//                    null);
//
//            //駒数描画
//            if (list.size() > 1) {
//                canvas.drawText(list.size() + "",
//                        ShogiBan.LEFT - ShogiBan.banDif + (ShogiBan.MASU * (goteCnt - (goteCnt / 5 * 4) - 1)),
//                        ShogiBan.TOP - ShogiBan.banDif - (goteCnt / 5 * ShogiBan.MASU),
//                    paint);
//            }
//        }
//
//    }
//
//    /**
//     * 指定の座標が持ち駒台上であるか判定します。
//     * @return
//     */
//    public boolean isInside(int x, int y) {
//        int senteMinX = ShogiBan.LEFT - ShogiBan.banDif;
//        int senteMaxX = senteMinX + (ShogiBan.MASU * RETURN_COUNT) - ShogiBan.banDif;
//        int senteMinY = ShogiBan.TOP - (ShogiBan.MASU * 2);
//        int senteMaxY = ShogiBan.TOP;
//
//        int goteMinX = ShogiBan.LEFT + (ShogiBan.MASU * 5);
//        int goteMaxX = goteMinX + (ShogiBan.MASU * RETURN_COUNT);
//        int goteMinY = ShogiBan.TOP + ShogiBan.ban.getHeight() + ShogiBan.banDif;
//        int goteMaxY = goteMinY + (ShogiBan.MASU * 2);
//
//        if (x >= senteMinX && x < senteMaxX
//         && y >= senteMinY && y < senteMaxY) {
//            return true;
//        }
//        if (x >= goteMinX && x < goteMaxX
//         && y >= goteMinY && y < goteMaxY) {
//                   return true;
//               }
//        return false;
//    }
}
