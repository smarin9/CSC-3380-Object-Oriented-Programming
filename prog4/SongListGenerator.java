/********************************************/
/*          Schedule Builder                */
/*             Sean Marino                  */
/*       CSC 3380_89 Section 1              */
/*             Assignment 4                 */
/* Instructor: Coretta Douglas              */
/* Program due date:  April 26, 2016         */   
/********************************************/
/*
PROBLEM SPECIFICATION: Program builds music inventory and sorts by genre and album
PROBLEM ANALYSIS: Program organizes the music based on album and genre
IMPLEMENTATION DIRECTIONS: Program simply builds the inventory without any inputs
*/

public class SongListGenerator 
{
    public static void main(String[] args)
    {
        SongComponent hiphopMusic = new SongGroup("Hip Hop"," - A subcultural movement that formed during the early 1970s\n-------");
        
        SongComponent dubstepMusic = new SongGroup("\nDubstep"," - Emerged in the late 1990s as a development involving borken beat and drum and bass\n-------");
        
        SongComponent grungeMusic = new SongGroup("\nGrunge"," - A subgenre of alternative rock that emerged in the mid-1980s in the American State of Washington\n-------");
        
        SongComponent everySong = new SongGroup("Disc Jockey Music Inventory","\n***************************");
        
        
        everySong.add(hiphopMusic);
        
        hiphopMusic.add(new Song("Life of Pablo", "Pt. 2 feat. Desiigner", "Kanye West", 2016));
        hiphopMusic.add((new Song("Enter the Wu-Tang-Clan 36 Chambers", "C.R.E.A.M.", "Wu Tang Clan", 2007)));
        
        hiphopMusic.add(dubstepMusic);
        
        dubstepMusic.add(new Song("FreeStyle", "Human", "Bassnectar", 2012));
        dubstepMusic.add(new Song("Bangarang EP", "Bangarang", "Skrillex", 2011));
        
        everySong.add(grungeMusic);
        
        grungeMusic.add(new Song("Nevermind" , "Smells Like Teen Spirit", "Nirvana", 1991));
        grungeMusic.add(new Song("Black Gives Way to Blue", "Check My Brain", "Alice in Chains", 2009));
        
        DiskJockey seanMarino = new DiskJockey(everySong);
        seanMarino.getSongList();
    }    
        
        
    
}
