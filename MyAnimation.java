import javax.swing.JFrame;
import java.lang.IllegalArgumentException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class MyAnimation extends JFrame implements KeyListener{

	Draw drawing;
	Createfile g;

	public MyAnimation(){
		this.drawing = new Draw();
	}

	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_RIGHT && e.getKeyCode() == KeyEvent.VK_DOWN){
			drawing.moveRight();
			drawing.moveDown();
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT && e.getKeyCode() == KeyEvent.VK_UP){
			drawing.moveRight();
			drawing.moveUp();
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP){
			drawing.moveUp();
			System.out.println("pos: " + drawing.x + ", " + drawing.y);
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			drawing.moveRight();
			System.out.println("pos: " + drawing.x + ", " + drawing.y);
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			drawing.moveDown();
			System.out.println("pos: " + drawing.x + ", " + drawing.y);
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			drawing.moveLeft();
			System.out.println("pos: " + drawing.x + ", " + drawing.y);
		}
		else if(e.getKeyCode() == KeyEvent.VK_Z){
			drawing.attack();
			System.out.println("attack");
		}
		else if(e.getKeyCode() == KeyEvent.VK_S){
			drawing.spawnEnemy();
		}
	}

	public void keyReleased(KeyEvent e){

	}

	public void keyTyped(KeyEvent e){
		
	}

	public static void main(String args[]){
		MyAnimation gameFrame = new MyAnimation();
		String filepath = "bgmusic.wav";
		Sound musicObject = new Sound();
		Createfile g = new Createfile();
		g.openFile();
		g.addRecords();
		g.closeFile();
		musicObject.playMusic(filepath);
		gameFrame.setSize(500, 490);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setVisible(true);
		gameFrame.getContentPane().add(gameFrame.drawing);
		gameFrame.addKeyListener(gameFrame);
		System.out.println("Java Game JFrame");
	}
}