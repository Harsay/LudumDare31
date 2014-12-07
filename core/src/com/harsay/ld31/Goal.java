package com.harsay.ld31;

public class Goal {

	public float x;
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
		if(x > 0) x = x - o.x;
		else x = 0;
		if(y > 0) y = y - o.y;
		else y = 0;
		if(width > 0) width = width - o.width;
		else width = 0;
		if(height > 0) height = height - o.height;
		else height = 0;
	}
	
	public void update(Obstacle o, float delta) {
		timeElapsed += delta;
		
		o.x += x * delta * timeToDoIt;
		o.y += y * delta * timeToDoIt;
		o.width += width * delta * timeToDoIt;
		o.height += height * delta * timeToDoIt;
		
		System.out.println("Time elapsed: "+timeElapsed+" | x = "+o.x);
		
		if(timeElapsed >= timeToDoIt) {
			reached = true;
			//if(x!=0) o.x = x;
			//if(y!=0)o.y = y;
			//if(width!=0)o.width = width;
			//if(height!=0)o.height = height;
		}
	}
}
