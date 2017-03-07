/********************************************/
/*          Schedule Builder                */
/*             Sean Marino                  */
/*       CSC 3380_89 Section 1              */
/*             Assignment 3                 */
/* Instructor: Coretta Douglas              */
/* Program due date:  April 5, 2016         */   
/********************************************/
/*
PROBLEM SPECIFICATION: Program builds a schedule using two activities
PROBLEM ANALYSIS: Program sorts the activities into two seperate schedules "Art or "Sport" and displays activity, type, and location.
IMPLEMENTATION DIRECTIONS: Program simply builds the schedule without any inputs
*/
public class ScheduleBuilderDemo 
{
    public static void main(String[] args) throws Error 
    {
        ScheduleBuilder scheduleBuilder = new ScheduleBuilder();
        
        System.out.println("Art Schedule Builder for Camp Standing Pines\n");
        Schedule artSchedule = scheduleBuilder.ArtBuilder("Creative Dance", "Painting");
        artSchedule.showSchedule();
        artSchedule = scheduleBuilder.ArtBuilder("Synchronized Swimming", "Sewing");
        artSchedule.showSchedule();
        System.out.println();
        System.out.println("Sport Schedule Builder for Camp Standing Pines\n");
        Schedule sportSchedule = scheduleBuilder.SportScheduleBuilder("Swimming", "Horticulture");
        artSchedule.showSchedule();
        sportSchedule = scheduleBuilder.SportScheduleBuilder("Swimming", "Sewing");
        artSchedule.showSchedule();
    }
    
}
