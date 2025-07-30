package tictactoe;

import tictactoe.mode.*;
import tictactoe.util.Pair;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    Deque<Player> players;
    Board gameBoard;

    TicTacToeGame(){
        initializeGame();
    }

    public void initializeGame() {
        players = new LinkedList<>();
        PlayingPieceX crossPiece = new PlayingPieceX();
        Player player1 = new Player("Player1", crossPiece);
        PlayingPieceO noughtPiece = new PlayingPieceO();
        Player player2 = new Player("Player2", noughtPiece);
        players.add(player1);
        players.add(player2);

        gameBoard = new Board(3);


    }

    public String startGame(){
        boolean noWinner = true;
        while (noWinner){
            Player playerTurn = players.removeFirst();

            gameBoard.printBoard();
            List<Pair> freeSpaces = gameBoard.getFreeCells();
            if(freeSpaces.isEmpty()) {
                noWinner=false;
                continue;
            }

            System.out.println("Player: "+playerTurn.getName()+ " Enter row, column: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String [] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);

            boolean pieceAddedSuccessfully = gameBoard.addPiece(inputRow, inputColumn, playerTurn.getPlayingPiece());
            if(!pieceAddedSuccessfully)
            {
                System.out.println("Incorrect position chosen, try again");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);

            boolean winner = isThereWinner(inputRow, inputColumn, playerTurn.getPlayingPiece());
            if(winner)
                return playerTurn.getName();
        }
        return "tie";
    }

    private boolean isThereWinner(int row, int col, PlayingPiece playingPiece) {
        boolean rowMatch = true;
        boolean colMatch = true;
        boolean digMatch =true;
        boolean antiDigMatch = true;

        for(int i=0;i<gameBoard.size;i++) {
            if (gameBoard.board[row][i] == null || gameBoard.board[row][i].pieceType!=playingPiece.pieceType)
                rowMatch = false;
        }
        for(int i=0;i<gameBoard.size;i++) {
            if (gameBoard.board[i][col] == null || gameBoard.board[i][col].pieceType!=playingPiece.pieceType)
                colMatch = false;
        }
        for(int i=0, j=0;i<gameBoard.size;i++, j++) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType!=playingPiece.pieceType)
                digMatch = false;
        }
    for (int i = 0, j = gameBoard.size-1; i < gameBoard.size; i++, j--) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType!=playingPiece.pieceType)
                antiDigMatch = false;
        }
    return rowMatch||colMatch||digMatch||antiDigMatch;

    }


}
