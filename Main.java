import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main (String[] args)
    {


        Album album = new Album( "ALbum1", "AC/DC");
        album.addSong("TNT", 4.5);
        album.addSong("Highway to hell", 3.5);
        album.addSong("ThunderStruck", 5.0);
        albums.add(album);

        album = new Album("Album2", "Eminem");

        album.addSong("Rap God", 4.5);
        album.addSong("Not afraid", 3.5);
        album.addSong("Lose Yourself", 4.5);

        albums.add(album);

        LinkedList<song> playList1 = new LinkedList<>();

        albums.get(0).addToPlayList("TNT", playList1);
        albums.get(0).addToPlayList("Highway to hell", playList1);
        albums.get(1).addToPlayList("Rap God", playList1);
        albums.get(1).addToPlayList("Lose Yourself", playList1);


        play(playList1);

    }

    private static void play(LinkedList<song> playlist)
    {
        try (Scanner  = new Scanner (System.in)) {
            boolean quit = false;
            boolean forward = true;

            ListIterator<song> listIterator = playlist.listIterator();


            if(playlist.size() == 0){
                System.out.println("This playlist has no song");
            }
            else {
                System.out.println("Now playing" + listIterator.next().toString());
                printMenu();
            }

            while (!quit)
            {
                int action = sc.nextInt();
                sc.nextLine();
            
                switch(action)
                {
                    case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;

                    case 1:
                    if (!forward)
                    {
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                    }

                    if (listIterator.hasNext())
                    {
                        System.out.println("Now Playing" + listIterator.next().toString());
                    }
                    else {
                        System.out.println("No song available, reached at the end of list");
                    }
                    break;

                    case 2:
                    if (!forward)
                    {
                        if(listIterator.hasPrevious())
                        {
                            listIterator.previous();
                        }

                        forward = false;
                    }

                    if (listIterator.hasPrevious())
                    {
                        System.out.println("Now Playin" +listIterator.previous().toString());
                    }
                    else {
                        System.out.println("We are the the first song");
                        forward = false;
                    }
                    break;

                    case 3:
                    if(!forward)
                    {
                        if(listIterator.hasPrevious()){
                            System.out.println("Now Playing" + listIterator.previous().toString());
                            forward = false;
                        }

                        else {
                            System.out.println("We are at the start of the list");
                        }
                    }

                    else {
                        if(listIterator.hasPrevious())
                        {
                            System.out.println("Now Playing" + listIterator.previous().toString());
                            forward = true;
                        }
                        else {
                            System.out.println("We are at the start of the list");

                        }
                    }
                    break;

                    case 4:
                    printList(playlist);
                    break;

                    case 5:
                    printMenu();
                    break;

                    case 6:
                    if(playlist.size() >0)
                    {
                        listIterator.remove();

                        if(listIterator.hasNext())
                        {
                            System.out.println("now playing" + listIterator.next().toString());
                        
                        }
                        else {
                            if(listIterator.hasPrevious())
                            {
                                System.out.println("now playing" +listIterator.previous().toString());
                            }
                        }
                    }
                }
            }
        }
    }

    private static void printMenu(){
        System.out.println("Available options\n press");
        System.out.println("0 - to quit\n" +   
                            "1- to play next song\n" + 
                            "2- to play previous song\n" +
                            "3- to replay current song\n" +
                            "4- list of all songs\n" +
                            "5- print all available options\n" +
                            "6- delete current song");


                                     
    }

    private static void printList(LinkedList<song> playList)
    {
        Iterator<song> iterator = playList.iterator();
        System.out.println("-------------------");

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("-------------------");



    }
}
