import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Album album1=new Album("Moosa","Sidhu Moosewala");  // moosa is a album name and Sidhu Moosewala is a artist name.
        album1.addSongtoAlbum("295",5.04);
        album1.addSongtoAlbum("LastRide",4.05);
        album1.addSongtoAlbum("So high",5.50);

        Album album2=new Album("VP's Songs","Vijay Prakhash");
        album2.addSongtoAlbum("Rajakumar",5.00);
        album2.addSongtoAlbum("Kavithe",3.34);
        album2.addSongtoAlbum("Jhi ho",6.00);

        System.out.println(album1.findSong("Rajakumar"));
        System.out.println(album1.findSong("295"));

        LinkedList<Song> playlist=new LinkedList<>();

        album1.addToPlayListFromAlbum("Rajakumar",playlist);             //checking

        //here i add song to playlist.

        album2.addToPlayListFromAlbum("Rajakumar",playlist);
        album1.addToPlayListFromAlbum("295", playlist);
        album1.addToPlayListFromAlbum("LastRide",playlist);
        album2.addToPlayListFromAlbum("Kavithe",playlist);
        album2.addToPlayListFromAlbum("Jhi ho",playlist);
        album1.addToPlayListFromAlbum(1,playlist);

       play(playlist); // this function is helps us to play my playlist.
    }
    public static void play(LinkedList<Song> playlist){   // this function is helps us to play my playlist.
        Scanner sc=new Scanner(System.in);
        ListIterator<Song> itr=playlist.listIterator(); // initialy itr point to start of the list

        boolean isForward=false; // if i move to previous next or next to previous

        if(playlist.size()>0){
            System.out.println("Currently playing");
            System.out.println(itr.next());    //here first song will be playing (itr jump to next node gap).
            isForward=true;
        }
        else{
            System.out.println("Playlist is empty");
            return;
        }

        //here i perform next,previous,delete a song
//        System.out.println("Select your choice");
        printMenu();                       //it will print all the info

       boolean quite=false;
       while(!quite){
           int choice =sc.nextInt();
           switch(choice){
               case 1:
                   if(isForward==false){
                       itr.next();
                       isForward=true;
                   }
                   if(itr.hasNext()){
                       System.out.println(itr.next());
                   }
                   else{
                       System.out.println("You have reached the end of playlist");
                       isForward=false;
                   }
                   break;
               case 2:
                   if(isForward==true){
                       itr.previous();
                       isForward=false;
                   }
                   if(itr.hasPrevious()){
                       System.out.println(itr.previous());
                   }
                   else{
                       System.out.println("Your are at the start of the PlayList");
                       isForward=true;
                   }
                   break;
               case 3:
                   if(isForward==true){
                       if(itr.hasPrevious())  // this line is optional
                       {
                           System.out.println(itr.previous());
                           isForward=false;
                       }
                       else{
                           System.out.println("Song doesn't exist");
                       }
                   }
                   else{
                       if(itr.hasNext()) {  //this line is optional
                           System.out.println(itr.next());
                           isForward=true;
                       }
                       else{
                           System.out.println("Song doesn't exist");
                       }
                   }

                   break;
               case 4:
                   printMenu();
                   break;
               case 5:
                   break;
               case 6:
                   printSongs(playlist); // this function print all the songs in playlist.
                   break;
               case 7:
                   quite=true;
                   break;

           }
       }
    }
    public static void printSongs(LinkedList<Song> playlist){
        for(Song songs:playlist){
            System.out.println(songs);
        }

    }
    public static void printMenu(){
        System.out.println("Select your choice");
        System.out.println("1-Play next song");
        System.out.println("2-Play previous song");
        System.out.println("3-Repeat the current song");
        System.out.println("4-Show menu again");
        System.out.println("5-Delete Current Song");
        System.out.println("6-Print all the songs in playlist");
        System.out.println("7-Exit");


    }

}