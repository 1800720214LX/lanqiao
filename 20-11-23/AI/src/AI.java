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
	int heroX,heroY,bossX,bossY;
	int i,j;
	int flag;
	Image heroImg[][]=new Image[4][3];//�ĸ�����ÿ����������ͼƬ��0��ʾleft��1��ʾright��2��ʾup��3��ʾdown
	Image currentImg;
	Image bossImg;
	/*
	�����ά����
	*/
	public MainCanvas(){
		try
		{
			for (int i=0;i<heroImg.length;i++ ){
				for(int j=0;j<heroImg[i].length;j++){
					heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
			}
		}
		bossImg=Image.createImage("/zuzu000.png");
		currentImg=heroImg[3][1];

			heroX=120;
			heroY=100;

            bossX=0;
			bossY=0;

			flag=1;

			thread=new Thread(this);
			thread.start();
			
	    }

		
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void run(){
		while(true){
			if(bossX<heroX){
				bossX++;
			}else{
					bossX--;
				}
					if(bossY<heroY){
						bossY++;
					}else{
						bossY--;
					}
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,heroX,heroY,0);
		g.drawImage(bossImg,0,0,0);
	}
    /*
	���巽��
	*/
    public void changePicAndMove(int direction){
		currentImg=heroImg[direction][1];
		 if(flag==1)
		{
			 currentImg=heroImg[direction][0];
			 flag++;
		}
		else if(flag==2)
		{
			 currentImg=heroImg[direction][2];
			 flag=1;
		}
    }
    public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		/*
		acttion��ֵ��UP��DOWN��LEFT��RIGHT
		*/
		if(action==LEFT){
			//���÷���
			changePicAndMove(0);
			heroX=heroX-1;
			System.out.println("����ת");
			}
		 if(action==RIGHT){
			changePicAndMove(1);
			heroX=heroX+1;
			System.out.println("����ת");
			}
		if(action==UP){
            changePicAndMove(2);
			heroY=heroY-1;
			System.out.println("����ת");
			}
		if(action==DOWN){
            changePicAndMove(3);
			heroY=heroY+1;
			System.out.println("����ת");
		}
		repaint();
	}
}
			/*
		if(action==LEFT){
		    currentImg=heroImg[0][1];
			x=x-1;
			System.out.println("����ת");
			}
        if(leftFlag==1)
		{
			 currentImg=heroImg[0][0];
			 leftFlag++;
		}
		else if(leftFlag==2)
		{
			 currentImg=heroImg[0][2];
			 leftFlag=1;
		}*/
		      
		/*
		if(action==RIGHT){
		    currentImg=heroImg[1][1];
			x=x+1;
			System.out.println("����ת");
			}
		if(rightFlag==1)
		{
			 currentImg=heroImg[1][0];
			 rightFlag++;
		}
		else if(rightFlag==2)
		{
			 currentImg=heroImg[1][2];
			 rightFlag=1;
		}*/
		
		/*
        if(action==UP){
		    currentImg=heroImg[2][1];
			y=y-1;
			System.out.println("����ת");
		}
		if(upFlag==1)
		{
			 currentImg=heroImg[2][0];
			 upFlag++;
		}
		else if(upFlag==2)
		{
			 currentImg=heroImg[2][2];
			 upFlag=1;
		}*


		/*
		if(action==DOWN){
		    currentImg=heroImg[3][1];
			x=x+1;
			System.out.println("����ת");
			}
		if(downFlag==1)
		{
			 currentImg=heroImg[3][0];
			 downFlag++;
		}
		else if(downFlag==2)
		{
			 currentImg=heroImg[3][2];
			 downFlag=1;
		}*/