import javafx.util.Pair;

import java.util.*;

public class Solution2 implements Solution {
    @Override
    public char[][] solveSudoku(char[][] board) {
        Map<Pair<Integer,Integer>, Set<Character>> map = new HashMap<>();
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>((p1, p2)->map.get(p1).size()-map.get(p2).size());
        Stack<char[][]> stack = new Stack<>();
        stack.push(board);
        while (!stack.isEmpty()) {
            char[][] curr = stack.pop();
            print(curr);
            map.clear();
            for (int i = 0; i < curr.length; i++) {
                for (int j = 0; j < curr.length; j++) {
                    if (curr[i][j] == '.') {
                        Set<Character> cand = findCandidates(curr, i, j);
                        map.put(new Pair<>(i, j), cand);
                    }
                }
            }

            if (map.isEmpty()) {
                if (isValid(curr)) {
                    return curr;
                } else {
                    continue;
                }
            }

            pq.clear();
            pq.addAll(map.keySet());
            if (!pq.isEmpty() && map.get(pq.peek()).size() == 1) {
                while (!pq.isEmpty() && map.get(pq.peek()).size() == 1) {
                    Pair<Integer, Integer> p = pq.remove();
                    curr[p.getKey()][p.getValue()] = map.get(p).iterator().next();
                }
                stack.push(curr);
            } else {
                Pair<Integer, Integer> p = pq.remove();
                for (char ch : map.get(p)) {
                    char[][] board_copy = copyTo(curr);
                    board_copy[p.getKey()][p.getValue()] = ch;
                    if (isValid(board_copy)) {
                        stack.push(board_copy);
                    }
                }
            }
        }

        return new char[0][];
    }

    private char[][] copyTo(char[][] board) {
        char[][] copy = new char[board.length][];
        for (int i = 0; i < board.length; i++) {
            copy[i] = Arrays.copyOf(board[i], board.length);
        }
        return copy;
    }

    private boolean isValid(char[][] board) {
        Set<Character> found = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            found.clear();
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    if (!found.contains(board[i][j])) {
                        found.add(board[i][j]);
                    } else {
                        return false;
                    }
                }
            }
        }

        for (int j = 0; j < board.length; j++) {
            found.clear();
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] != '.') {
                    if (!found.contains(board[i][j])) {
                        found.add(board[i][j]);
                    } else {
                        return false;
                    }
                }
            }
        }

        for (int m = 0; m < 3; m++) {
            for (int n = 0; n < 3; n++) {
                found.clear();
                for (int i = m*3; i < (m+1)*3; i++) {
                    for (int j = n*3; j < (n+1)*3; j++) {
                        if (board[i][j] != '.') {
                            if (!found.contains(board[i][j])) {
                                found.add(board[i][j]);
                            } else {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    private Set<Character> findCandidates(char[][] board, int row, int col) {
        Set<Character> result = new HashSet<>(Arrays.asList('1','2','3','4','5','6','7','8','9'));
        for (int i = 0; i < board.length; i++) {
            result.remove(board[i][col]);
        }

        for (int j = 0; j < board.length; j++) {
            result.remove(board[row][j]);
        }

        for (int i = row/3*3; i < (row/3+1)*3; i++) {
            for (int j = col/3*3; j < (col/3+1)*3; j++) {
                result.remove(board[i][j]);
            }
        }
        return result;
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
