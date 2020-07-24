//Thomas van Harskamp // s1007576
//Jordy Aaldering     // s1004292

package assignment04;

import java.util.Scanner;

public class Assignment04 {

    Scanner scan = new Scanner (System.in);
    public static void main (String[] args) {
        Assignment04 assignment = new Assignment04();
        assignment.start();
    }
    
    private void start () {
        Board board  = new Board();
        Human human1 = createHuman ('1');
        Human human2 = null;
        Computer computer = null;
        
        boolean humanEnemy = chooseOpponent();
        if (humanEnemy)
            human2 = createHuman(human1.getType());
        else
            computer = createComputer(human1);
        
        boolean done = false;
        while (!done && !board.isBoardFull()) {
            done = playerInput (board, human1);
            
            if (humanEnemy)
                done = playerInput (board, human2);
            else
                done = computerInput (board, computer);
        }
        scan.close();
    }
    
    private Human createHuman (char t) {
        System.out.println ("Enter your name:");
        String name = scan.nextLine();
        char type;
        
        switch (t) {
            case '1':
                System.out.println ("Enter your type: (X or O)");
                type = scan.next().charAt(0);
                while (type != 'X' && type != 'O') {
                    System.out.println ("That is not allowed, enter something else:");
                    type = scan.next().charAt(0);
                }   scan.nextLine();
                break;
            case 'X': type = 'O'; break;
            default:  type = 'X'; break;
        }
        System.out.println ("name: " + name + ", type: " + type + ".");
        return new Human (name, type);
    }
    
    private Computer createComputer (Human human) {
        if (human.getType() == 'X')
            return new Computer ('O');
        else
            return new Computer ('X');
    }
    
    private boolean chooseOpponent () {
        System.out.println ("Play against human or computer: (H or C)");
        char type = scan.next().charAt(0);
        while (type != 'H' && type != 'C') {
            System.out.println ("That is not allowed, enter something else:");
            type = scan.next().charAt(0);
        }
        scan.nextLine();
        return type == 'H';
    }
    
    private boolean playerInput (Board board, Human human) {
        int row, column;
        do {
            System.out.println (human.getName() + ", enter a row and column:");
            row = scan.nextInt();
            column = scan.nextInt();
            scan.nextLine();
        } while (!board.isValid(row, column));
        human.play(row, column, board);
        System.out.println (board.toString());
        return board.winning(row, column);
    }
    
    private boolean computerInput (Board board, Computer computer) {
        System.out.println ("Calculating best move:");
        computer.bestMove (board);
        System.out.println (board.toString());
        return board.winning(computer.getLastRow(), computer.getLastColumn());
    }
}
