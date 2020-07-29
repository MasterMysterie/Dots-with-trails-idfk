package processing_fun;

import java.util.ArrayList;
import java.util.Random;

import processing.core.PApplet;
import processing.core.PVector;

public class Main extends PApplet{

	int WHITE = color(255, 255, 255);
	int BLUE = color(0, 0, 255);
	int BLACK = color(0,0,0);
	int diameter = 20;
	int speed = 2;
	ArrayList<Dot> dots = new ArrayList<Dot>();
	Random random = new Random();
	boolean clear = false;
	
	
	public void setup() {
		background(BLACK);
		noStroke();
		frameRate(60);
	}
	
	public void settings() {
		fullScreen();
		
	}
	
	public void draw() {
		if(clear) {
			background(BLACK);
		}
		
		for(Dot dot : dots) {
			dot.draw(this);
			dot.noisyDirection(this);
		}
	}
	
	public void keyPressed() {
		if(key == 'r') {
			background(BLACK);
		}
		else if(key == ' ') {
			for(Dot dot:dots) {
				background(BLACK); 
				dot.position = new PVector(width / 2,height / 2);
		
			}
		}
		else if(key == 'c') {
			clear = ! clear;
		}
		if(keyCode == ENTER) {
			int corr = random.nextInt(70);
			dots.add(new Dot(new PVector(random.nextInt(width), random.nextInt(height)), corr / 10 * -1 + 7, corr, color(random.nextInt(256),random.nextInt(256),random.nextInt(256))));
		}
		
	}
	
	public static void main(String[] args) {
		PApplet.main("processing_fun.Main");

	}

}//nice
