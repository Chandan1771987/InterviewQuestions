public class BinaryCode {


    public int[] intArray = {};
    public int[] decodedString = {};
    public String temp1 = "", temp2 = "";

    public String[] decode(String message) {

        temp1 = encodeStringWithZeroOrOne(0, message);
        temp2 = encodeStringWithZeroOrOne(1, message);
        System.out.println("Result1 : " + temp1 + "  Result2  : " + temp2);
        return new String[]{temp1, temp2};
    }


    public int[] stringToIntArray(String message) {
        int i = 0;
        intArray = new int[message.length()];
        for (char c : message.toCharArray()) {
            intArray[i] = Character.digit(c, 10);
            i++;
        }
        return intArray;
    }


    public String encodeString(int[] message) {

        int[] encodedMsg = new int[message.length];
        encodedMsg[0] = message[0] + message[1];
        String temp = "" + encodedMsg[0];
        for (int i = 1; i < message.length - 1; i++) {
            encodedMsg[i] = message[i - 1] + message[i] + message[i + 1];
            temp += encodedMsg[i];
        }
        encodedMsg[message.length - 1] = message[message.length - 2] + message[message.length - 1];
        temp += encodedMsg[message.length - 1];

        return temp;
    }


    public String encodeStringWithZeroOrOne(int startingElement, String message) {
        String temp3 = "";
        intArray = stringToIntArray(message);
        if (message.length() > 1 && intArray[0] >= 2 && startingElement == 0) {
            temp3 = "NONE";
            return temp3;
        }
        else if (message.length() == 1) {

            if (intArray[0] == 1) {

                if (startingElement == 0) {
                    temp3 = "NONE";
                    return temp3;
                } else if (startingElement == 1) {
                    temp3 = "1";
                    return temp3;
                }
            }
            else if (intArray[0] == 0) {
                temp3 = (startingElement == 1) ? "NONE" : "0";
            }
            else if(intArray[0]>=2){
                temp3="NONE";
            }
        }

        else if ((message.length() > 1) || (message.length() == 1 && intArray[0] <= 1)) {
            decodedString = new int[message.length()];
            decodedString[0] = startingElement;
            decodedString[1] = intArray[0] - decodedString[0];
            String appendingStartingCharacter = (startingElement == 0) ? "0" : "1";
            temp3 += appendingStartingCharacter + decodedString[1];
            for (int m = 2; m < intArray.length; m++) {
                decodedString[m] = intArray[m - 1] - (decodedString[m - 2] + decodedString[m - 1]);
                if (decodedString[m] <= 1 && decodedString[m] >= 0) {
                    temp3 += decodedString[m];
                    continue;
                } else {
                    temp3 = "NONE";
                    break;
                }
            }

            if (!temp3.equalsIgnoreCase("none")) {

                String temp = encodeString(stringToIntArray(temp3));
                System.out.println("Encoded String :" + temp);
                System.out.println("Original String :" + message);
                if (!message.equalsIgnoreCase(temp)) {
                    temp3 = "NONE";
                }
            }
            return temp3;
        } else
            temp3 = "NONE";
        return temp3;

    }
}