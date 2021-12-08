package main;

import gameObjects.Noise;

public class GameFrame {
	private Noise noise;
	private int length;
	private int width;
	private int height;
	private double[] rand1;
	private double[] perlin1;
	private double[][] rand2;
	private double[][] perlin2;
	
	//pivot
	private double pivot1;
	
	private double pivot2x;
	private double pivot2y;
	
	private double sx, sy, s1, s2;
	
	public GameFrame() {
		noise=new Noise();
		pivot1=0;
		pivot2x=0;
		pivot2y=0;
		sx=0;
		sy=0;
		s1=1;
		s2=1;
		
		//1D noise
		length=180;
		rand1=noise.getRand(length);
		perlin1=noise.getPerlin(rand1);
		
		//2D noise
		width=360;
		height=360;
		rand2=noise.getRand(width, height);
		perlin2=noise.getPerlin(rand2);
	}
	 
	public void update() {
		 pivot1+=s1;
		 if((int)pivot1==perlin1.length) {
			 pivot1=0;
		 }
		 
		 pivot2x+=sx;
		 if((int)pivot2x==perlin2.length) {
			 pivot2x=0;
		 }
		 
		 pivot2y+=sy;
		 if((int)pivot2y==perlin2[0].length) {
			 pivot2y=0;
		 }
		 
		 if((int)pivot2x==0 && (int)pivot2y==0) {
			 if(Math.random()>0.5) {
				 sx=s2;
			 }else {
				 sx=0;
			 }
			 if(Math.random()>0.5) {
				 sy=s2;
			 }else {
				 sy=0;
			 }
		 }
	}
	
	public double[] getRand1() {
		return rand1;
	}
	
	public double[][] getRand2(){
		return rand2;
	}
	
	public double[] getPerlin1() {
		return perlin1;
	}
	
	public double[][] getPerlin2(){
		return perlin2;
	}
	
	public int getPivot1() {
		return (int) pivot1;
	}
	
	public int getPivot2x() {
		return (int) pivot2x;
	}
	
	public int getPivot2y() {
		return (int) pivot2y;
	}
}
