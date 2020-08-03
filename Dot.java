package processing_fun;

import processing.core.PApplet;
import processing.core.PVector;

public class Dot{

	PVector pre_pos = new PVector(0, 0);
	PVector position = new PVector(0, 0);
	PVector direction = new PVector(0, 0);
	float speed = 0;
	float diameter = 0;
	float yOff;
	float xOff;
	int color = 0;
	
	public Dot(PVector position, int speed, int diameter, int color, PApplet applet) {
		this.color = color;
		this.position = position;
		this.speed = (float)speed;
		this.diameter = (float)diameter;
		yOff = applet.random(100000);
		xOff = applet.random(100000);
	}
	
	public void noisyDirection(PApplet applet) {
		pre_pos = position.copy();
		float x = applet.noise(xOff) * applet.width;
		float y = applet.noise(yOff) * applet.height;
		direction.x = x - position.x;
		direction.y = y - position.y;
		direction.normalize();
		position.add(direction.mult(speed));
		xOff += 0.01;
		yOff += 0.01;
	}
	
	public void draw(PApplet applet) {
		
		applet.stroke(color);
		applet.strokeWeight(diameter/2);
		applet.line(pre_pos.x, pre_pos.y, position.x, position.y);
		
	}
	
}
