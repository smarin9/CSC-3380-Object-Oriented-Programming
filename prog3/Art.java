/**
 *
 * @author seanmarino
 */
public class Art implements Activity
{
    public String name;
    
    @Override
    public String scheduleType()
    {
        return "Art";
    }
    
    public Art (String name)
    {
        this.name = name;
    }
    
    @Override
    public String activityType()
    {
        switch(name)
        {
            case "Creative Dance":
            case "Synchronized Swimming":
                return "Athletics";
            case "Sewing":
            case "Painting":
                return "Crafts";
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
