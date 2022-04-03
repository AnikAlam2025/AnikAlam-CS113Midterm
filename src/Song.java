//similar to term class of polynomial
//just make a simple song object to use with only the song title
public class Song {
    //variables
    private String songName;
    private static final String DEFAULT_SONG_NAME = "Come a Little Closer";

    /**
     * Full constructor for Song, takes in song name and sets this songName to input
     * @param songName
     */
    public Song(String songName) {
        this.songName = songName;
    }

    /**
     * Copy constructor for Song, will print out an error statement if data is null
     * @param original
     */
    public Song(Song original) {
        if (original == null) {
            System.out.println("Null data given to song constructor");
        } else {
            this.setAll(original.songName);
        }
    }

    /**
     * setter for song name
     * @param songName
     */
    public void setSongName(String songName) {
        this.songName = songName;
    }

    /**
     * getter for song name
     * @return
     */
    public String getSongName() {
        return songName;
    }

    /**
     * set all method(really only song name)
     * @param songName
     */
    public void setAll(String songName) {
        this.setSongName(songName);
    }

    /**
     * toString method just prints out a statement with the current song
     * @return
     */
    public String toString() {
        return songName;
    }
}
