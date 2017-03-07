
public class Song extends SongComponent {
    
    String albumName;
    String songName;
    String bandName;
    int releaseYear;
    
    public Song(String newAlbumName, String newSongName, String newBandName, int newReleaseYear)
    {
        albumName = newAlbumName;
        songName = newSongName;
        bandName = newBandName;
        releaseYear = newReleaseYear;
    }

    public String getAlbumName(){ return albumName; }
    @Override
    public String getSongName() { return songName; }
    @Override
    public String getBandName() { return bandName; }
    @Override
    public int getReleaseYear() { return releaseYear; }
    
    @Override
    public void displaySongInfo()
    {
        System.out.println(getAlbumName() + "\n");
        System.out.println("    " + getSongName() + " by " + getBandName() + " in " + getReleaseYear());
        System.out.println();
    }

            
}
