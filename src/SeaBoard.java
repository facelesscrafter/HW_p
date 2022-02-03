public class SeaBoard {
    private String[][] field =new String[10][10];
    private static final int size=10;
    public SeaBoard() {
        for(int i=0;i<size;i++)
            for (int j = 0; j < size; j++)this.field[i][j]=".";
    }
    public String[][] getField(){
        return this.field;
    }
    public String getSField(){
        String boardS="";

        for(int i=0;i<size;i++) {
            for (int j = 0; j < size; j++){
                boardS=boardS+this.field[i][j];
            }
            boardS=boardS+"\n";
        }
        return boardS;
    }
    public void shoot(int line, int column, String issue){

        if(issue.equals("m")){
            this.field[line][column]="#";
        }
        else if(issue.equals("h"))this.field[line][column]="x";
        else if(issue.equals("d")){
            this.field[line][column]="x";
            this.destroyed(line,column);
        }
    }

    public void destroyed(int x,int y){
        boolean h=false;
        boolean v=false;
        boolean moreThanOne=false;
        //horizontal
        if(y==0)h=check(x,y+1).equals("x");
        else if(y==size-1)h=check(x,y-1).equals("x");
        else h=check(x,y-1).equals("x")||check(x,y+1).equals("x");
        //if(h)System.out.println("h");
        //vertical
        if(x==0)v=check(x+1,y).equals("x");
        else if(x==size-1)v=check(x-1,y).equals("x");
        else v=check(x-1,y).equals("x")||check(x+1,y).equals("x");
        //if(v)System.out.println("v");
        if(h){
            for(int j=y;j>=0;j--){
                if(check(x,j).equals("x")){
                    if(x+1<size)this.field[x+1][j]="#";
                    if(x-1>=0)this.field[x-1][j]="#";
                }
                else{
                    if(x+1<size)this.field[x+1][j]="#";
                    if(x-1>=0)this.field[x-1][j]="#";
                    this.field[x][j]="#";
                    break;
                }
            }
            for(int j=y+1;j<size;j++){
                if(check(x,j).equals("x")){
                    if(x+1<size)this.field[x+1][j]="#";
                    if(x-1>=0)this.field[x-1][j]="#";
                }
                else{
                    if(x+1<size)this.field[x+1][j]="#";
                    if(x-1>=0)this.field[x-1][j]="#";
                    this.field[x][j]="#";
                    break;
                }
            }
        }
        else if(v){
            for(int i=x;i>=0;i--){
                if(check(i,y).equals("x")){
                    if(y+1<size)this.field[i][y+1]="#";
                    if(y-1>=0)this.field[i][y-1]="#";
                }
                else{
                    if(y+1<size)this.field[i][y+1]="#";
                    if(y-1>=0)this.field[i][y-1]="#";
                    this.field[i][y]="#";
                    break;
                }
            }
            for(int i=x+1;i<size;i++){
                if(check(i,y).equals("x")){
                    if(y+1<size)this.field[i][y+1]="#";
                    if(y-1>=0)this.field[i][y-1]="#";
                }
                else{
                    if(y+1<size)this.field[i][y+1]="#";
                    if(y-1>=0)this.field[i][y-1]="#";
                    this.field[i][y]="#";
                    break;
                }
            }
        }
        else if(!v && !h){
            if(x==0 && y==0){
                this.field[x+1][y]="#";
                this.field[x+1][y+1]="#";
                this.field[x][y+1]="#";
            }
            else if(x==0 && y==9){
                this.field[x+1][y]="#";
                this.field[x+1][y-1]="#";
                this.field[x][y-1]="#";
            }
            else if(x==9 && y==9){
                this.field[x-1][y]="#";
                this.field[x-1][y-1]="#";
                this.field[x][y-1]="#";
            }
            else if(x==9 && y==0){
                this.field[x-1][y]="#";
                this.field[x-1][y+1]="#";
                this.field[x][y+1]="#";
            }
            else if (x==0){
                this.field[x+1][y]="#";
                this.field[x][y+1]="#";
                this.field[x][y-1]="#";
                this.field[x+1][y-1]="#";
                this.field[x+1][y+1]="#";

            }
            else if(x==9){
                this.field[x-1][y-1]="#";
                this.field[x-1][y+1]="#";
                this.field[x-1][y]="#";
                this.field[x][y+1]="#";
                this.field[x][y-1]="#";
            }
            else if(y==0){
                this.field[x-1][y+1]="#";
                this.field[x+1][y]="#";
                this.field[x-1][y]="#";
                this.field[x][y+1]="#";
                this.field[x+1][y+1]="#";
            }
            else if(y==9){
                this.field[x-1][y-1]="#";
                this.field[x+1][y]="#";
                this.field[x-1][y]="#";
                this.field[x][y-1]="#";
                this.field[x+1][y-1]="#";
            }
            else{
                this.field[x-1][y-1]="#";
                this.field[x-1][y+1]="#";
                this.field[x+1][y]="#";
                this.field[x-1][y]="#";
                this.field[x][y+1]="#";
                this.field[x][y-1]="#";
                this.field[x+1][y-1]="#";
                this.field[x+1][y+1]="#";
            }
        }

    }
    public String check(int line, int column){
        String out=this.field[line][column];
        return out;
    }
}
