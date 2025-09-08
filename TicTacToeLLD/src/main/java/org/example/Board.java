package org.example;

public class Board {
    int size;
    PlayingPiece[][] pt;

    public Board(int size){
        this.size = size;
        pt = new PlayingPiece[size][size];
    }

    public boolean isBoardFilled() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(pt[i][j] == null){
                    return true;
                }
            }
        }
        return false;
    }
    public void printBoard(){
        for (int i = 0; i < size; i++) {
            System.out.println(" ");
            for (int j = 0; j < size; j++) {
                System.out.print(" | " + (null != pt[i][j]  ? pt[i][j].pieceType  : "__" ) + " | ");
            }
        }
        System.out.println(" ");
        System.out.println(" ------ ------ ------ ------ ");
    }


    public boolean addPiece(int row, int col, PlayingPiece playingPiece) {
        if (pt[row][col] != null) return false;
        pt[row][col] = playingPiece;
        return true;
    }

    public boolean checkGame(int row, int col, PieceType pieceType) {
        boolean a = true , b = true , c = true , d = true;
        // column check
        for (int i = 0; i < size; i++) {
            if (pt[row][i] == null ||  pt[row][i].pieceType != pieceType) {
                a = false;
                break;
            }
        }
        // row check
        for (int i = 0; i < size; i++) {
            if (pt[i][col] == null || pt[i][col].pieceType != pieceType) {
                b = false;
                break;
            }
        }
        // diagonal check
        for (int i = 0, j = 0; i < size && j < size; i++, j++) {
            if (pt[i][j] == null ||  pt[i][j].pieceType != pieceType) {
                c = false;
                break;
            }
        }
        // anti-diagonal check
        for (int i = 0, j = size - 1 ; i < size && j >= 0; i++, j--) {
            if ( pt[i][j] == null || pt[i][j].pieceType != pieceType) {
                d = false;
                break;
            }
        }
        return a || b || c || d;
    }
}
