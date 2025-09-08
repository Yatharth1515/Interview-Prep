package org.example;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Game {

    Board gameBoard;
    Deque<Player> playerQueue;
    public Game(){
        initializeGame();
    }

    private void initializeGame() {
        // Initializing game , with 2 players that will play with X and O type
        PlayingPiece oPiece = new PlayingPieceO();
        Player player1 = new Player("player1", oPiece);

        PlayingPiece xPiece = new PlayingPieceX();
        Player player2 = new Player("player2", xPiece);

        playerQueue = new LinkedList<>();
        playerQueue.add(player1);
        playerQueue.add(player2);

        gameBoard = new Board(3);
    }

    public String start(){
        System.out.println(" starting game ");
        boolean noWinner = true;
        while(noWinner){

            gameBoard.printBoard();

            if(!gameBoard.isBoardFilled()){
                noWinner = false;
                continue;
            }
            Player p = playerQueue.removeFirst();
            System.out.println("Your turn " + p.name + " enter playingPiece :- " + p.playingPiece.pieceType);
            Scanner sc = new Scanner(System.in);
            String st = sc.nextLine();;
            String[] inputs = st.split(",");
            int row  = Integer.parseInt(inputs[0]);
            int col = Integer.parseInt(inputs[1]);

            boolean addedSuccessfully = gameBoard.addPiece(row, col, p.playingPiece);
            gameBoard.printBoard();
            if (!addedSuccessfully){
                System.out.println(" add again , insertion not valid ");
                playerQueue.addFirst(p);
                continue;
            }
            boolean winner = gameBoard.checkGame(row, col, p.playingPiece.pieceType);
            if (winner){
                return p.name + " is winner";
            }
            playerQueue.addLast(p);
            //check if there's a place to add
        }
        return "Its a Tie";
    }


}
