/**
 * Created by 1 on 14.02.2017.
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

        /*for (int i = 0; i < splittingString.length ; i++) {
            System.out.println(splittingString[i]);
        }*/

        return splittingString;
    }
}
