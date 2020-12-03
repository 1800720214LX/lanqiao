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
	int x,y;
	int leftFlag,rightFlag,upFlag,downFlag;
	Image downImg,downImg1,downImg2,leftImg,leftImg1,leftImg2,upImg,upImg1,upImg2,rightImg,rightImg1,rightImg2,currentImg;

	public MainCanvas(){
		try
		{
			x=120;
			y=100;
			downImg=Image.createImage("/sayo10.png"); //DOWN
			downImg1=Image.createImage("/sayo00.png"); //DOWN
			downImg2=Image.createImage("/sayo20.png"); //DOWN
			leftImg=Image.createImage("/sayo12.png"); //LEFT
			leftImg1=Image.createImage("/sayo02.png"); //LEFT
			leftImg2=Image.createImage("/sayo22.png"); //LEFT
			upImg=Image.createImage("/sayo14.png"); //UP
			upImg1=Image.createImage("/sayo04.png"); //UP
			upImg2=Image.createImage("/sayo24.png"); //UP
            rightImg=Image.createImage("/sayo16.png"); //RIGHT
			rightImg1=Image.createImage("/sayo06.png"); //RIGHT
			rightImg2=Image.createImage("/sayo26.png"); //RIGHT
			currentImg=downImg;
			leftFlag=1;

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
    public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);

		if(action==LEFT){
			currentImg=leftImg1;
			System.out.println("向左转");
			x=x-1;
			if(leftFlag==1)
				{
			currentImg=leftImg1;
			leftFlag++;
			}

			else if(leftFlag==2)
				{
			currentImg=leftImg2;
            leftFlag=1;
			}
			}

		if(action==RIGHT){
			currentImg=rightImg;
			System.out.println("向右转");
			}

		if(action==UP){
			currentImg=upImg;
			System.out.println("向上转");
			}

		if(action==DOWN){
			currentImg=downImg;
			System.out.println("向下转");
		}
		repaint();
	}
}