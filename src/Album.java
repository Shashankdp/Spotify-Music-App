import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album { //Album is collection of songs.

    private String name;  // this is name of the album.
    private String artist;
    private List<Song> Songs; //instead of string i use Song as a datatype, And here i store the songs.

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.Songs = new ArrayList<>(); //here i allocate a memory and initially(here) it will be null and i will add songs after using function.
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return Songs;
    }

    public void setSongs(List<Song> songs) {
        Songs = songs;
    }

    //now i implement some functions,

    public void addSongtoAlbum(String title,double duration){
        Song s=new Song(title,duration);  // here i will create object of Song class.

        if(findSong(s.getTitle())==true){
            System.out.println("Song already present in album");
        }
        else{
            Songs.add(s); // here i will add song to list.
            System.out.println(title+" Song has been added");
        }
    }
    public boolean findSong(String title){
        for(Song s:Songs){
            if(s.getTitle().equals(title)){
                return true;
            }
        }
        return false;
    }

    //now i implement two more functions
    // here i use a polymorphism method
    public void addToPlayListFromAlbum(String title, LinkedList<Song> playlist){
        if(findSong(title)==true){    //                          |

            for(Song song : Songs){     // this for loop for ,to get song from song datatype arraylist(Song), becoz playlist datattype is Song.
                if(song.getTitle().equals(title)) {  // here i get song grom arrlst.
                    playlist.add(song);
                    System.out.println("Song has been added to your playlist");
                    break;
                }
            }
        }
        else{
            System.out.println("Song is not present in the album");
        }
        return;
    }

    public void addToPlayListFromAlbum(int trackNo, LinkedList<Song> playlist){
        int index=trackNo-1;
        if(index>=0 && index<Songs.size()){
            playlist.add(Songs.get(index));
            System.out.println("Song has been added to playlist");
        }
        else{
            System.out.println("Invalid track number");
        }
        return;
    }

}
