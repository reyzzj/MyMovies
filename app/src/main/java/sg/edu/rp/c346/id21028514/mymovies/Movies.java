package sg.edu.rp.c346.id21028514.mymovies;

import java.io.Serializable;

public class Movies implements Serializable {

    private 	int id;
    private 	String title;
    private     String genre;
    private     int year;



    public Movies(int id, String title, String genre, int year) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.year = year;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    //    public int getId() {  return id;  }
//
//    public String getNoteContent() { return noteContent; }
//    public String getNoteContent2() { return noteContent2; }
//    public String getNoteContent3() { return noteContent3; }
//    public int getNoteContent4() { return noteContent4; }
//
//    public void setNoteContent(String noteContent) {
//        this.noteContent = noteContent;
//    }
//    public void setNoteContent2(String noteContent2) {
//        this.noteContent2 = noteContent2;
//    }
//    public void setNoteContent3(String noteContent3) {
//        this.noteContent3 = noteContent3;
//    }
//    public void setNoteContent4(Integer noteContent4) { this.noteContent4 = noteContent4; }
//
//
//    public String toStringStars(int stars) {
//        String staroutput = "";
//        for (int i = 1; i <= stars; i++) {
//            staroutput += "*";
//        }
//        return staroutput;
//    }
//
//    @Override
//    public String toString() {
//        String staroutput = "";
//        int starint = noteContent4;
//        for (int i = 1; i <= starint; i++)
//        {
//            staroutput+="*";
//        }
//
//
//        return
//                "Song name: " + noteContent
//                        +"\n"
//                        +"Song Title: "  + noteContent2
//                        +"\n"
//                        +"Song Year: "  + noteContent3
//                        +"\n"
//                        + staroutput;
//    }


}
