import java.util.*;

public class TestCalendar {
   
   public static void main (String[] args) {
   
      Calendar c = Calendar.getInstance();
 
      c.set(2004,0,7,15,40);
      System.out.println("1. Set:          " + c.getTime());
      
      long day1 = c.getTimeInMillis();
      day1 += 1000*60*60;
      c.setTimeInMillis(day1);
      System.out.println("2. New hour:     " + c.get(c.HOUR_OF_DAY));
      
      c.add(c.DATE,35);
      System.out.println("3. Add 35 days:  " + c.getTime());
      
      c.roll(c.DATE,35);
      System.out.println("4. Roll 35 days: " + c.getTime());
      
      c.set(c.DATE,1);
      System.out.println("5. Set to 1:     " + c.getTime());
   }
}