//Thomas van Harskamp // s1007576
//Jordy Aaldering     // s1004292

package assignment03;
import java.util.Comparator;

public class yComparator implements Comparator<GeoObject> {
    @Override
    public int compare(GeoObject a, GeoObject b) {   
        return Double.compare(a.getBottomBorder(), b.getBottomBorder());
    } 
}
