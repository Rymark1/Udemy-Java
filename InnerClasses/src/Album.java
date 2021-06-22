import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String title;
    private String artist;
    private SongList songs;

    public Album(String title, String artist){
        this.title = title;
        this.artist = artist;
        this.songs = new SongList();
    }

    public boolean addSong(String title, double duration){
        return this.songs.add(new Song(title, duration));
    }

    public boolean addToPlaylist(int trackNbr, LinkedList<Song> playlist){
        Song checkedSong = this.songs.findSong(trackNbr);
        if (checkedSong != null){
            playlist.add(checkedSong);
        }
        System.out.println("This album does not have a track " + trackNbr);
        return false;
    }

    public boolean addToPlaylist(String title, LinkedList<Song> playlist){
        Song song = songs.findSong(title);
        if (songs != null){
            playlist.add(song);
            return true;
        }
        System.out.println("This album does not have a track titled " + title);
        return false;
    }

    private class SongList{
        private ArrayList<Song> songs;

        public SongList(){
            this.songs = new ArrayList<Song>();
        }

        public boolean add(Song song){
            if(songs.contains(song))
                return false;
            this.songs.add(song);
            return true;
        }

        private Song findSong(String title){
            for (Song song : this.songs) {
                if (song.getTitle().equals(title)) {
                    return song;
                }
            }
            return null;
        }

        public Song findSong(int trackNumber){
            int idx = trackNumber - 1;
            if ((idx >= 0) && (idx < songs.size())){
                return songs.get(idx);
            }
            return null;
        }
    }
}