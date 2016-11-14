package com.company.miscellaneous;

import java.util.*;

/**
 * Created by rajpurev on 7/13/16.
 */
public class TicTacToe {

    public static void main(String args[]){

        Scanner scanner = new Scanner(System.in);

        int[][] matrix = new int[3][3];
        System.out.println(matrix);
// 2 9 7 1 1
        for ( int i = 0 ; i < 5 ; i++) {

            System.out.println("Enter your position (from 0 to 9) : ");
            int humanMove = scanner.nextInt();
            System.out.println("Your Move:" + humanMove);

            putMove( humanMove, matrix, 1); //human move : 1
            int winCheckResult = checkWin(matrix);
            if( winCheckResult != -1) {
                if( winCheckResult == 2) {
                    System.out.println(" Computer Won");
                } else  if( winCheckResult == 1) {
                    System.out.println(" Human Won");
                }
                break;
            }

            if (isMatrixFilledCompletely(matrix)) {
                System.out.println("It's a DRAW !!");
                return;
            }
            // computer's move
            calculateNextPosition( matrix);

            System.out.println("Grid after computers Move :");
            displayMatrix(matrix);

            winCheckResult = checkWin(matrix);
            if( winCheckResult != -1 && true) {
                if( winCheckResult == 2) {
                    System.out.println(" Computer Won");
                } else  if( winCheckResult == 1) {
                    System.out.println(" Humnan Won");
                }
                break;
            }
        }
    }

