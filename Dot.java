package processing_fun;

import processing.core.PApplet;
import java.util.Random;
import processing.core.PVector;

public class Dot{

	PVector position = new PVector(0, 0);
	PVector direction = new PVector(0, 0);
	float speed = 0;
	float diameter = 0;
	Random random = new Random();
	float yOff = random.nextInt(10000);
	float xOff = random.nextInt(2);
	int color = 0;
	
	public Dot(PVector position, int speed, int diameter, int color) {
		this.color = color;
		this.position = position;
		this.speed = (float)speed;
		this.diameter = (float)diameter;
		
	}
	
	public void noisyDirection(PApplet applet) {
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
		
		applet.fill(color);
		applet.circle(position.x, position.y, diameter);
	}
	
}
