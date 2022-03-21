// String Replace (basic)

// Given an original string input, and two strings S and T, from left to right replace all occurrences of S in input with T.

// Assumptions

// input, S and T are not null, S is not empty string
// Examples

// input = "appledogapple", S = "apple", T = "cat", input becomes "catdogcat"
// input = "laicode", S = "code", T = "offer", input becomes "laioffer"


public class Solution {
  public String replace(String input, String source, String target) {
    // Write your solution here
    if (input == null || input.length() == 0 || source.length() == 0 || input.length() == 0) {
      return input;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < input.length(); i++) {
      if (i > input.length() - source.length()) {
        sb.append(input.charAt(i));
        continue;
      }

      for (int j = 0; j < source.length(); j++) {
        if (input.charAt(i + j) != source.charAt(j)) {
          sb.append(input.charAt(i));
          break;
        }
        if (j == source.length() - 1) {
          sb.append(target);
          i += j;
        }
      }
    }

    return sb.toString();
  }
}
