/**
 *
 * @author seanmarino
 */
public class Sport implements Activity
{
    public String name;
    
    @Override
    public String scheduleType()
    {
        return "Art";
    }
    
    public Sport (String name)
    {
        this.name = name;
    }
    
    @Override
    public String activityType()
    {
        switch(name)
        {
            case "Photography":
            case "Horticulture":
                return "Crafts";
            case "Baseball":
            case "Gymnastics":
            case "Swimming":
                return "Athletics";
            default:
                return "Invalid Input";
        }
    }
    @Override
    public String location()
    {
        return new Location(name).Venue();
    }

    @Override
    public String name() {
       return name;
    }

   
}
