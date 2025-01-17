package ie.tudublin;

import java.util.ArrayList;


import processing.core.PApplet;

public class ScoreDisplay extends PApplet
{
	// String score = "DEFGABcd";
	// String score = "D2E2F2G2A2B2c2d2";
	String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";

	private float sideBorder;
	private float topBorder;
	int duration;
	char scoreChar;
	int radius;

	// ArrayList for instances of Note
	ArrayList<Note> notes = new ArrayList<Note>();

	// Populate ArrayList with chars in String score
	public void loadScore() {
		if(score.length() > 9) {
			for(int i = 0; i < score.length() - 1; i += 2) {
				if(Character.isDigit(score.charAt(i)) == false) {
					scoreChar = score.charAt(i);
				}
				else {
					scoreChar = score.charAt(i+1);
				}

				if(Character.isDigit(score.charAt(i+1)) == true) {
					duration = 2;
				}
				else {
					duration = 1;
				}

				Note note = new Note(scoreChar, duration);
				notes.add(note);
			}
		}
		else {
			for(int i = 0; i < score.length(); i++) {
				char scoreChar = score.charAt(i);
				int duration = 1;
	
				Note note = new Note(scoreChar, duration);
				notes.add(note);
			}
		}
	}

	// Print ArrayList
	public void printScores() {
		for(int i = 0; i < notes.size(); i++) {
			Note note = notes.get(i);
			String noteType;
			
			if(note.getDuration() == 1) {
				noteType = "Quaver";
			}
			else {
				noteType = "Crotchet";
			}

			println(note.getNote() + "\t" + note.getDuration()+ "\t" + noteType);
		}
	}

	void drawStave() {
		for(float i = 0; i < 5 ; i++)
		{
			// fix hardcode
			float y = map(i, 0, 4, 200, 300);
			stroke(0);
			strokeWeight(2);
			line(sideBorder, y, width - sideBorder, y);
		}
	}

	void drawNotes()
	{
		int radius = 10;
		for(int i = 0; i < notes.size(); i++) {
			float x = map(i, 0, notes.size(), sideBorder + radius, width - sideBorder - radius);
			float y = map(i, 0, notes.size() + 2, topBorder - radius - 2, height - topBorder + radius);
			stroke(0);
			
			fill(0);
			circle(x, height - y, radius * 2);
			line(x + radius, height - y, x + radius, height - y - (radius * 6));

			Note note = notes.get(i);

			if(note.getDuration() == 1) {
				line(x + radius, height - y - (radius * 6), x + (radius * 2), height - y - (radius * 5));
			}
			
			textSize(20);
			text(note.getNote(), x, topBorder - (topBorder/2));
		}
	}

	void highlight() {
		for(int i = 0; i < notes.size(); i++) {
			float x = map(i, 0, notes.size(), sideBorder + radius, width - sideBorder - radius);
			float y = map(i, 0, notes.size() + 2, topBorder - radius - 2, height - topBorder + radius);

			if (mouseX > x - (radius * 2) && mouseX < x - (radius * 2) + (radius * 5))
			{
				fill(255, 0, 0); 
				stroke(255, 0, 0);               
			}

			circle(x, height - y, radius * 2);
			line(x + radius, height - y, x + radius, height - y - (radius * 6));

			Note note = notes.get(i);

			if(note.getDuration() == 1) {
				line(x + radius, height - y - (radius * 6), x + (radius * 2), height - y - (radius * 5));
			}

			textSize(20);
			text(note.getNote(), x, topBorder - (topBorder/2));
		}
	}

	public void settings()
	{
		size(1000, 500);

		// How to convert a character to a number
		char c = '7'; // c holds the character 7 (55)
		int i = c - '0'; // i holds the number 7 (55 - 48) 
		println(i);
	}

	public void setup() 
	{
		loadScore();
		printScores();
		sideBorder = width * 0.1f;
		topBorder = height * 0.4f;
		radius = 10;
	}

	public void draw()
	{
		background(255);
		drawStave();
		drawNotes();
		highlight();
	}
}
