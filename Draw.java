import java.util.Random;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;
import java.lang.IllegalArgumentException;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;
import java.io.IOException;
import java.io.File;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Draw extends JComponent{

	public int height = 0;
	public int width = 0;
	
	public int x = 50;
	public int y = 50;

	public int state = 0;

	public BufferedImage hud;
	public BufferedImage hudM;
	public BufferedImage image;
	public BufferedImage backg;
	public BufferedImage slime;
	public BufferedImage attack;
	public BufferedImage reverse;
	
	public URL resource = getClass().getResource("run0.png");
	public URL resource2 = getClass().getResource("fairy0.png");
	public URL resource3 = getClass().getResource("idle0.png");
	public URL resource4 = getClass().getResource("ABG.jpg");
	public URL resource5 = getClass().getResource("run10.png");
	public URL resource6 = getClass().getResource("GB.png");
	public URL resource7 = getClass().getResource("BB.png");

	public Random randomizer;
	public int enemyC;

	Monster[] monster = new Monster[10];

	public Draw(){
		randomizer = new Random();
		spawnEnemy();

		try{
			
			image = ImageIO.read(resource);
			attack = ImageIO.read(resource2);
			slime = ImageIO.read(resource3);
			backg = ImageIO.read(resource4);
			reverse = ImageIO.read(resource5);
			hud = ImageIO.read(resource6);
			hudM = ImageIO.read(resource7);
			
		}
		catch(IOException e){
			e.printStackTrace();
		}
		height = image.getHeight();
		width = image.getWidth();

		Startgame();
	}

	public void Startgame(){
		Thread gameThread = new Thread(new Runnable(){
			public void run(){
				while(true){
					try{
						for(int c = 0; c < monster.length; c++){
							if(monster[c]!=null){
								monster[c].moveTo(x, y);
								repaint();
							}
						}
						Thread.sleep(100);
					}
					catch(InterruptedException e){
						e.printStackTrace();
					}
					
				}
			}
		});
		gameThread.start();
	}
	public void spawnEnemy(){
		if(enemyC < 10){
			monster[enemyC] = new Monster(randomizer.nextInt(500), randomizer.nextInt(500));
			enemyC++;
		}
	}
	public void attackAnimation(){
		Thread thread1 = new Thread(new Runnable(){
				public void run(){
					for (int ctr = 0; ctr < 5; ctr++){
						try{
							if(ctr == 4){
								resource = getClass().getResource("fairy-0.png");
							}
							else{
								resource5 = getClass().getResource("fairy"+ctr+".png");
							}

							try{
								image = ImageIO.read(resource);
							}
							catch(IOException e){
								e.printStackTrace();
							}
							repaint();
							Thread.sleep(100);
						} catch(InterruptedException e){
							e.printStackTrace();
						}
					}
					for(int x = 0; x < monster.length; x++){
						if(monster[x]!=null){
							if(monster[x].contact){
								monster[x].life = monster[x].life - 10;
							}
						}
					}
				}
		});
		thread1.start();
	}
	public void reloadImage(){
		if(state==0){
			resource = getClass().getResource("fairy-0.png");
		}
		else if(state==1){
			resource = getClass().getResource("fairy-1.png");
		}
		else if(state==2){
			resource = getClass().getResource("fairy-2.png");
		}
		else if(state==1){
			resource = getClass().getResource("fairy-3.png");
		}
		else if(state==1){
			resource = getClass().getResource("fairy-4.png");
		}
		else if(state==1){
			resource = getClass().getResource("fairy-5.png");
		}
		else if(state==1){
			resource = getClass().getResource("fairy-6.png");
		}
		else if(state==1){
			resource = getClass().getResource("fairy-7.png");
			state = 0;
		}
		state++;
		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}	
	public void reloadImage2(){	
		if(state == 0){
			resource2 = getClass().getResource("fairy-0.png");
		}
		else if(state == 1){
			resource2 = getClass().getResource("fairy-1.png");
		}
		else if(state == 2){
			resource2 = getClass().getResource("fairy-2.png");
		}
		else if(state == 3){
			resource2 = getClass().getResource("fairy-3.png");
		}
		else if(state == 4){
			resource2 = getClass().getResource("fairy-4.png");
		}
		else if(state == 5){
			resource2 = getClass().getResource("fairy-5.png");
		}
		else if(state == 6){
			resource2 = getClass().getResource("fairy-6.png");
		}
		else if(state == 7){
			resource2 = getClass().getResource("fairy-7.png");
			state = 0;
		}
		state++;	
		try{
			image = ImageIO.read(resource2);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public void reloadImage3(){
		if(state==0){
			resource5 = getClass().getResource("fairy0.png");
		}
		else if(state==1){
			resource5 = getClass().getResource("fairy1.png");
		}
		else if(state==2){
			resource5 = getClass().getResource("fairy2.png");
		}
		else if(state==1){
			resource5 = getClass().getResource("fairy3.png");
		}
		else if(state==1){
			resource5 = getClass().getResource("fairy4.png");
		}
		else if(state==1){
			resource5 = getClass().getResource("fairy5.png");
		}
		else if(state==1){
			resource5 = getClass().getResource("fairy6.png");
		}
		else if(state==1){
			resource5 = getClass().getResource("fairy7.png");
			state = 0;
		}
		state++;
		try{
			image = ImageIO.read(resource5);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}	
	public void moveUp(){
		y = y - 5;
		reloadImage();
		repaint();
	}
	public void moveDown(){
		y = y + 5;
		reloadImage();
		repaint();
	}
	public void moveRight(){
		x = x + 5;
		reloadImage();
		repaint();
	}
	public void moveLeft(){
		x = x - 5;
		reloadImage3();
		repaint();
	}
	public void attack(){
		attackAnimation();
		reloadImage2();
		repaint();
	}
	public void checkCollision(){
		int xChecker = x + width;
		int yChecker = y;

		for(int x = 0; x < monster.length; x++){
			boolean collideX = false;
			boolean collideY = false;

			if(monster[x]!=null){
				monster[x].contact = false;

				if(xChecker > monster[x].xPos){
					if(yChecker - monster[x].yPos < monster[x].height){
						collideY = true;
					}
					else{
						if(monster[x].yPos - yChecker < monster[x].height){
							collideY = true;
						}
					}

					if(xChecker > monster[x].xPos){	
							if(xChecker-monster[x].xPos < monster[x].height){
								collideX = true;
						}
					}
					else{
						if(monster[x].xPos - xChecker < monster[x].height){
							collideX = true;
						}
					}
				}	
			}

			if(collideX && collideY){
					System.out.println("collision!");
					monster[x].contact = true;
			}
		}
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(backg, 0, 0, this);
		g.drawImage(image, x, y, this);
		g.drawImage(hud, -6, -30, this);
		g.drawImage(hudM, -6, -10, this);


		for(int c = 0; c < monster.length; c++){
			if(monster[c]!=null){
				g.drawImage(monster[c].image, monster[c].xPos, monster[c].yPos, this);
				g.setColor(Color.GREEN);
				g.fillRect(monster[c].xPos + 7, monster[c].yPos, monster[c].life, 2);
			}
		}
	}
}