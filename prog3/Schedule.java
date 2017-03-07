/**
 *
 * @author seanmarino
 */
import java.util.ArrayList;
import java.util.List;
public class Schedule
{
    public List<Activity> items = new ArrayList<Activity>();
    
    public void addItem(Activity item) throws Error 
    {
        int firstcount = 0;
        int secondcount = 0;
        for (Activity check : items)
        {
            if (check.name() == item.name())
                throw new Error("Scheduling Error: This is a sport activity sechedule");
        }
        items.add(item);
        for (Activity check : items)
        {
           if (check.activityType() == "Crafts")
               firstcount++;
           else
               secondcount++;
           if (firstcount > 2 || secondcount > 2)
               throw new Error("Scheduling Error");
        }
    }
    
    public void showSchedule()
    {
        for (Activity item : items)
        {
            System.out.println("Activity : "+item.name()+"\nType : "+item.activityType()+"\nLocation : "+item.location());
            System.out.println();
        }
    }
    
    public void getActivity()
    {
        
    }
    
     
}
