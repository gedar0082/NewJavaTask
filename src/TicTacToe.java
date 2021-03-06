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

    public boolean addMark(int pointXX,  int pointXY, Mark mark){

        //проверка на выход за границы массива
        if ((pointXX < 0 || pointXX > size - 1) && ((pointXY < 0 || pointXY > size - 1))){
            throw new IndexOutOfBoundsException();
        }

        //проверка на пустоту клетки
        if(field[pointXX][pointXY] != null){
            return false;
        }
            field[pointXX][pointXY] = mark;
            return true;
    }

    //удаление марки
    public boolean removeMark(int pointXX, int pointXY){

        //проверка на выход за границы массива
        if ((pointXX < 0 || pointXX > size - 1) && ((pointXY < 0 || pointXY > size - 1))){
            throw new IndexOutOfBoundsException();
        }
        //удаление марки
        if(field[pointXX][pointXY] == null){
            return false;
        }
        field[pointXX][pointXY] = null;
        return true;
    }

    //самая длинная горизонтальная
    private int longestHorizontal(Mark mark){

        int longestH2 = 0;
        for(int row = 0; row < size; row++) {
            int longestH = 0;
            for (int column = 0; column < size - 1; column++) {
                if (field[row][column] == field[row][column + 1] && field[row][column] == mark) {
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
    private int longestVertical(Mark mark) {
        int longestV2 = 0;
        for (int column = 0; column < size; column++) {
            int longestV = 0;
            for (int row = 0; row < size - 1; row++) {
                if (field[row][column] == field[row + 1][column] && field[row][column] == mark) {
                    longestV++;
                }
            }
            longestV2 = Math.max(longestV, longestV2);
        }
        longestV2 = longestV2 + 1;
        return longestV2;
    }

    //самая длинная на главной диагонали
    private int longestMainDiagonal(Mark mark) {
        int longestMD = 0;
        int column;
        for (int row = 0; row < size - 1; row++) {
            column = row;
            if (field[row][column] == field[row + 1][column + 1] && field[row][column] == mark) {
                longestMD++;
            }
        }
        longestMD++;
        return longestMD;
    }

    //самая длинная на побочной диагонали
    private int longestSecondaryDiagonal(Mark mark){
        int longestSD = 0;
        int row;
        for (int column = 0; column < size - 1; column++) {
            row = size - column - 1;
            if (field[row][column] == field[row - 1][column + 1] && field[row][column] == mark) {
                longestSD++;
            }

        }
                longestSD++;
        return longestSD;
    }

    public int getLongest(Mark mark){
        return Math.max(Math.max(Math.max(longestMainDiagonal(mark),
                longestSecondaryDiagonal(mark)),
                longestVertical(mark)),
                longestHorizontal(mark));
    }


    Mark getPoint(int pointX,int pointY) {
        Mark point = field[pointX][pointY];
        return point;
    }
}
