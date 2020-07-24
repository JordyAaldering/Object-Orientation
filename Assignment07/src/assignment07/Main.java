package assignment07;

/**
 * @author Thomas van Harskamp, s1007576
 * @author Jordy Aaldering,     s1004292
 */
public class Main {
    public static void main (String[] args) {
        Bitmap bitmap = new Bitmap (8, 8);
        QTree bm2QTree = new QTree (bitmap);

        QTree qTree = new QTree (bm2QTree.getQTree());
        System.out.println (qTree.getBitmap());
        System.out.println (qTree.getString());
    }
}