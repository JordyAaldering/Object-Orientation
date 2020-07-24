package Assignment;
import Visitor.*;
import Forms.*;

/**
 * @author Thomas van Harskamp, s1007576
 * @author Jordy Aaldering,     s1004292
 */
public class TestCases {
    public static void run () {
        PrintFormVisitor print = new PrintFormVisitor();
        EvalFormVisitor eval   = new EvalFormVisitor();
        
        T1string(print);
        T1boolean(print, eval);
        
        T2string(print);
        T2boolean(print, eval);
        
        T3string(print);
        T3boolean(print, eval);
    }
    
    /**
     * T1 = ~B1 /\ B2 \/ B3 -> B4
     *    = (((~B1) /\ B2) \/ B3) -> B4
     *                ->
     *            \/    B4
     *        /\    B3
     *      ~   B2
     *      B1
     */
    private static void T1string (PrintFormVisitor print) {
        Form B1 = new StringForm("B1");
        Form B2 = new StringForm("B2");
        Form B3 = new StringForm("B3");
        Form B4 = new StringForm("B4");

        Form nB1 = new NotForm(B1);
        Form nB1andB2 = new AndForm(nB1, B2);
        Form nB1andB2orB3 = new OrForm(nB1andB2, B3);
        Form nB1andB2orB3impB4 = new ImpliesForm(nB1andB2orB3, B4);
        
        print.visit(nB1andB2orB3impB4);
        System.out.println();
    }
    
    /**
     * T1 = ~T /\ F \/ F -> T
     *    = (((~T) /\ F) \/ F) -> T
     *    = T
     *                ->
     *            \/    T
     *        /\    F
     *      ~   F
     *      T
     */
    private static void T1boolean (PrintFormVisitor print, EvalFormVisitor eval) {
        Form B1 = new BooleanForm(true);
        Form B2 = new BooleanForm(false);
        Form B3 = new BooleanForm(false);
        Form B4 = new BooleanForm(true);

        Form nB1 = new NotForm(B1);
        Form nB1andB2 = new AndForm(nB1, B2);
        Form nB1andB2orB3 = new OrForm(nB1andB2, B3);
        Form nB1andB2orB3impB4 = new ImpliesForm(nB1andB2orB3, B4);
        
        print.visit(nB1andB2orB3impB4);
        eval.visit(nB1andB2orB3impB4);
    }
    
    /**
     * T2 = B1 \/ B2 -> B3 /\ ~B4
     *    = (B1 \/ B2) -> (B3 /\ (~B4))
     *            ->
     *        \/      /\
     *      B1  B2  B3  ~
     *                  B4
     */
    private static void T2string (PrintFormVisitor print) {
        Form B1 = new StringForm("B1");
        Form B2 = new StringForm("B2");
        Form B3 = new StringForm("B3");
        Form B4 = new StringForm("B4");

        Form B1orB2 = new OrForm(B1, B2);
        Form notB4  = new NotForm(B4);
        Form B3orNotB4 = new OrForm(B3, notB4);
        Form B1orB2impB3orNotB4 = new ImpliesForm(B1orB2, B3orNotB4);
        
        print.visit(B1orB2impB3orNotB4);
        System.out.println();
    }
    
    /**
     * T2 = T \/ F -> T /\ ~F
     *    = (T \/ F) -> (T /\ (~F))
     *    = T
     *            ->
     *        \/      /\
     *      T   F   T   ~
     *                  F
     */
    private static void T2boolean (PrintFormVisitor print, EvalFormVisitor eval) {
        Form B1 = new BooleanForm(true);
        Form B2 = new BooleanForm(false);
        Form B3 = new BooleanForm(true);
        Form B4 = new BooleanForm(false);

        Form B1orB2 = new OrForm(B1, B2);
        Form notB4  = new NotForm(B4);
        Form B3orNotB4 = new OrForm(B3, notB4);
        Form B1orB2impB3orNotB4 = new ImpliesForm(B1orB2, B3orNotB4);
        
        print.visit(B1orB2impB3orNotB4);
        eval.visit(B1orB2impB3orNotB4);
    }
    
    /**
     * T3 = B1 /\ B2 /\ B3 -> B4 \/ ~B5
     *    = ((B1 /\ B2) /\ B3) -> (B4 \/ ~B5)
     *               ->
     *           /\      \/
     *         /\  B3  B4  ~
     *       B1  B2        B5
     */
    private static void T3string (PrintFormVisitor print) {
        Form B1 = new StringForm("B1");
        Form B2 = new StringForm("B2");
        Form B3 = new StringForm("B3");
        Form B4 = new StringForm("B4");
        Form B5 = new StringForm("B5");

        Form B1andB2 = new AndForm(B1, B2);
        Form B1andB2andB3 = new AndForm(B1andB2, B3);
        Form notB5 = new NotForm(B5);
        Form B4orNotB5 = new OrForm(B4, notB5);
        Form B1andB2andB3impliesB4orNotB5 = new ImpliesForm(B1andB2andB3, B4orNotB5);
        
        print.visit(B1andB2andB3impliesB4orNotB5);
        System.out.println();
    }
    
    /**
     * T3 = T /\ T /\ T -> F \/ ~T
     *    = ((T /\ T) /\ T) -> (F \/ ~T)
     *    = F
     *               ->
     *           /\      \/
     *         /\  T   F   ~
     *       T   T         T
     */
    private static void T3boolean (PrintFormVisitor print, EvalFormVisitor eval) {
        Form B1 = new BooleanForm(true);
        Form B2 = new BooleanForm(true);
        Form B3 = new BooleanForm(true);
        Form B4 = new BooleanForm(false);
        Form B5 = new BooleanForm(true);

        Form B1andB2 = new AndForm(B1, B2);
        Form B1andB2andB3 = new AndForm(B1andB2, B3);
        Form notB5 = new NotForm(B5);
        Form B4orNotB5 = new OrForm(B4, notB5);
        Form B1andB2andB3impliesB4orNotB5 = new ImpliesForm(B1andB2andB3, B4orNotB5);
        
        print.visit(B1andB2andB3impliesB4orNotB5);
        eval.visit(B1andB2andB3impliesB4orNotB5);
    }
}
