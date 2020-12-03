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
	Image heroLeftImg[]=new Image[3];
	Image heroRightImg[]=new Image[3];
	Image heroUpImg[]=new Image[3];
	Image heroDownImg[]=new Image[3];
    //Image rightImg,rightImg1,rightImg2;
	//Image leftImg,leftImg1,leftImg2;
	//Image upImg,upImg1,upImg2;
	//Image downImg,downImg1,downImg2;
	Image currentImg;

	public MainCanvas(){
		try
		{
			for(int i=0;i<heroDownImg.length;i++)
				{
				heroDownImg[i]=Image.createImage("/sayo"+i+"0.png");//DOWN
				}
			/*
			downImg=Image.createImage("/sayo10.png"); //DOWN
			downImg1=Image.createImage("/sayo00.png");
			downImg2=Image.createImage("/sayo20.png");
			*/
			
			for(int i=0;i<heroLeftImg.length;i++)
				{
				heroLeftImg[i]=Image.createImage("/sayo"+i+"2.png");//LEFT
				}
			
			/*
			leftImg=Image.createImage("/sayo12.png"); //LEFT
            leftImg1=Image.createImage("/sayo02.png");
			leftImg2=Image.createImage("/sayo22.png");
			*/

            for(int i=0;i<heroUpImg.length;i++)
				{
				heroUpImg[i]=Image.createImage("/sayo"+i+"4.png"); //up
				}
			/*
			upImg=Image.createImage("/sayo14.png"); //UP
            upImg1=Image.createImage("/sayo04.png");
			upImg2=Image.createImage("/sayo24.png");
			*/

            for(int i=0;i<heroRightImg.length;i++)
				{
				heroRightImg[i]=Image.createImage("/sayo"+i+"6.png"); //RIGHT
			}
			/*
            rightImg=Image.createImage("/sayo16.png"); //RIGHT
			rightImg1=Image.createImage("/sayo06.png"); 
			rightImg2=Image.createImage("/sayo26.png"); 
			*/
			currentImg=heroDownImg[1];
			x=120;
			y=100;
            leftFlag=1;
			rightFlag=1;
			upFlag=1;
			downFlag=1;



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
			currentImg=heroLeftImg[1];
			x=x-1;
        if(leftFlag==1)
		{
			 currentImg=heroLeftImg[0];
			 leftFlag++;
		}
		else if(leftFlag==2)
		{
			 currentImg=heroLeftImg[2];
			 leftFlag=1;
		}
		System.out.println("向左转");
			}
        /*
		if(action==LEFT){
			currentImg=leftImg;
			x=x+1;
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
		System.out.println("向左转");
		}*/

        if(action==RIGHT){
			currentImg=heroRightImg[1];
			x=x+1;
		if(rightFlag==1)
		{
			 currentImg=heroRightImg[0];
			 rightFlag++;
		}
		else if(rightFlag==2)
		{
			 currentImg=heroRightImg[2];
			 rightFlag=1;
		}
		System.out.println("向右转");
			}
		/*
		if(action==RIGHT){
			currentImg=rightImg;
			x=x+1;
		if(rightFlag==1)
		{
			 currentImg=rightImg1;
			 rightFlag++;
		}
		else if(rightFlag==2)
		{
			 currentImg=rightImg2;
			 rightFlag=1;
		}
		System.out.println("向右转");
			}*/

        if(action==UP){
			currentImg=heroUpImg[1];
			y=y-1;
		if(upFlag==1)
		{
			 currentImg=heroUpImg[0];
			 upFlag++;
		}
		else if(upFlag==2)
		{
			 currentImg=heroUpImg[2];
			 upFlag=1;
		}
			
		System.out.println("向上转");
			}
   
        /*
		if(action==UP){
			currentImg=upImg;
			y=y-1;
		if(upFlag==1)
		{
			 currentImg=upImg1;
			 upFlag++;
		}
		else if(upFlag==2)
		{
			 currentImg=upImg2;
			 upFlag=1;
		}
			
		System.out.println("向上转");
			}*/

        if(action==DOWN){
			currentImg=heroDownImg[1];
			y=y+1;
		if(downFlag==1)
		{
			 currentImg=heroDownImg[0];
			 downFlag++;
		}
		else if(downFlag==2)
		{
			 currentImg=heroDownImg[2];
			 downFlag=1;
		}
		System.out.println("向下转");
		}
		/*
		if(action==DOWN){
			currentImg=downImg;
			y=y+1;
		if(downFlag==1)
		{
			 currentImg=downImg1;
			 downFlag++;
		}
		else if(downFlag==2)
		{
			 currentImg=downImg2;
			 downFlag=1;
		}

		System.out.println("向下转");
		}*/
		repaint();
	}
}