package displays;
import java.awt.Color;
import java.awt.Graphics;

import main.GameFrame;
import main.Gui;

public class Mode1Display{
	
	private Gui gui;
	private GameFrame gameframe;
	private double[] rand;
	private double[] perlin;
	private int size,startX,startY,frameW,frameH, line;
	//game stuff
	
	public Mode1Display(Gui gui1, GameFrame gameframe){
		gui=gui1;
		this.gameframe=gameframe;
		rand=gameframe.getRand1();
		perlin=gameframe.getPerlin1();
		frameW=3;
		frameH=3;
	}
	
	public void render(Graphics g) {
		if((gui.getWidth()/frameW)<gui.getHeight()/frameH) {
			size=gui.getWidth()/frameW;
		}else {
			size=gui.getHeight()/frameH;
		}
		
		startX=(int)((gui.getWidth()/2.0)-((size*frameW)/2.0));
		startY=(int)((gui.getHeight()/2.0)-((size*frameH)/2.0));
		
		line=size/rand.length;
		int pivot=gameframe.getPivot1();
		
		for(int y=0; y< frameH; y++) {
			for(int x=0; x<frameW;x++) {
				if(x==0 && y==2) {
					g.setColor(new Color(255, 0, 0));
					for(int i=0; i<perlin.length; i++) {
						g.fillRect(startX+size*x+(int)(i*line), startY+size*((frameH-1)-y)+(int)(size-(size*rand[i])), line, (int)(size*perlin[i]));
					}
				}else if(x==2 && y==2) {
					g.setColor(new Color(0, 255, 0));
					for(int i=0; i<perlin.length; i++) {
						g.fillRect(startX+size*x+(int)(i*line), startY+size*((frameH-1)-y)+(int)(size-(size*perlin[i])), line, (int)(size*perlin[i]));
					}
				}else if(x==0 && y==0) {
					for(int i=0; i<perlin.length; i++) {
						g.setColor(new Color(0, 255, 0));
						g.fillRect(startX+size*x+(int)(i*line), startY+size*((frameH-1)-y)+(int)(size-(size*perlin[i])), line, (int)(size*perlin[i]));
						g.setColor(new Color(0, 0, 255));
						g.fillRect(startX+size*x+(int)(i*line), startY+size*((frameH-1)-y)+(int)(size-(size*0.4)), line, (int)(size*0.4));
					}
				}else if(x==2 && y==0) {
					int idx=pivot;
					for(int i=0; i<perlin.length; i++) {
						idx++;
						if(idx==perlin.length) {
							idx=0;
						}
						g.setColor(new Color(0, 255, 0));
						g.fillRect(startX+size*x+(int)(i*line), startY+size*((frameH-1)-y)+(int)(size-(size*perlin[idx])), line, (int)(size*perlin[idx]));
						g.setColor(new Color(0, 0, 255));
						g.fillRect(startX+size*x+(int)(i*line), startY+size*((frameH-1)-y)+(int)(size-(size*0.4)), line, (int)(size*0.4));
					}
				}
			}
		}
	}
}