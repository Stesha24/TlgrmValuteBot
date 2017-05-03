/**
 * Splitting string into string without [] and with line breaks.
 */
public class Splitter {
    public String[] split(String strForSplit) {
        char[] charArray = strForSplit.toCharArray();
        String splittingStr = "";

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '[' || charArray[i] == ']') {
                splittingStr += "";
            }
            else if (charArray[i] == ',' && charArray[i + 1] == ' ') {
                splittingStr += "\n";
            } else {
                splittingStr += charArray[i];
            }
        }

        String[] splittingString = splittingStr.split("\n");

        return splittingString;
    }
}
