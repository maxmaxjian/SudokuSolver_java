import javafx.util.Pair;

import java.util.*;

public class Solution1 implements Solution {
    @Override
    public char[][] solveSudoku(char[][] board) {

        List<Character> chars = Arrays.asList('1','2','3','4','5','6','7','8','9');

        Map<Pair<Integer,Integer>, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    Set<Character> cands = new HashSet<>(chars);
                    elim(board, i, j, cands);
                    map.put(new Pair<>(i,j), cands);
                }
            }
        }
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>((o1, o2) -> map.get(o1).size() - map.get(o2).size());
        pq.addAll(map.keySet());

        while (!map.isEmpty() && map.get(pq.peek()).size() == 1) {
            while (!pq.isEmpty() && map.get(pq.peek()).size() == 1) {
                Pair p = pq.remove();
                board[(int)p.getKey()][(int)p.getValue()] = map.get(p).iterator().next();
            }

            map.clear();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j] == '.') {
                        Set<Character> cands = new HashSet<>(chars);
                        elim(board, i, j, cands);
                        map.put(new Pair<>(i,j), cands);
                    }
                }
            }

            pq.clear();
            pq.addAll(map.keySet());
            print(board);
        }

        return new char[0][];
    }

    private void elim(char[][] board, int row, int col, Set<Character> cands) {
        for (int i = 0; i < board.length; i++) {
            if (cands.contains(board[i][col])) {
                cands.remove(board[i][col]);
            }
        }

        for (int j = 0; j < board.length; j++) {
            if (cands.contains(board[row][j])) {
                cands.remove(board[row][j]);
            }
        }

        for (int i = row/3*3; i < (row/3+1)*3; i++) {
            for (int j = col/3*3; j < (col/3+1)*3; j++) {
                if (cands.contains(board[i][j])) {
                    cands.remove(board[i][j]);
                }
            }
        }
    }

    private void print(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
