package ie.tudublin;

public class Note {
    private char note;
    private int duration;
    
    // Constructor
    public Note(char note, int duration) {
        this.note = note;
        this.duration = duration;
    }

    // toString
    @Override
    public String toString() {
        return "Note [note=" + note + ", duration=" + duration + "]";
    }
}
