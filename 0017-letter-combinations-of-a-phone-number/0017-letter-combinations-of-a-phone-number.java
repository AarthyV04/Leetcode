import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        Map<Character, String> digitToLetters = new HashMap<>();
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");
        backtrack(digits, 0, new StringBuilder(), result, digitToLetters);
        return result;
    }
    private void backtrack(String digits, int index, StringBuilder current, List<String> result, Map<Character, String> digitToLetters) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        char digit = digits.charAt(index);
        String letters = digitToLetters.get(digit);
        for (int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i));
            backtrack(digits, index + 1, current, result, digitToLetters);
            current.deleteCharAt(current.length() - 1); 
        }
    }
}