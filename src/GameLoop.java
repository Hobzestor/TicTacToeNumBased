import java.util.*;
public class GameLoop {
    public static void main(String[] args) {
        boolean opGame = true;
        boolean p1 = true;
        int turn = 2;
        String help1 = "";
        Scanner scan = new Scanner(System.in);
        String[][] pF = GameCode.playField();
        while(opGame){
            //choosing which players turn it is
            p1 = turn % 2 == 0;
            GameCode.showpF(pF);
            help1 = scan.nextLine();
            //Game Loop, with input
            switch(help1){
                case "1", "2", "3","4","5","6","7","8","9" -> GameCode.exec(pF, help1, p1);
                case "end" -> opGame = false;
                default -> turn-=1;
            }
            if(GameCode.checkWin(p1,pF)){
                System.out.print(p1?"Player 1 has won!":"Player 2 has won!");
                break;
            }
            turn++;
            if (turn ==11){
                System.out.println("DRAW");
                opGame = false;
            }
        }
    }
}
