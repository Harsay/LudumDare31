package com.harsay.ld31;

import java.util.ArrayList;

public class GameSequence {

	Obstacle[] seq0;
	Obstacle[] seq1;
	
	ArrayList<Obstacle[]> sequences = new ArrayList<Obstacle[]>();
	
	public boolean finished = false;	
	MyGame game;
	
	public GameSequence(MyGame game) {
		this.game = game;
		
		seq0 = new Obstacle[] {
				new Obstacle(game, MyGame.WIDTH/2-300, MyGame.HEIGHT/2-300, 600, 600, 1.0f, 1.0f),
				new Obstacle(game, 1840, 0, 80, MyGame.HEIGHT, 4.0f, new Goal[] {
						new Goal(100, -1f, -1f, -1f, 3.0f)	
					}),
				new Obstacle(game, 0, 0, 80, MyGame.HEIGHT, 10.0f, new Goal[] {
						new Goal(1760, -1f, -1f, -1f, 1.5f)	
					}),
				new Obstacle(game, 1840, 0, 80, MyGame.HEIGHT, 14.0f, new Goal[] {
						new Goal(MyGame.WIDTH/2+100, -1f, -1f, -1f, 2.0f),
						new Goal(-1f, -1f, -1f, -1f, 5.0f)
					}),
				new Obstacle(game, 0, 0, 80, MyGame.HEIGHT, 14.0f, new Goal[] {
						new Goal(MyGame.WIDTH/2-180, -1f, -1f, -1f, 2.0f),
						new Goal(-1f, -1f, -1f, -1f, 5.0f)
					}),
				new Obstacle(game, 0, 0, MyGame.WIDTH, 80, 17.0f, new Goal[] { // down
						new Goal(-1f, MyGame.HEIGHT/2-360, -1f, -1f, 1.5f),
						new Goal(-1f, -1f, -1f, -1f, 1.0f),
						new Goal(-1f, -1f, -1f, 330f, 0.3f),
						new Goal(-1f, -1f, -1f, -1f, 1.2f)
					}),
				new Obstacle(game, 0, MyGame.HEIGHT-80, MyGame.WIDTH, 80, 17.0f, new Goal[] { // up
						new Goal(-1f, MyGame.HEIGHT/2+300, -1f, -1f, 1.5f),
						new Goal(-1f, -1f, -1f, -1f, 1.0f),
						new Goal(-1f, MyGame.HEIGHT/2+70, -1f, 250f, 0.3f),
						new Goal(-1f, -1f, -1f, -1f, 1.2f)
					})
		};
		sequences.add(seq0);
		
		seq1 = new Obstacle[] {
				new Obstacle(game, 0, MyGame.HEIGHT-80, MyGame.WIDTH, 80, 1.0F, new Goal[] { // Upper constraint
						new Goal(-1f, -1f, -1f, -1f, 1.0f),
						new Goal(-1f, 400, -1f, -1f, 2.0f),
						new Goal(-1f, -1f, -1f, -1f, 1.0f),
						new Goal(-1f, MyGame.HEIGHT-80, -1f, -1f, 4.0f),
						new Goal(-1f, -1f, -1f, -1f, 7.0f),
						new Goal(-1f, 200, -1f, -1f, 0.5f),
						new Goal(-1f, -1f, -1f, -1f, 2.5f),
				}),
				new Obstacle(game, 0, 0, MyGame.WIDTH, 80, 1.0f, new Goal[] { // Down constraint
						new Goal(-1f, -1f, -1f, -1f, 4.0f),
						new Goal(-1f, MyGame.HEIGHT-400, -1f, -1f, 4.0f),
						new Goal(-1f, -1f, -1f, -1f, 6.0f),
						new Goal(-1f, 0, -1f, -1f, 1.0f),
						new Goal(-1f, -1f, -1f, -1f, 3.0f),
				}),
				new Obstacle(game, 0, 0, 80, MyGame.HEIGHT, 1.0f, new Goal[] { // left constraint
						new Goal(-1f, -1f, -1f, -1f, 4.0f),
						new Goal(MyGame.WIDTH-400, -1f, -1f, -1f, 4.0f),
						new Goal(-1f, -1f, -1f, -1f, 1.0f),
						new Goal(MyGame.WIDTH/2-230, -1f, -1f, -1f, 4.0f),
						new Goal(-1f, -1f, -1f, -1f, 5.0f)
				}),
				new Obstacle(game, MyGame.WIDTH-80, 0, 80, MyGame.HEIGHT, 1.0f, new Goal[] { // right constraint
						new Goal(-1f, -1f, -1f, -1f, 1.0f),
						new Goal(400, -1f, -1f, -1f, 2.0f),
						new Goal(-1f, -1f, -1f, -1f, 1.0f),
						new Goal(MyGame.WIDTH-80, -1f, -1f, -1f, 4.0f),
						new Goal(-1f, -1f, -1f, -1f, 1.0f),
						new Goal(MyGame.WIDTH/2+150, -1f, -1f, -1f, 4.0f),
						new Goal(-1f, -1f, -1f, -1f, 5.0f)
				})
		};
		sequences.add(seq1);
	}
	
	public Obstacle[] getSequence(int id) {
		return sequences.get(id+1);
	}
	
	public void update() {
		finished = game.obstacles.size() == 0;
	}


}
