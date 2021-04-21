package ie.tudublin;

public class Note {
    private char note;
    private int duration;
    
    // Constructor
    public Note(char note, int duration) {
        this.note = note;
        this.duration = duration;
    }

    public char getNote() {
        return note;
    }

    public void setNote(char note) {
        this.note = note;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Note() {
    }

    // toString
    @Override
    public String toString() {
        return "Note [note=" + note + ", duration=" + duration + "]";
    }
}
