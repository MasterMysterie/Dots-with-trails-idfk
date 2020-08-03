package processing_fun;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;

public class Main extends PApplet{

	int WHITE = color(255, 255, 255);
	int BLACK = color(0,0,0);
	int diameter = 20;
	int speed = 2;
	ArrayList<Dot> dots = new ArrayList<Dot>();
	boolean clear = false;
	boolean trail = false;
	boolean paused = false;
	
	
	public void setup() {
		background(BLACK);
		frameRate(60);
		
	}
	
	public void settings() {
		fullScreen();
		
	}
	
	public void draw() {
		if(clear) {
			background(BLACK);
		}
		if(trail) {
			background(BLACK, 1);
		}
		
		for(Dot dot : dots) {
			if(! paused) {
				dot.noisyDirection(this);
			}
			dot.draw(this);
			
		}
	}
	
	public void mousePressed() {
		int corr = (int)random(101);
		dots.add(new Dot(new PVector(mouseX, mouseY), corr / 10 * -1 + 10, corr, color(random(256),random(256),random(256)), this));

	}
	
	public void keyPressed() {
		if(key == 'r') {
			dots = new ArrayList<Dot>();
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
		else if(key == 't') {
			trail = ! trail;
		}
		else if(key == 'p') {
			paused = ! paused;
		}
		if(keyCode == ENTER) {
			int corr = (int)random(101);
			dots.add(new Dot(new PVector(random(width + 1), random(height + 1)), corr / 10 * -1 + 10, corr, color(random(256),random(256),random(256)), this));
		}
		
	}
	
	public static void main(String[] args) {
		PApplet.main("processing_fun.Main");

	}

}
