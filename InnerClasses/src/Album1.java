import java.util.ArrayList;
import java.util.LinkedList;

public class Album1 {

    private String name;
    private String artist;
    private SongList songlist;

    public Album1(String name, String artist){
        this.name = name;
        this.artist = artist;
        songlist = new SongList();

    }

    public boolean addSong(String title, double duration){
        return songlist.add(new Song(title,duration));
        }

    public boolean addToPlayList(int trackNbr, LinkedList<Song> playlist){
        int idx = trackNbr - 1;
        Song song = songlist.findSong(trackNbr);
        if (song != null){
            playlist.add(song);
            return true;
        }
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playlist){
        Song song = songlist.findSong(title);
        if (song != null){
            playlist.add(song);
            return true;
        }
        return false;
    }

    public static class SongList{
        private ArrayList<Song> songs;

        public SongList() {
            this.songs = new ArrayList<Song>();
        }

        private boolean add(Song song){
            if (!songs.contains(song)){
                songs.add(song);
                return true;
            }
            return false;
        }

        private Song findSong(String title){
            for (Song song : songs){
                if (song.getTitle().equals(title))
                    return song;
            }
            return null;
        }

        private Song findSong(int trackNbr){
            int idx = trackNbr - 1;
            if ((idx >= 0) && (idx < songs.size()))
                return songs.get(idx);
            return null;
        }
    }
}