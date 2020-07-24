package assignment07;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author   Sjaak Smetsers
 * @coauthor Thomas van Harskamp, s1007576
 * @coauthor Jordy Aaldering,     s1004292
 */
public class QTree {
    private Tree tree;
    private String bitmap, string;
    
    public QTree (StringReader input) {
        string2QTree (input);
    }
    
    public QTree (Bitmap bm) {
        bitmap2QTree (0, 0,  bm.getWidth(), bm);
    }

    public QTree (Tree t) {
        this.tree = t;
        this.bitmap = qTree2Bitmap().toString();
        this.string = qTree2String(tree, "");
    }
    
    public Tree getQTree () {
        return tree;
    }
    
    public String getBitmap () {
        return bitmap;
    }
    
    public String getString () {
        return string;
    }
    
    public void fillBitmap (Bitmap bm) {
        fillBitmap (0, 0, bm.getWidth(), bm);
    }
        
    public void fillBitmap (int x, int y, int width, Bitmap bm) {
        bm.fillArea (x, y, width, true);
    }

    private String qTree2String (Tree t, String s) {
        if (t.empty() || t.getChild(1) == null) {
            s += "0" + t.getValue();
        } else {
            s += "1";
            String s1 = "", s2 = "", s3 = "", s4 = "";
            s1 += qTree2String (t.getChild(0), s);
            s2 += qTree2String (t.getChild(1), s);
            s3 += qTree2String (t.getChild(2), s);
            s4 += qTree2String (t.getChild(3), s);
            s += s1 + s2 + s3 + s4;
        }
        return s;
    }
    
    private void string2QTree (StringReader in) {
        
        Tree newTree = new Tree (1);
        try {
            this.tree = makeQTree (in, newTree);
        } catch (IOException ex) {
            Logger.getLogger(QTree.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Tree makeQTree (StringReader in, Tree t) throws IOException {
        try (BufferedReader reader = new BufferedReader(new StringReader(in.toString()))) {
            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                else if (in.read() == 0) {
                    Tree child = new Tree (in.read());
                    return child;
                } else if (in.read() == 1) {
                    Tree child1 = new Tree (in.read());
                    t.addChild (makeQTree (in, child1));
                    Tree child2 = new Tree (in.read());
                    t.addChild (makeQTree (in, child2));
                    Tree child3 = new Tree (in.read());
                    t.addChild (makeQTree (in, child3));
                    Tree child4 = new Tree (in.read());
                    t.addChild (makeQTree (in, child4));
                } else break;
            }
        } catch (IOException ex) {
            Logger.getLogger(QTree.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }
    
    private Bitmap qTree2Bitmap () {
        Bitmap bm = new Bitmap (8, 8);
        fillBitmap (bm);
        makeBitmap (bm, 0, 0, bm.getWidth(), tree);
        return bm;
    }
    
    private void makeBitmap (Bitmap bm, int x, int y, int size, Tree t) {
        if (t.empty() || size == 1) {
            boolean val = t.getValue() == 1;
            bm.fillArea(x, y, size, val);
        } else {
            int hSize = size / 2;
            makeBitmap (bm, x, y, hSize, t);
            makeBitmap (bm, x + hSize, y, hSize, t);
            makeBitmap (bm, x + hSize, y + hSize, hSize, t);
            makeBitmap (bm, x, y + hSize, hSize, t);
        }
    }
    
    private void bitmap2QTree (int x, int y, int width, Bitmap bm) {
        tree = new Tree (1);
        checkBitmap (bm, x, y, width);
    }

    private void checkBitmap (Bitmap bm, int x, int y, int size) {
        if (checkBlock (bm, x, y, size)) {
            Tree child = new Tree (bm.getBit(x, y));
            tree.addChild (child);
        } else {
            Tree child = new Tree (1);
            tree.addChild (child);
            int hSize = size / 2;
            checkBitmap (bm, x, y, hSize);
            checkBitmap (bm, x + hSize, y, hSize);
            checkBitmap (bm, x + hSize, y + hSize, hSize);
            checkBitmap (bm, x, y + hSize, hSize);
        }
    }
    
    private boolean checkBlock (Bitmap bm, int x, int y, int size) {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (bm.getBit(i+x, j+y) != bm.getBit(x, y)) 
                    return false;
        return true;
    }
}
