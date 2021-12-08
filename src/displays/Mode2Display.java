package displays;
import java.awt.Color;
import java.awt.Graphics;

import main.GameFrame;
import main.Gui;

public class Mode2Display{
	
	private Gui gui;
	private GameFrame gameframe;
	private double[][] rand;
	private double[][] perlin;
	private int size,startX,startY,frameW,frameH, line;
	
	//game stuff
	
	public Mode2Display(Gui gui1, GameFrame gameframe){
		gui=gui1;
		this.gameframe=gameframe;
		rand=gameframe.getRand2();
		perlin=gameframe.getPerlin2();
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
		int pivotx=gameframe.getPivot2x();
		int pivoty=gameframe.getPivot2y();
		
		
		for(int y=0; y< frameH; y++) {
			for(int x=0; x<frameW;x++) {
				if(x==0 && y==2) {
					for(int ix=0; ix<perlin.length; ix++) {
						for(int iy=0; iy<perlin[0].length; iy++) {
							g.setColor(new Color((int) (255*rand[ix][iy]), (int) (255*rand[ix][iy]), (int) (255*rand[ix][iy])));
							g.fillRect(startX+size*x+(int)(ix*line), startY+size*((frameH-1)-y)+(int)(iy*line), line, line);
						}
					}
				}else if(x==2 && y==2) {
					for(int ix=0; ix<perlin.length; ix++) {
						for(int iy=0; iy<perlin[0].length; iy++) {
							g.setColor(new Color((int) (255*perlin[ix][iy]), (int) (255*perlin[ix][iy]), (int) (255*perlin[ix][iy])));
							g.fillRect(startX+size*x+(int)(ix*line), startY+size*((frameH-1)-y)+(int)(iy*line), line, line);
						}
					}
				}else if(x==0 && y==0) {
					for(int ix=0; ix<perlin.length; ix++) {
						for(int iy=0; iy<perlin[0].length; iy++) {
							if(perlin[ix][iy]>0.5) {
								//Grass
								g.setColor(new Color(0, (int) (255*perlin[ix][iy]), 0));
							}else {
								//water
								g.setColor(new Color(0, 0, (int) (100+155*perlin[ix][iy])));
							}
							g.fillRect(startX+size*x+(int)(ix*line), startY+size*((frameH-1)-y)+(int)(iy*line), line, line);
						}
					}
				}else if(x==2 && y==0) {
					int idx=pivotx;
					int idy=pivoty;
					for(int ix=0; ix<perlin.length; ix++) {
						idx++;
						if(idx==perlin.length) {
							idx=0;
						}
						for(int iy=0; iy<perlin[0].length; iy++) {
							idy++;
							if(idy==perlin[0].length) {
								idy=0;
							}
							if(perlin[idx][idy]>0.5) {
								//Grass
								g.setColor(new Color(0, (int) (255*perlin[idx][idy]), 0));
							}else {
								//water
								g.setColor(new Color(0, 0, (int) (100+155*perlin[idx][idy])));
							}
							g.fillRect(startX+size*x+(int)(ix*line), startY+size*((frameH-1)-y)+(int)(iy*line), line, line);
						}
					}
				}
			}
		}
	}
}
