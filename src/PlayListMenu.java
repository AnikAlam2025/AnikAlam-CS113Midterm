import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PlayListMenu {
    ArrayList<Song> playList;
    ArrayList<Song> selectedSongs = new ArrayList<>();

    class SelectedSongs {
        public void storeSelectedSongs(Song inputSong) {
            selectedSongs.add(inputSong);
            System.out.println("Currently selected songs: "  + selectedSongs);
        }
    }

    /**
     * Constructor to create a new arraylist for the play list
     */
    public PlayListMenu() {
        playList = new ArrayList<>();
    }

    /**
     * Copy Constructor
     * @param original
     */
    public PlayListMenu(PlayListMenu original) {
        playList = new ArrayList<>();
        for (int i = 0; i < original.getNumSongs(); i++) {
            this.addSong(new Song(original.getSong(i)));
        }

    }

    //getter methods for playlist size and getting the song itself
    public int getNumSongs() {
        return playList.size();
    }

    public Song getSong(int i) {
        return playList.get(i);
    }


    /**
     * method will take the previously selected song played and play it again
     * Taking the last song that was input as the selected song
     */
    public void playLastSelectedSong() {
        Song lastPlayedSong;
        lastPlayedSong = getSong(playList.size() - 1);
        System.out.println("Playing last selected song: " + lastPlayedSong);
    }

    /**
     * method overwrites the last playing song
     */
    public void overwriteLastPlayingSong(int index) {
        Song placeholder = playList.get(index - 1);
        playList.remove(index - 1);
        playList.add(placeholder);
        System.out.println("Currently playing " + placeholder);
    }

    /**
     * method takes an int and playlist and includes that number of songs into the new playlist
     */
    public void includeSelectedSongs() {
        for (int i = 0; i < selectedSongs.size(); i++) {
            Song placeholderSong = new Song(selectedSongs.get(i));
            playList.add(placeholderSong);
        }
        System.out.println(playList);
    }

    /**
     * method adds a song to the playlist
     * @param inputSong
     */
    public void addSong(Song inputSong) {
        playList.add(inputSong);
        System.out.println("Song added: " + inputSong);
        System.out.println(playList);
    }

    /**
     * Method takes an int value and removes that many songs from the playlist invoking the method
     * @param numberSongsRemoved
     */
    public void removeSelectedSongs(int numberSongsRemoved) {
        for (int i = 0; i < numberSongsRemoved; i++) {
            System.out.println("Removed: " + playList.get(0));
            playList.remove(0);
        }
        System.out.println(playList);
    }

    /**
     * List of songs should be displayed for user, user will selected position of desired song
     * that song will be removed
     * @param inputSong
     */
    public void removeSong(int inputSong) {
        playList.remove(inputSong - 1);
        System.out.println("Song removed: " + inputSong);
        System.out.println(playList);
    }

    /**
     * method shuffles the elements in the arraylist
     */
    public void shuffle() {
        Collections.shuffle(playList);
        System.out.println(playList);
    }

    /**
     * method will take the last played song on the list(last element) and "loop" it however many times the user wishes it to
     * it will add that last played song to the list or "song queue" however many times
     */
    public void loopLastPlayed(int numLoop) {
        Song loopedSong;
        loopedSong = playList.get(playList.size() - 1);
        System.out.println(loopedSong + " is currently being looped");
        for (int i = 0; i < numLoop; i++) {
            playList.add(loopedSong);
        }
        System.out.println(playList);
    }

    /**
     * method will take all songs, and re-add each of them to the arraylist to "loop" them
     */
    public void loopAllSongs() {
        int playlistSize = playList.size();
        for (int i = 0; i < playlistSize; i++) {
            playList.add(playList.get(i));
        }
        System.out.println(playList);
    }

    /**
     * method will take in however many times the user wants to loop these songs and will add each song from the selected
     * song list to the main playlist accordingly
     * @param numLoop
     */
    public void loopSelectedSong(int numLoop) {
        for (int i = 0; i < numLoop; i++) {
            playList.addAll(selectedSongs);
        }
    }

    public static void main(String[] args) {
        PlayListMenu testPlayListMenu = new PlayListMenu();
        ArrayList<Song> tempPlaylist = new ArrayList<>();
        PlayListMenu o = new PlayListMenu();
        PlayListMenu.SelectedSongs i = o.new SelectedSongs();

        Scanner menuChoice = new Scanner(System.in);
        Scanner intInput = new Scanner(System.in);
        String input = "default";
        int position;


        while(input != "12") {
            System.out.println("1)Add song\n2)Add selected songs\n3)Remove Song\n4)Remove set of songs\n5)Play last selected song\n" +
                    "6)Overwrite last played song\n7)Shuffle\n8)Loop last played song\n9)Loop all\n10)Loop selected\n11)Highlight songs\n12)Exit");
            input = menuChoice.nextLine();

            switch (input) {
                case "1": //Add a song
                    System.out.println("Enter a song");
                    input = menuChoice.nextLine();
                    testPlayListMenu.addSong(new Song(input));
                    break;
                case "2": //Add selected songs
                    testPlayListMenu.includeSelectedSongs();
                    break;
                case "3": //Remove a song
                    System.out.println("Enter the position of the song you want to remove: " + testPlayListMenu.playList);
                    position = intInput.nextInt();
                    testPlayListMenu.removeSong(position);
                    break;
                case "4": //Remove a set of songs
                    System.out.println("How many songs do you want to remove? " + testPlayListMenu.playList);
                    position = intInput.nextInt();
                    testPlayListMenu.removeSelectedSongs(position);
                    break;
                case "5": //Play last selected
                    testPlayListMenu.playLastSelectedSong();
                    break;
                case "6": //Overwrite last played
                    System.out.println("Chose a song to overwrite the last: " + testPlayListMenu.playList);
                    position = intInput.nextInt();
                    testPlayListMenu.overwriteLastPlayingSong(position);
                    break;
                case "7": //Shuffle
                    testPlayListMenu.shuffle();
                    break;
                case "8": //Loop last played
                    System.out.println("How many times do you want to loop the last played song?");
                    position = intInput.nextInt();
                    testPlayListMenu.loopLastPlayed(position);
                    break;
                case "9": //Loop all
                    testPlayListMenu.loopAllSongs();
                    break;
                case "10": //Loop selected
                    System.out.println("How many times do you want to loop the last played song?");
                    position = intInput.nextInt();
                    testPlayListMenu.loopSelectedSong(position);
                    break;
                case "11": //Select a song
                    System.out.println("Select a song to highlight: " + testPlayListMenu.playList);
                    position = intInput.nextInt();
                    Song selectedSong = testPlayListMenu.playList.get(position - 1);
                    i.storeSelectedSongs(selectedSong);
                    break;
                case "12":
                    System.exit(0);
            }
        }
    }
}
