import java.util.TreeSet;

public class Birthday {
    private int monthDate;

    public String getNext(String date, String[] birthdays) {
        TreeSet<Integer> dates = new TreeSet<Integer>();
        if (birthdays.length == 1)
            return birthdays[0].split(" ")[0];
        for (String temp : birthdays) {
                monthDate = Integer.parseInt(temp.split(" ")[0].split("/")[0])*100 + Integer.parseInt(temp.split(" ")[0].split("/")[1]);
            dates.add(monthDate);
        }
        int birthDay = findNext(date, dates);
        if (birthDay < 1000){
            return "0" + String.valueOf(birthDay).substring(0, 1) + "/" + String.valueOf(birthDay).substring(1, 3);
        }
        return String.valueOf(birthDay).substring(0, 2) + "/" + String.valueOf(birthDay).substring(2, 4);
    }

    private Integer findNext(String date, TreeSet<Integer> dates) {
        int givenDate = Integer.parseInt(date.split("/")[0] + date.split("/")[1]);
        for (Integer integer : dates) {
            if (integer == givenDate || integer > givenDate)
                return integer;
        }
        return 0;
    }

}

