public class TicTacToe {
    private int size;
    // заменил обьявление констант char на перечисление Mark
    enum Mark {
        Empty, X, O
    }
    private Mark[][] field;
    TicTacToe(int size) {
        this.size = size;
        field = new Mark[size][size];

    }

    public static Mark mark = Mark.X;

    public void addMark(int pointXX,  int pointXY){
        //проверка на пустоту клетки
        if(field[pointXX][pointXY] != null){
            mark = Mark.Empty;
        }

        //проверка на выход за границу массива
        if(pointXX >= 3 || pointXY >= 3){
            throw new ArrayIndexOutOfBoundsException();
        }

        //добавление марки
        switch(mark){
            case X: field[pointXX][pointXY] = Mark.X;
                break;
            case O: field[pointXX][pointXY] = Mark.O;
                break;
            case Empty: break;
        }
    }

    //удаление марки
    public void removeMark(int pointXX, int pointXY){
        if(pointXX >= 3 || pointXY >= 3){
            throw new ArrayIndexOutOfBoundsException();
        }
        field[pointXX][pointXY] = null;
    }

    //самая длинная горизонтальная
    private int longestHorizontal(){
        int longestH = 0;
        int longestH2 = 0;
        switch(mark){
            //для Х
            case X:
                for(int row = 0; row < size; row++) {
                    for (int column = 0; column < size - 1; column++) {
                        if (field[row][column] == field[row][column + 1] && field[row][column] == Mark.X) {
                            longestH++;
                        }
                    }
                    longestH2 = Math.max(longestH, longestH2);
                    longestH = 0;
                }
                longestH = longestH2 + 1 ;
                break;
            //для О
            case O:
                for(int row = 0; row < size; row++){
                    for(int column = 0; column < size - 1; column++){
                        if(field[row][column] == field[row][column + 1] && field[row][column] == Mark.O){
                            longestH++;
                        }
                    }
                    longestH2 = Math.max(longestH, longestH2);
                    longestH = 0;
                }
                longestH = longestH2 + 1;
                break;
            case Empty:
                break;
        }
        return longestH;
    }

    //самая длинная вертикальная
    private int longestVertical(){
        int longestV = 0;
        int longestV2 = 0;
        switch(mark){
            //для Х
            case X:
                for(int column = 0; column < size; column++){
                    for(int row = 0; row < size - 1; row++){
                        if(field[row][column] == field[row + 1][column] && field[row][column] == Mark.X){
                            longestV++;
                        }
                    }
                    longestV2 = Math.max(longestV, longestV2);
                    longestV = 0;
                }
                longestV = longestV2 + 1;
                break;
            //для О
            case O:
                for(int column = 0; column < size; column++){
                    for(int row = 0; row < size - 1; row++){
                        if(field[column][row] == field[column][row + 1] && field[row][column] == Mark.O){
                            longestV++;
                        }
                    }
                    longestV2 = Math.max(longestV, longestV2);
                    longestV = 0;
                }
                longestV = longestV2 + 1;
                break;
            case Empty:
                break;
        }
        return longestV;
    }

    //самая длинная на главной диагонали
    private int longestMainDiagonal(){
        int longestMD = 0;
        switch(mark){
            //для Х
            case X:
                for(int row = 0; row < size - 1; row++){
                    for(int column = 0; column < size - 1; column++){
                        if(field[row][column] == field[row + 1][column + 1] && field[row][column] == Mark.X){
                            longestMD++;
                        }
                        row++;
                    }
                }
                longestMD++;
                break;
            //для О
            case O:
                for(int row = 0; row < size; row++){
                    for(int column = 0; column < size; column++){
                        if(field[row][column] == field[row + 1][column + 1] && field[row][column] == Mark.O){
                            longestMD++;
                        }
                        row++;
                    }
                }
                longestMD++;
                break;
            case Empty:
                break;
        }
        return longestMD;
    }

    //самая длинная на побочной диагонали
    private int longestSecondaryDiagonal(){
        int longestSD = 0;
        switch(mark){
            //для Х
            case X:
                for(int row = size - 1; row > 0; row--){
                    for(int column = 0; column < size - 1; column++){
                        if(field[row][column] == field[row - 1][column + 1] && field[row][column] == Mark.X){
                            longestSD++;
                        }
                        row--;
                    }
                }
                longestSD++;
                break;
            //для О
            case O:
                for(int row = size - 1; row >= 0; row--){
                    for(int column = 0; column < size; column++){
                        if(field[row][column] == field[row - 1][column + 1] && field[row][column] == Mark.O){
                            longestSD++;
                        }
                        row--;
                    }
                }
                longestSD++;
                break;
            case Empty:
                break;
        }
        return longestSD;
    }

    public int getLongest(){
        return Math.max(Math.max(Math.max(longestMainDiagonal(),
                longestSecondaryDiagonal()),
                longestVertical()),
                longestHorizontal());
    }

    Mark[][] getField() {
        return field;
    }
}
