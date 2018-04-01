//когда происходит выход за границы массива, комп сам бросает ArrayIndexOutOfBoundsException, поэтому я в exception
//бросаю ту же ошибку
public class TicTacToe {
    private int size;
    enum Mark {
        X, O
    }
    private Mark[][] field;
    TicTacToe(int size) {
        this.size = size;
        field = new Mark[size][size];

    }

    public void addMark(int pointXX,  int pointXY, Mark mark){

        //проверка на выход за границы массива
        if ((pointXX < 0 || pointXX > size - 1) && ((pointXY < 0 || pointXY > size - 1))){
            throw new ArrayIndexOutOfBoundsException();
        }

        //проверка на пустоту клетки
        if(field[pointXX][pointXY] != null){
            mark = null;
        }

        //добавление марки
        if(mark != null){
            field[pointXX][pointXY] = mark;
        }
    }

    //удаление марки
    public void removeMark(int pointXX, int pointXY){

        //проверка на выход за границы массива
        if ((pointXX < 0 || pointXX > size - 1) && ((pointXY < 0 || pointXY > size - 1))){
            throw new ArrayIndexOutOfBoundsException();
        }
        //удаление марки
        field[pointXX][pointXY] = null;
    }

    //самая длинная горизонтальная
    private int longestHorizontal(){

        int longestH2 = 0;
        for(int row = 0; row < size; row++) {
            int longestH = 0;
            for (int column = 0; column < size - 1; column++) {
                if (field[row][column] == field[row][column + 1] && field[row][column] != null) {
                    longestH++;
                }
                else{
                    longestH = 0;
                }
            }
            longestH2 = Math.max(longestH, longestH2);
        }
        longestH2 = longestH2 + 1;
        return longestH2;
    }

    //самая длинная вертикальная
    private int longestVertical() {
        int longestV2 = 0;
        for (int column = 0; column < size; column++) {
            int longestV = 0;
            for (int row = 0; row < size - 1; row++) {
                if (field[row][column] == field[row + 1][column] && field[row][column] != null) {
                    longestV++;
                }
            }
            longestV2 = Math.max(longestV, longestV2);
        }
        longestV2 = longestV2 + 1;
        return longestV2;
    }

    //самая длинная на главной диагонали
    private int longestMainDiagonal() {
        int longestMD = 0;
        int column;
        for (int row = 0; row < size - 1; row++) {
            column = row;
            if (field[row][column] == field[row + 1][column + 1] && field[row][column] != null) {
                longestMD++;
            }
        }
        longestMD++;
        return longestMD;
    }

    //самая длинная на побочной диагонали
    private int longestSecondaryDiagonal(){
        int longestSD = 0;
        int row;
        for (int column = 0; column < size - 1; column++) {
            row = size - column - 1;
            if (field[row][column] == field[row - 1][column + 1] && field[row][column] != null) {
                longestSD++;
            }

        }
                longestSD++;
        return longestSD;
    }

    public int getLongest(){
        return Math.max(Math.max(Math.max(longestMainDiagonal(),
                longestSecondaryDiagonal()),
                longestVertical()),
                longestHorizontal());
    }


    Mark[][] getField() {
        return field.clone();
    }
}
