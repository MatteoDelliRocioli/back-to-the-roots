package delli;

import java.util.HashSet;
import java.util.Set;

public class Main {

  /**
   * https://leetcode.com/problems/word-search/
   * */
  public static void main(String[] args) {
    //first we need to get the first character by looping into the matrix
    // that could take O(n^2) time complexity and O(1) space complexity

    //once we found a potential first valid char for the target word, then we
    // look for its neighbours searching for the next char till we got the
    // resulting word or the word has not been found

    //take note of each position you already have visited in a set

    Main main = new Main();

    char[][] board = new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
    String word = "ABCCED";

    System.out.println(main.exist(board, word));
  }

  public boolean exist(char[][] board, String word) {
    int columnLength = board.length;
    int rowLength = board[0].length;

    for (int i = 0; i < columnLength; i++) {
      for (int j = 0; j < rowLength; j++) {
        if (board[i][j] == word.charAt(0)) { //find word first char
//          System.out.println(String.format("found char: %c", word.charAt(0)));
          //look for neighbours
          return searchingWord(board, i, j, word, 0);
        }
      }
    }
    return false;
  }

  public static boolean searchingWord(char[][] board, int column, int row, String word, int count) {

    // word found, return true
    if (word.length() == count) {
      return true;
    }

    // if we go out boundaries or the current char is not equal to the next char
    // to be found in the word, we return false
    if (column < 0 || row < 0 ||
        column >= board.length || row >= board[0].length ||
        word.charAt(count) != board[column][row]) {
      return false;
    }

    // setting the valid char with a placeholder to not go back on already seen
    // chars
    board[column][row] = '-';
    // going in the for directions (DFS) till we navigated all the board or we
    // found the word
    boolean result =
      searchingWord(board, column + 1, row, word, count + 1) ||
        searchingWord(board, column - 1, row, word, count + 1) ||
        searchingWord(board, column, row + 1, word, count + 1) ||
        searchingWord(board, column, row - 1, word, count + 1);

    return result;
  }
}
