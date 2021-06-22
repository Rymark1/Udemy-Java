import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String title;
    private String artist;
    private ArrayList<Song> album;

    public Album(String title, String artist){
        this.title = title;
        this.artist = artist;
        album = new ArrayList<Song>();
    }

    public boolean addSong(String title, double duration){
        if (findSong(title) != null)
            return false;
        else{
            this.album.add(new Song(title,duration));
            return true;
        }
    }

    private Song findSong(String title){
        for (Song song : album) {
            if (song.getTitle().equals(title)) {
                return song;
            }
        }
        return null;
    }

    public boolean addToPlaylist(int trackNbr, LinkedList<Song> playlist){
        int idx = trackNbr - 1;
        if ((idx >= 0) && (idx <= this.album.size())){
            playlist.add(this.album.get(idx));
            return true;
        }
        System.out.println("This album does not have a track " + trackNbr);
        return false;
    }

    public boolean addToPlaylist(String title, LinkedList<Song> playlist){
        Song song = findSong(title);
        if (findSong(title) != null){
            playlist.add(song);
            return true;
        }
        System.out.println("This album does not have a track titled " + title);
        return false;
    }
}
