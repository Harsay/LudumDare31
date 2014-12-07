package com.harsay.ld31;

public class Goal {

	public float x;
	public float goalX;
	public float goalY;
	public float goalWidth;
	public float goalHeight;
	public float y;
	public float width;
	public float height;
	public float timeToDoIt;
	public boolean reached = false;	
	
	public float timeElapsed = 0;
	
	public Goal(float x, float y, float w, float h, float ttdi) {
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
		this.timeToDoIt = ttdi;
	}
	
	public void setObstacle(Obstacle o) {
		goalX = x;
		if(x > -1) x = x - o.x;
		else x = 0;
		goalY = y;
		if(y > -1) y = y - o.y;
		else y = 0;
		goalWidth = width;
		if(width > -1) width = width - o.width;
		else width = 0;
		goalHeight = height;
		if(height > -1) height = height - o.height;
		else height = 0;
	}
	
	public void update(Obstacle o, float delta) {
		timeElapsed += delta;
		
		o.x += x * delta / timeToDoIt;
		o.y += y * delta / timeToDoIt;
		o.width += width * delta / timeToDoIt;
		o.height += height * delta / timeToDoIt;
		
		//System.out.println("Time elapsed: "+timeElapsed+" | x = "+o.x);
		
		if(timeElapsed >= timeToDoIt) {
			reached = true;
			if(x!=0) o.x = goalX;
			if(y!=0) o.y = goalY;
			if(width!=0) o.width = goalWidth;
			if(height!=0) o.height = goalHeight;
		}
	}
}
