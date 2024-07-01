package at.ac.uibk.pm.g03.csbb5525.beispielKlausur2.e02;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Track implements Comparable<Track>{

    private String trackTitle;
    private String artistName;
    private String albumName;

    public Track(String trackTitle, String artistName, String albumName) {
        this.trackTitle = trackTitle;
        this.artistName = artistName;
        this.albumName = albumName;
    }

    @Override
    public String toString() {
        return "Track{" +
                "trackTitle='" + trackTitle + '\'' +
                ", artistName='" + artistName + '\'' +
                ", albumName='" + albumName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Track o) {
        int trackCompare = this.trackTitle.compareTo(o.trackTitle);
        int artisCompare = this.artistName.compareTo(o.artistName);
        int albumCompare = this.albumName.compareTo(o.albumName);

        if(trackCompare != 0){
            return trackCompare;
        }
        else if(artisCompare != 0){
            return artisCompare;
        }
        else {
            return albumCompare;
        }



    }


    public static void main(String[] args) {
        Track t1 = new Track("one", "two", "three");
        Track t3 = new Track("asdf", "ff", "qwer");
        Track t2 = new Track("one", "two", "three");


        System.out.println(t1.compareTo(t2));
        System.out.println(t2.compareTo(t1));
        System.out.println(t1.compareTo(t3));
        System.out.println(t2.compareTo(t3));


        List<Track> trackList = List.of(t1, t2, t3);
        System.out.println(trackList);

        List<Track> newList = new ArrayList<>(trackList);
        newList.sort(Comparator.naturalOrder());

        System.out.println(newList);



    }


}
