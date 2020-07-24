package Assignment08;

/**
 * @author Thomas van Harskamp, s1007576
 * @author Jordy Aaldering,     s1004292
 */
public class Calculation {
    private String line;
    private String[] terms;
    private int degree = 1;
    
    public Calculation (String s) {
        this.line = s;
        this.rewriteCalc();
        this.findDegree();
    }
    
    private void rewriteCalc () {
        line = line.replace (" ", "");
        line = line.replace ("-", "+-");
        if(line.charAt(0) == '+') 
            line = line.substring(1);
        terms = line.split("\\+");
    }
    
    private void findDegree () {
        if(line.contains("^"))
            for (int i = 0; i < terms.length; i++) {
                int curr = 1;
                if (terms[i].contains("^"))
                    curr = Integer.parseInt (terms[i].substring(terms[i].indexOf("^") + 1));
                if (curr > degree)
                    degree = curr;
            }
    }
    
    public Polynomial makePoly () {
        Polynomial poly = new Polynomial (line);
        return poly;
    }
    
    @Override
    public String toString () {
        StringBuilder sb = new StringBuilder();
        sb.append("Rewritten calculation: ")  .append(line)
          .append("\nDegree of calculation: ").append(degree)
          .append("\n\n");
        return sb.toString();
    }
}
