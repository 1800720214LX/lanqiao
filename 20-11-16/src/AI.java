import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;
public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{
	Image downImg,leftImg,upImg,rightImg,currentImg;

	public MainCanvas(){
		try
		{
			downImg=Image.createImage("/sayo20.png"); //DOWN
			leftImg=Image.createImage("/sayo22.png"); //LEFT
			upImg=Image.createImage("/sayo14.png"); //UP
            rightImg=Image.createImage("/sayo26.png"); //RIGHT
			currentImg=downImg;



		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,120,100,0);
	}
    public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);

		if(action==LEFT){
			currentImg=leftImg;
			System.out.println("����ת");
			}

		if(action==RIGHT){
			currentImg=rightImg;
			System.out.println("����ת");
			}

		if(action==UP){
			currentImg=upImg;
			System.out.println("����ת");
			}

		if(action==DOWN){
			currentImg=downImg;
			System.out.println("����ת");
		}
		repaint();
	}
}