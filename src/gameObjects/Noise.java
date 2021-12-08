package gameObjects;

public class Noise {
	
	public double[] getRand(int length) {
		double[] out=new double[length];
		for(int i=0; i<length; i++) {
			out[i]=Math.random();
		}
		return out;
	}
	
	public double[][] getRand(int width, int height) {
		double[][] out=new double[width][height];
		for(int x=0; x<width; x++) {
			for(int y=0; y<height; y++) {
				out[x][y]=Math.random();
			}
		}
		return out;
	}
	
	public double[] getPerlin(double[] input) {
		double[] out=new double[input.length];
		for(int i=0; i<out.length; i++) {
			out[i]=input[i];
		}
		double d=0;
		for(int i=0; i<out.length; i++) {
			d=input[i]/2;
		}
		return out;
	}
	
	public double[][] getPerlin(double[][] input) {
		double[][] out=new double[input.length][input[0].length];
		for(int x=0; x<out.length; x++) {
			for(int y=0; y<out.length; y++) {
				out[x][y]=input[x][y];
			}
		}
		return out;
	}
	
}
