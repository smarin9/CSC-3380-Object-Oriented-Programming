/**
 *
 * @author seanmarino
 */
public class Location 
{
    String activity;
    
    public Location(String activity)
    {
        this.activity = activity;
    }
    public String Venue()
    {
        switch (activity)
        {
            case "Baseball" : return "Outside - Field";
            case "Creative Dance" :
            case "Gymnastics" : return "(Inside - Gym)";
            case "Swimming" :
            case "Synchronized Swimming" : return "(Outside = Pool)";
            case "Sewing" :
            case "Painting" : return "(Inside - Hobby Hut)";
            case "Photography" :
            case "Horticulture" : return "(Outside - Nature)";
            default : return "Location Undetermined";
        }
    }
    
}