    private static boolean isMatrixFilledCompletely(int[][] matrix) {
        for( int i = 0 ; i < 3 ; i++){
            for( int j = 0 ; j < 3 ; j++) {
                if( matrix[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int checkWin( int[][] matrix) {
        //Row

        for ( int i = 0 ; i < 3; i++) {
            if( (matrix[i][0] == matrix[i][1]) && (matrix[i][1] == matrix[i][2])){
                if( matrix [i][i] != 0) {
                    return matrix[i][i];
                }
            }
        }

        //Column
        for ( int i = 0 ; i < 3; i++) {
            if( (matrix[0][i] == matrix[1][i]) && (matrix[1][i] == matrix[2][i])){
                if( matrix[i][i] != 0) {
                    return matrix[i][i];
                }

            }
        }

        // diagonal
        int i = 0;
        if( (matrix[i][i] == matrix[i+1][i+1]) && (matrix[i+1][i+1] == matrix[i+2][i+2]) && (matrix[i][i] != 0)){
            return matrix[i][i];
        }


        // diagonal
        int j = 0,k = 2;
        if( (matrix[j][k] == matrix[j+1][k-1]) && (matrix[j+1][k-1] == matrix[j+2][k-2]) && (matrix[j][k] != 0)){
            return matrix[i][i];
        }

        return -1;
    }

    private static void putMove(int humanMove , int[][] matrix, int value){
        int[] matrixPosition = getArrayPosition( humanMove);
        int one = matrixPosition[0];
        int two = matrixPosition[1];
        matrix[one][two] = value;
    }

    private static void calculateNextPosition( int[][] m){
        boolean isMove = false;
        isMove = checkRow( m);
        if( !isMove) {
            isMove = checkColumn( m);
        }
        if( !isMove) {
            isMove = checkDiagonal( m);
        }

        // check fork
        if( !isMove) {
            isMove = createForkPosition(m);
        }
        if( !isMove) {
            isMove = checkForOppositionFork(m);
        }

        //center position
        if( !isMove && (m[1][1] == 0)) {
            m[1][1] = 2;
            isMove = true;
        }

        // check corners
        if( !isMove) {
            isMove = checkCorners(m);
        }
        if( !isMove) {
            randomMove(m);
        }
    }

    private static void randomMove(int[][] matrix) {
        for ( int i = 0 ; i < 3; i++) {
            for( int j = 0 ; j < 3; j++) {
                if( matrix[i][j] == 0) {
                    matrix[i][j] = 2;
                    return;
                }
            }
        }
    }

    private static boolean checkRow( int[][] m) {
        for ( int i = 0 ; i < 3; i++) {
            int computerMove = 0 , humanMove = 0 , blankSpac = 0;
            List<Integer> emptyIndices = new ArrayList<>();
            for( int j = 0 ; j < 3; j++) {
                if( m[i][j] == 2) {
                    computerMove++;
                }
                else if( m[i][j] == 1) {
                    humanMove++;
                }
                else{
                    emptyIndices.add(j);
                }
            }

            if( (emptyIndices.size() > 0 ) && (computerMove == 2 || humanMove == 2) ) {
                m[i][emptyIndices.get(0)] = 2;
                return true;
            }
        }
        return false;
    }

    /*
    00 01 02
    10 11 12
    20 21 22

     */
    private static boolean checkColumn(int[][] m) {
        for ( int i = 0 ; i < 3; i++) {
            int computerMove = 0 , humanMove = 0 , blankSpac = 0;
            List<Integer> emptyIndices = new ArrayList<>();
            for( int j = 0 ; j < 3; j++) {
                if( m[j][i] == 2) {
                    computerMove++;
                }
                else if( m[j][i] == 1) {
                    humanMove++;
                }
                else{
                    emptyIndices.add(j);
                }
            }

            if( (emptyIndices.size() > 0 ) && (computerMove == 2 || humanMove == 2)) {
                m[emptyIndices.get(0)][i] = 2;
                return true;
            }
        }
        return false;
    }

    private static boolean checkCorners(int[][] matrix) {
        int i = 0;
        List<Integer> diagonal = new ArrayList<>();
        diagonal.add( matrix[i][i]);
        diagonal.add( matrix[i+1][i+1]);
        diagonal.add( matrix[i+2][i+2]);

        // Reverse Diagonal
        int j = 0,k = 2;
        List<Integer> reverseDiagonal = new ArrayList<>();
        reverseDiagonal.add( matrix[j][k]);
        reverseDiagonal.add( matrix[j+1][k-1]);
        reverseDiagonal.add( matrix[j+2][k-2]);

        //prefer corner
        if( diagonal.get(0) == 1 && diagonal.get(2) == 0) {
            matrix[2][2] = 2;
            return true;
        } else if( diagonal.get(2) == 1 && diagonal.get(0) == 0){
            matrix[0][0] = 2;
            return true;
        }

        //prefer reverse diagonal
        if( reverseDiagonal.get(0) == 1 && reverseDiagonal.get(2) == 0) {
            matrix[2][0] = 2;
            return true;
        } else if( reverseDiagonal.get(2) == 1 && reverseDiagonal.get(0) == 0){
            matrix[0][2] = 2;
            return true;
        }

        //put element in random corner
        if( diagonal.get(0) == 0) {
            matrix[0][0] = 2;
            return true;
        } else if( diagonal.get(2) == 0) {
            matrix[2][2] = 2;
            return true;
        } else if( reverseDiagonal.get(0) == 0){
            matrix[0][2] = 2;
            return true;
        } else if( reverseDiagonal.get(2) == 0){
            matrix[2][0] = 2;
            return true;
        }
        return false;
    }

    private static boolean checkDiagonal(int[][] matrix) {
        int i = 0;
        List<Integer> diagonal = new ArrayList<>();
        diagonal.add( matrix[i][i]);
        diagonal.add( matrix[i+1][i+1]);
        diagonal.add( matrix[i+2][i+2]);

        //Form Computer's Diagonal Win Move ||
        // Block Human Move Diagonal Win Move
        if(( diagonal.get(0) == 2 && diagonal.get(1) ==2 && diagonal.get(2) == 0) ||
                ( diagonal.get(0) == 1 && diagonal.get(1) ==1 && diagonal.get(2) == 0)){
            matrix[i+2][i+2] = 2;
            return true;

        }
        else if(( diagonal.get(1) == 2 && diagonal.get(2) ==2 && diagonal.get(0) == 0) ||
                ( diagonal.get(1) == 1 && diagonal.get(2) ==1 && diagonal.get(0) == 0)){
            matrix[i][i] = 2;
            return true;

        }
        else if(( diagonal.get(0) == 2 && diagonal.get(2) ==2 && diagonal.get(1) == 0) ||
                ( diagonal.get(0) == 1 && diagonal.get(2) ==1 && diagonal.get(1) == 0)){
            matrix[i+1][i+1] = 2;
            return true;
        }

        // Reverse Diagonal
        int j = 0,k = 2;
        List<Integer> reverseDiagonal = new ArrayList<>();
        reverseDiagonal.add( matrix[j][k]);
        reverseDiagonal.add( matrix[j+1][k-1]);
        reverseDiagonal.add( matrix[j+2][k-2]);

        //Form Computer's Diagonal Win Move ||
        // Block Human Move Diagonal Win Move
        if( (reverseDiagonal.get(0) == 2 && reverseDiagonal.get(1) ==2 && reverseDiagonal.get(2) == 0) ||
                (reverseDiagonal.get(0) == 1 && reverseDiagonal.get(1) ==1 && reverseDiagonal.get(2) == 0)) {
            matrix[j+2][k-2] = 2;
            return true;

        }
        else if( (reverseDiagonal.get(1) == 2 && reverseDiagonal.get(2) ==2 && reverseDiagonal.get(0) == 0) ||
                (reverseDiagonal.get(1) == 1 && reverseDiagonal.get(2) ==1 && reverseDiagonal.get(0) == 0)) {
            matrix[j][k] = 2;
            return true;
        }else if( (reverseDiagonal.get(0) == 2 && reverseDiagonal.get(2) ==2 && reverseDiagonal.get(1) == 0) ||
                (reverseDiagonal.get(0) == 1 && reverseDiagonal.get(2) ==1 && reverseDiagonal.get(1) == 0))  {
            matrix[j+1][k-1] = 2;
            return true;
        }

        return false;
    }


    private static boolean createForkPosition(int[][] m) {

        //check for row
        return detectForkAndMove( m ,2);
    }

    /*
   00 01 02
   10 11 12
   20 21 22

    */
    private static boolean detectForkAndMove( int[][] m , int value) {
        for ( int i = 0 ; i < 3; i++) {
            int rowWithSingleValue = i;
            boolean computerSigleMove = onlyOneMove(m[i][0],m[i][1],m[i][2], value);
            if( computerSigleMove) {
                int colWithSingleValue = -1;
                // scan overlapping column
                for( int j = 0 ; j < 3 ; j++) {
                    boolean computerSigleMoveColPresent = onlyOneMove(m[0][j],m[1][j],m[2][j], value);
                    if( computerSigleMoveColPresent){
                        colWithSingleValue = j;
                        break;
                    }
                } // end of iterating column

                if( colWithSingleValue != -1 && (m[rowWithSingleValue][colWithSingleValue] == 0)) {
                    m[rowWithSingleValue][colWithSingleValue] = 2;
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkForOppositionFork(int[][] m) {

        return detectForkAndMove( m ,1);
    }

    private static boolean onlyOneMove(int val1 ,int val2 , int val3 , int moveValue) {

        if ((val1 == moveValue && val2 == 0 && val3 == 0)
            ||( val1 == 0 && val2 == moveValue && val3 == 0)
            || ( val1 == 0 && val2 == 0 && val3 == moveValue)){

            return true;
        }
        return false;
    }

    private static void displayMatrix( int [][] matrix) {
        for ( int i = 0 ; i < 3; i++) {
            for( int j = 0 ; j < 3; j++) {
                System.out.print( matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[] getArrayPosition(int num) {
        int[] arr = new int[2];
        switch( num) {

            case 1:
                arr[0] = 0;
                arr[1] = 0;
                break;

            case 2:
                arr[0] = 0;
                arr[1] = 1;
                break;

            case 3:
                arr[0] = 0;
                arr[1] = 2;
                break;

            case 4:
                arr[0] = 1;
                arr[1] = 0;
                break;

            case 5:
                arr[0] = 1;
                arr[1] = 1;
                break;

            case 6:
                arr[0] = 1;
                arr[1] = 2;
                break;

            case 7:
                arr[0] = 2;
                arr[1] = 0;
                break;

            case 8:
                arr[0] = 2;
                arr[1] = 1;
                break;

            case 9:
                arr[0] = 2;
                arr[1] = 2;
                break;

            default :
                throw new IllegalArgumentException();
        }

        return arr;
    }
}
