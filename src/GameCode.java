public class GameCode {
    public static void main(String[] args) {

    }
    //Creates the plain PlayField
    public static String[][] playField(){
        String[][] pF = new String[3][3];
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3;j++){
                pF[i][j] = "#";
            }
        }
        return pF;
    }
    //Displays the PLayField, can be recalled each round
    public static void showpF(String[][] pF){
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3;j++){
                System.out.print(pF[i][j]);
            }
            System.out.println();
        }
    }
    //edits the PF and places either "X" or "O"
    public static String[][] exec(String[][] pF, String x,boolean p1){
        int y = Integer.parseInt(x);
        y -= 1;
        if(y<=2){
            pF[0][y]= p1?"X":"O";
        }
        else if(y<=5){
            pF[1][y-3]= p1?"X":"O";
        }
        else{
            pF[2][y-6]= p1?"X":"O";
        }
        return pF;
    }
    //Checks the win condition
    public static boolean checkWin(boolean p1, String[][] pF){
        boolean hasWon = false;
        char c;
        char toCheck;
        int winCount = 0;
        int winCount2 = 0;
        int specialWin = 0;
        if(p1){
            toCheck = 'X';
        }
        else{
            toCheck = 'O';
        }

        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++) {
                c = pF[i][j].charAt(0);
                if (c == toCheck) {
                    winCount++;
                }
                c = pF[j][i].charAt(0);
                if (c == toCheck){
                    winCount2++;
                }
            }
                if (winCount == 3||winCount2 ==3) {
                    hasWon = true;
                    break;
                } else {
                    winCount = 0;
                    winCount2 = 0;
                }
        }
        if (pF[0][0].charAt(0)==toCheck && pF[1][1].charAt(0)==toCheck && pF[2][2].charAt(0)==toCheck){
            hasWon = true;
        }
        if(pF[0][2].charAt(0)==toCheck && pF[1][1].charAt(0)==toCheck && pF[2][0].charAt(0)==toCheck){
            hasWon = true;
        }
        return hasWon;
    }
}
