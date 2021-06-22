import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class MainPlaylist {

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {

        Album album = new Album("Stormbringer", "Deep Purple");
        album.addSong("Stormbringer", 4.6);
        album.addSong("Love don't mean a thing", 4.22);
        album.addSong("Holy man", 4.3);
        album.addSong("Hold on", 5.6);
        album.addSong("Lady double dealer", 3.21);
        album.addSong("You can't do it right", 6.23);
        album.addSong("High ball shooter", 4.27);
        album.addSong("The gypsy", 4.2);
        album.addSong("Soldier of fortune", 3.13);
        albums.add(album);

        album = new Album("For those about to rock", "AC/DC");
        album.addSong("For those about to rock", 5.44);
        album.addSong("I put the finger on you", 3.25);
        album.addSong("Lets go", 3.45);
        album.addSong("Inject the venom", 3.33);
        album.addSong("Snowballed", 4.51);
        album.addSong("Evil walks", 3.45);
        album.addSong("C.O.D.", 5.25);
        album.addSong("Breaking the rules", 5.32);
        album.addSong("Night of the long knives", 5.12);
        albums.add(album);


        LinkedList<Song> playlist = new LinkedList<>();
        albums.get(0).addToPlaylist(4, playlist);
        albums.get(1).addToPlaylist(0, playlist);
        albums.get(0).addToPlaylist(1, playlist);
        albums.get(0).addToPlaylist(2, playlist);
        albums.get(1).addToPlaylist(5, playlist);
        albums.get(1).addToPlaylist(8, playlist);

        play(playlist);

    }

    public static void play(LinkedList<Song> playlist) {
        if (playlist.isEmpty()) {
            System.out.println("The playlist is empty.");
            return;
        }
        boolean finished = false;
        boolean goingForward = true;
        Scanner scan = new Scanner(System.in);
        ListIterator<Song> iter = playlist.listIterator();

        while (!finished) {
            printMenu();
            int selection = scan.nextInt();
            scan.nextLine();

            switch (selection) {
                case 1:
                    finished = true;
                    break;
                case 2:
                    if (!goingForward) {
                        if (iter.hasNext())
                            iter.next();
                        goingForward = true;
                    }
                    if (iter.hasNext())
                        System.out.println("Playing " + iter.next().getTitle());
                    else
                        finished = true;
                    break;
                case 3:
                    if (goingForward) {
                        if (iter.hasPrevious())
                            iter.previous();
                        goingForward = false;
                    }
                    if (iter.hasPrevious())
                        System.out.println("Playing " + iter.previous().getTitle());
                    else
                        finished = true;
                    break;
                case 4:
                    if (goingForward) {
                        System.out.println("Playing " + iter.previous().getTitle());
                        goingForward = false;
                    } else {
                        System.out.println("Playing " + iter.next().getTitle());
                        goingForward = true;
                    }
                    break;
                case 5:
                    printSetList(playlist);
                    break;
                case 6:
                    if (playlist.size() > 0)
                        iter.remove();
                    if(iter.hasNext()) {
                        System.out.println("Now playing " + iter.next());
                    } else if(iter.hasPrevious()) {
                        System.out.println("Now playing " + iter.previous());
                    }
                    break;
            }
        }
    }

    public static void printMenu() {
        System.out.println("Playlist menu");
        System.out.println("1. Quit");
        System.out.println("2. Skip Forward a song");
        System.out.println("3. Skip backward a song");
        System.out.println("4. Replay song");
        System.out.println("5. List playlist songs");
        System.out.println("6. Delete Current Song");
        System.out.println("Please make a selection: ");
    }

    public static void printSetList(LinkedList<Song> playlist) {
        System.out.println("Set list");
        ListIterator<Song> i = playlist.listIterator();
        int j = 0;
        while (i.hasNext()) {
            System.out.println((j + 1) + ": " + i.next());
            j++;
        }
    }
}