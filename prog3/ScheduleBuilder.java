/**
 *
 * @author seanmarino
 */
public class ScheduleBuilder 
{
    public Schedule ArtBuilder(String firstactivity, String secondactivity) throws Error
    {
        Schedule schedule = new Schedule();
        schedule.addItem(new Art(firstactivity));
        schedule.addItem(new Art(secondactivity));
        return schedule;
    }
    
    public Schedule SportScheduleBuilder(String firstactivity, String secondactivity) throws Error
    {
        Schedule schedule = new Schedule();
        schedule.addItem(new Sport(firstactivity));
        schedule.addItem(new Sport(secondactivity));
        return schedule;
    }
    
}
