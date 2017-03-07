
public class DiskJockey {
    SongComponent songList;
    
    public DiskJockey(SongComponent newSongList)
    {
        songList = newSongList;
    }
    
    public void getSongList()
    {
        songList.displaySongInfo();
    }
    
}
