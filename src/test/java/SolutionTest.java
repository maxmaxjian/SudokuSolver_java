import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SolutionTest {
    private char[][] input;
    private char[][] expected;
    private Solution soln = new Solution2();

    public SolutionTest(char[][] input, char[][] output) {
        this.input = input;
        this.expected = output;
    }

    @Parameterized.Parameters
    public static Collection parameters() {
        return Arrays.asList(new Object[][]{
//                {
//                        new char[][]{
//                                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
//                                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//                                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//                                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//                                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//                                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//                                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//                        },
//                        null
//                },
//                {
//                        new char[][]{
//                                {'4', '.', '.', '.', '7', '.', '.', '.', '.'},
//                                {'8', '.', '5', '.', '.', '.', '4', '.', '.'},
//                                {'.', '9', '.', '1', '5', '.', '.', '.', '3'},
//                                {'.', '.', '4', '.', '.', '5', '.', '.', '8'},
//                                {'.', '.', '6', '.', '.', '.', '2', '.', '.'},
//                                {'1', '.', '.', '2', '.', '.', '9', '.', '.'},
//                                {'3', '.', '.', '.', '4', '2', '.', '7', '.'},
//                                {'.', '.', '7', '.', '.', '.', '6', '.', '4'},
//                                {'.', '.', '.', '.', '3', '.', '.', '.', '9'}
//                        },
//                        null
//                },
//                {
//                        new char[][]{
//                                ".76......".toCharArray(),
//                                "9.....67.".toCharArray(),
//                                "2.1.....8".toCharArray(),
//                                ".9.84....".toCharArray(),
//                                "5.4.2.7.1".toCharArray(),
//                                "....51.2.".toCharArray(),
//                                "8.....2.4".toCharArray(),
//                                ".23.....6".toCharArray(),
//                                "......51.".toCharArray()
//                        },
//                        null
//                },
//                {
//                    new char[][]{
//                            "8..4..63.".toCharArray(),
//                            ".4...8..7".toCharArray(),
//                            "...93....".toCharArray(),
//                            ".....6712".toCharArray(),
//                            "5.......4".toCharArray(),
//                            "1278.....".toCharArray(),
//                            "....94...".toCharArray(),
//                            "2..6...4.".toCharArray(),
//                            ".34..2..1".toCharArray()
//                    }, null
//                },
//                {
//                    new char[][]{
//                            "..921..6.".toCharArray(),
//                            "5...9...8".toCharArray(),
//                            "1....6..9".toCharArray(),
//                            "3.5......".toCharArray(),
//                            "..17.39..".toCharArray(),
//                            "......6.1".toCharArray(),
//                            "7..4....6".toCharArray(),
//                            "9...6...2".toCharArray(),
//                            ".6..597..".toCharArray()
//                    }, null},
                {
                    new char[][]{
                            ".8..3.6..".toCharArray(),
                            ".19..2...".toCharArray(),
                            "4.3...72.".toCharArray(),
                            "....28...".toCharArray(),
                            "9.......5".toCharArray(),
                            "...61....".toCharArray(),
                            ".24...8.9".toCharArray(),
                            "...2..51.".toCharArray(),
                            "..7.5..6.".toCharArray()
                    },
                        null
                }
        });
    }

    @Test
    public void testSolver() {
        assert(checkEquals(expected, soln.solveSudoku(input)));
    }

    private boolean checkEquals(char[][] expected, char[][] actual) {
        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected.length; j++) {
                if (expected[i][j] != actual[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}