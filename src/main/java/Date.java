import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Getting current date and previous date.
 */
public class Date {

    public String date() {

        Calendar dating = Calendar.getInstance();
        SimpleDateFormat formating = new SimpleDateFormat("dd/MM/YYYY");
        System.out.println( formating.format(dating.getTime()) );
        String date = formating.format(dating.getTime());
        return date;
    }

    public String prevDate() {
        Calendar dating = Calendar.getInstance();
        int day = dating.get(Calendar.DAY_OF_MONTH);
        int month = dating.get(Calendar.MONTH);
        int year = dating.get(Calendar.YEAR);

        if(month == 0){
            month = 11;
            year -= 1;
        } else {
            month -= 1;
        }

        if(month == 1 && (day == 31 || day == 30 || day == 29)) {
            day = 28;
        } else if ((month == 3 || month == 5 || month == 8 || month == 10)&& day==31){
            day = 30;
        }



        String date;
        if(month+1 <10 && day>=10) {
            date = day+"/"+"0"+(month+1)+"/"+year;
        } else if (month+1<10 && day<10){
            date = "0"+day+"/"+"0"+(month+1)+"/"+year;
        } else if(month>=10 && day<10) {
            date = "0"+day+"/"+(month+1)+"/"+year;
        } else {
            date = day+"/"+(month+1)+"/"+year;
        }

        return date;
    }
}
