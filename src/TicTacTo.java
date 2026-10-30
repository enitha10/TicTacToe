public class TicTacTo {
    private int[][] board;
    private  int n;
    private int[] rowm;
    private int[] colm;
    private int diag;
    private int revdig;
    private int winner;
    public TicTacTo(int n){
        this.n=n;
        this.board=new int[n][n];
        this.rowm=new int[n];
        this.colm=new int[n];
        this.winner=0;
    }
    public int move(int player,int row,int col) throws IllegalArgumentException{
        if(row<0 || row>=n || col<0 || col>=n){
            throw new IllegalArgumentException("Move is on out of board");
        }
        if(board[row][col]!=0){
            throw new IllegalArgumentException("Already occupied");
        }
        if(player!=0 && player!=1){
            throw new IllegalArgumentException("Player does not exist");
        }
        int val=player==0?-1:1;
        board[row][col]=val;
        rowm[row]+=val;
        colm[col]+=val;
        if(row==col){
            diag+=val;
        }
        if(row==n-1-col){
            revdig+=val;
        }
        if(Math.abs(rowm[row])==n || Math.abs(colm[col])==n || Math.abs(diag)==n || Math.abs(revdig)==n){
            winner=val;
        }
        return getWinner();
    }
    public int getWinner(){
        return winner;
    }
}
