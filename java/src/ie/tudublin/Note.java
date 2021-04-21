package ie.tudublin;

public class Note {
    private char note;
    private int duration;
    
    public Note(char note, int duration) {
        this.note = note;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Note [note=" + note + ", duration=" + duration + "]";
    }
}
