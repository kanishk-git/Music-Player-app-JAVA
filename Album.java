import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    String name;
     String artist;
    private ArrayList<song> songs;

    public Album(String name, String artist )
    {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<song>();

    }

    public Album(){

    }

    public song findSong(String title)
    {
        for (song checkedSong : songs)
        {
            if(checkedSong.getTitle().equals(title)) return checkedSong;
        }

        return null;
    }

    public boolean addSong (String title, double duration){
        if(findSong(title) == null)
        {
            songs.add(new song(title, duration));
           // System.out.println(title + "successfully added to the list");
            return true;
        }

        else {
           // System.out.println(title + "Already exists in the list");
            return false;
        }
    }
    public boolean addToPlaylist (int trackNumber, LinkedList<song> Playlist){
        int index = trackNumber -1;
        if(index >0 && index <= this.songs.size()){
            Playlist.add(this.songs.get(index));
            return true;
        }

        else {
          //  System.out.println("this album has no tracknumber" + trackNumber);
            return false;
        }
    }

    public boolean addToPlayList(String title, LinkedList<song> PlayList){
            for (song checkedSong : this.songs){
                if(checkedSong.getTitle().equals(title))
                {
                    PlayList.add(checkedSong);
                    return true;
                }
            }

           // System.out.println(title + "there is no such song in the album");
            return false;
    }

}
