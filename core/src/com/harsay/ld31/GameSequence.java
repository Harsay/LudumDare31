package com.harsay.ld31;

import java.util.ArrayList;

public class GameSequence {

	
	ArrayList<Obstacle[]> sequences = new ArrayList<Obstacle[]>();
	
	public boolean finished = false;	
	MyGame game;
	
	public GameSequence(MyGame game) {
		this.game = game;
		
		Obstacle[] seq0 = new Obstacle[] {
				new Obstacle(game, MyGame.WIDTH/2-300, MyGame.HEIGHT/2-300, 600, 600, 1.0f, 10.0f),
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
		
		Obstacle[] seq1 = new Obstacle[] {
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
		
		Obstacle[] seq2 = new Obstacle[] {
				new Obstacle(game, 0, MyGame.HEIGHT-200, 400, 200, 3.0f, 18.0f),
				new Obstacle(game, 0, 0, 400, 720, 3.0f, 18.0f),
				new Obstacle(game, 500, MyGame.HEIGHT-500, 400, 500, 3.0f, 18.0f),
				new Obstacle(game, 500, 0, 400, 460, 3.0f, 18.0f),
				new Obstacle(game, 1000, MyGame.HEIGHT-100, 400, 100, 3.0f, 18.0f),
				new Obstacle(game, 1000, 0, 400, 860, 3.0f, 18.0f),
				new Obstacle(game, 1500, MyGame.HEIGHT-600, 420, 600, 3.0f, 18.0f),
				new Obstacle(game, 1500, 0, 420, 320, 3.0f, 18.0f),
				new Obstacle(game, 400, 0, MyGame.WIDTH-400, MyGame.HEIGHT, 1.0f, 1.0f),
				new Obstacle(game, 0, 0, 80, MyGame.HEIGHT, 5.0f, new Goal[] {
						new Goal(1760, -1f, -1f, -1f, 6.0f)	
				}),
				new Obstacle(game, 1840, 0, 80, MyGame.HEIGHT, 15.0f, new Goal[] {
						new Goal(100, -1f, -1f, -1f, 6.0f)	
				}),
		};
		sequences.add(seq2);
		
		Obstacle[] seq3 = new Obstacle[] {
				
				new Obstacle(game, 0, 0, MyGame.WIDTH/2, MyGame.HEIGHT/2, 2.0f, 3.0f), // ld
				new Obstacle(game, 0, MyGame.HEIGHT/2, MyGame.WIDTH/2, MyGame.HEIGHT/2, 2.0f, 3.0f), // lu
				new Obstacle(game, MyGame.WIDTH/2, MyGame.HEIGHT/2, MyGame.WIDTH/2, MyGame.HEIGHT/2, 2.0f, 3.0f), // ru
		
				new Obstacle(game, MyGame.WIDTH/2, 0, MyGame.WIDTH/2, MyGame.HEIGHT/2, 8.0f, 3.0f), // rd
				new Obstacle(game, 0, MyGame.HEIGHT/2, MyGame.WIDTH/2, MyGame.HEIGHT/2, 8.0f, 3.0f), // lu
				new Obstacle(game, MyGame.WIDTH/2, MyGame.HEIGHT/2, MyGame.WIDTH/2, MyGame.HEIGHT/2, 8.0f, 3.0f), // ru		
				
				new Obstacle(game, 0, 0, MyGame.WIDTH/2, MyGame.HEIGHT/2, 14.0f, 3.0f), // Ld
				new Obstacle(game, 0, MyGame.HEIGHT/2, MyGame.WIDTH/2, MyGame.HEIGHT/2, 14.0f, 3.0f), // lu
				new Obstacle(game, MyGame.WIDTH/2, 0, MyGame.WIDTH/2, MyGame.HEIGHT/2, 14.0f, 3.0f), // rD		
		};
		sequences.add(seq3);
		
		Obstacle[] seq4 = new Obstacle[] {
				new Obstacle(game, 0, 0, MyGame.WIDTH/2, MyGame.HEIGHT/2, 1.0f, new Goal[] {
						new Goal(-1f, MyGame.HEIGHT/2, -1f, -1f, 0.5f),
						new Goal(MyGame.WIDTH/2, -1f, -1f, -1f, 0.5f),
						new Goal(-1f, 0, -1f, -1f, 0.5f),
						new Goal(0, -1f, MyGame.WIDTH, -1f, 0.5f),
						new Goal(-1f, -1f, -1f, MyGame.HEIGHT-80, 0.4f),
						new Goal(-1f, -1f, -1f, -1f, 1.0f)
				})
		};
		sequences.add(seq4);
		
		Obstacle[] seq5 = new Obstacle[] {
				
		};
		sequences.add(seq5);
		
		

	}
	
	public Obstacle[] getSequence(int id) {
		return sequences.get(id+4);
	}
	
	public void update() {
		finished = game.obstacles.size() == 0;
	}


}
