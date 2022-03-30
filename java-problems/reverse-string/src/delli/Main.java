package delli;

import java.util.ArrayList;
import java.util.List;

public class Main {

  /**
   * Given a string write a function that reverses it and returns it back
   *
   * E.i. "Hi My name is Matteo" should be
   *  "oettaM si eman yM iH"
   *
   * */
  public static void main(String[] args) {
    System.out.println(bruteForceApproach("Hi My name is Matteo"));
  }

  /**
   * Return a copy of the string copying each char from right to left
   * */
  public static String bruteForceApproach(String input) {

    StringBuilder sb = new StringBuilder();

    char[] inputChars = input.toCharArray();
    List<Character> resultChars = new ArrayList<>();

    for(int i = inputChars.length - 1; i >= 0; i--){
      resultChars.add(inputChars[i]);
    }

    return String.valueOf(resultChars);
  }
}
