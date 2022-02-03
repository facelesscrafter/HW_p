public class TicTacToe {
    //тут бы char[][] подошел больше, но согласно заданию, это массив строк
    String[][] pole=new String[][]{
           {"-", "-", "-"},
           {"-", "-", "-"},
           {"-", "-", "-"}
   };
   static private int player;
   private boolean isGame=false;
   public void newGame(){
       for(int i=0;i<3;i++)
           for (int j = 0; j < 3; j++)this.pole[i][j]="-";

        this.isGame=true;
        player=0;
   }
   public String[][] getField(){
       return this.pole;
   }
   public String getSField(){
       String boardS="";

       for(int i=0;i<3;i++) {
           boardS=boardS+"[";
           for (int j = 0; j < 3; j++){
               boardS=boardS+"'"+this.pole[i][j]+"'";
               if(j!=2)boardS=boardS+",";
           }
           boardS=boardS+"]\n";
       }
       return boardS;
   }
   public String checkGame(){
       String winner;
       if(this.isGame)return "null";
       if(this.checkOne("0"))return "0";
       if(this.checkOne("X"))return "X";
       return "D";
   }
   private boolean checkOne(String c){
       boolean t=false;
       for(int i=0;i<3;i++){
           t=(this.pole[i][0].equals(c) && this.pole[i][1].equals(c) && this.pole[i][2].equals(c));
           if(t)return t;
       }
       for(int j=0;j<3;j++) {
           t = (this.pole[0][j].equals(c) && this.pole[1][j].equals(c) && this.pole[2][j].equals(c));
           if (t) return t;
       }
       t=((this.pole[0][0].equals(c) && this.pole[1][1].equals(c) && this.pole[2][2].equals(c))||(this.pole[2][0].equals(c) && this.pole[1][1].equals(c) && this.pole[0][2].equals(c)));
       return t;
   }
   public String makeMove(int x, int y){
       int xX=x;
       int yY=y;
       x--;
       y--;
       if(!this.isGame)return "Game was ended";
       if(!this.pole[x][y].equals("-"))return "Cell "+xX+", "+yY+" is already occupied";
       if(player==0){
           this.pole[x][y]="X";
           player++;
           if(checkOne("X")){
               this.isGame=false;
               return "Player X won";
           }
       }
       else if(player==1){
           this.pole[x][y]="0";
           player=0;
           if(checkOne("0")){
               this.isGame=false;
               return "Player 0 won";
           }
       }
       boolean full=true;
       for(int i=0;i<3;i++) {
           for (int j = 0; j < 3; j++)
               if (this.pole[i][j].equals("-")) {
                   full = false;
                   break;
               }
           if(!full)break;
       }
       if(full)return "Draw";
       return "Move completed";
   }
}
