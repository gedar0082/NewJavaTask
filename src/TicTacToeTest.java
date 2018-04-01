import org.junit.jupiter.api.Test;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    @Test
    void addMark() {
//тест на добавление крестика
        TicTacToe testField1 = new TicTacToe(3);
        testField1.addMark(0,0, TicTacToe.Mark.X);
        TicTacToe.Mark[][] result1 = new TicTacToe.Mark[3][3];
        result1[0][0] = TicTacToe.Mark.X;
        assertArrayEquals(result1,testField1.getField());

        //тест на добавление нолика
        TicTacToe testField2 = new TicTacToe(3);
        testField2.addMark(0,0, TicTacToe.Mark.X);
        TicTacToe.Mark[][] result2 = new TicTacToe.Mark[3][3];
        result2[0][0] = TicTacToe.Mark.X;
        assertArrayEquals(result2, testField2.getField());

        //тест на заполненность клетки
        TicTacToe testField3 = new TicTacToe(3);
        testField3.addMark(0,0, TicTacToe.Mark.X);
        testField3.addMark(0,0, TicTacToe.Mark.X);
        TicTacToe.Mark[][] result3 = new TicTacToe.Mark[3][3];
        result3[0][0] = TicTacToe.Mark.X;
        assertArrayEquals(result3, testField3.getField());

        TicTacToe testField4 = new TicTacToe(3);
        assertThrows(ArrayIndexOutOfBoundsException.class,() -> testField1.addMark(4,4, TicTacToe.Mark.X));

    }

    @Test
    void removeMark() {
        TicTacToe testField1 = new TicTacToe(3);
        testField1.addMark(0,0, TicTacToe.Mark.X);
        testField1.removeMark(0,0);
        TicTacToe.Mark[][] result1 = new TicTacToe.Mark[3][3];
        assertArrayEquals(result1, testField1.getField());

    }

    @Test
    void getLongest() {
        //testHor
        TicTacToe testField = new TicTacToe(3);
        testField.addMark(0,0, TicTacToe.Mark.X);
        testField.addMark(0,1, TicTacToe.Mark.X);
        testField.addMark(0,2, TicTacToe.Mark.X);
        testField.addMark(2,0, TicTacToe.Mark.X);
        testField.addMark(2,1, TicTacToe.Mark.X);
        assertEquals(3, testField.getLongest());

        //testMain
        TicTacToe testField1 = new TicTacToe(3);
        testField1.addMark(0,0, TicTacToe.Mark.X);
        testField1.addMark(0,1, TicTacToe.Mark.X);
        testField1.addMark(1,0, TicTacToe.Mark.X);
        testField1.addMark(1,1, TicTacToe.Mark.X);
        testField1.addMark(2,2, TicTacToe.Mark.X);
        assertEquals(3, testField1.getLongest());

        //testSecondary
        TicTacToe testField2 = new TicTacToe(3);
        testField2.addMark(0,1, TicTacToe.Mark.X);
        testField2.addMark(0,2, TicTacToe.Mark.X);
        testField2.addMark(1,1, TicTacToe.Mark.X);
        testField2.addMark(1,2, TicTacToe.Mark.X);
        testField2.addMark(2,0, TicTacToe.Mark.X);
        assertEquals(3, testField1.getLongest());


        //testVer
        TicTacToe testField3 = new TicTacToe(3);
        testField3.addMark(0,0, TicTacToe.Mark.X);
        testField3.addMark(1,0, TicTacToe.Mark.X);
        testField3.addMark(2,0, TicTacToe.Mark.X);
        testField3.addMark(0,1, TicTacToe.Mark.X);
        testField3.addMark(1,1, TicTacToe.Mark.X);
        assertEquals(3, testField1.getLongest());


        TicTacToe testField4 = new TicTacToe(5);
        testField4.addMark(0,0, TicTacToe.Mark.X);
        testField4.addMark(0,1, TicTacToe.Mark.X);
        testField4.addMark(0,2, TicTacToe.Mark.X);
        testField4.addMark(0,3, TicTacToe.Mark.X);
        testField4.addMark(0,4, TicTacToe.Mark.X);
        testField4.addMark(1,1, TicTacToe.Mark.X);
        testField4.addMark(2,2, TicTacToe.Mark.X);
        testField4.addMark(3,3, TicTacToe.Mark.X);
        testField4.addMark(3,2, TicTacToe.Mark.X);
        testField4.addMark(4,2, TicTacToe.Mark.X);
        assertEquals(5, testField4.getLongest());
    }

}