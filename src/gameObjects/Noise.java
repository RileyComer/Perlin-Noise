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
	
	public double[] getPerlin(double[] input, double step) {
		double[] out=new double[input.length];
		for(int idx=0;idx<input.length;idx++) {
			double power=1, sum=0,d=-1;
			for(double i=input.length, layer=1;(int)i!=0; sum+=power, power=power*step,d=-1, layer++) {
				if(layer==1) {
					d=input[0];
				}else {
					for(double s=0;d<0;s+=i) {
						if(idx==s) {
							d=input[(int)s];
						}else if((s+i)>idx) {
							if((s+i)<input.length) {
								d=(input[(int)s]-((input[(int)s]-input[(int)(s+i)])/i)*(idx-(int)s));
							}else {
								d=(input[(int)s]-((input[(int)s]-input[0])/i)*(idx-(int)s));
							}
						}
					}
				}
				out[idx]+=(power*d);
				if((int)i==1) { 
					i=0;
				}
				if(layer==1) {
					i=(i*0.5);
					if((int)i==0) {
						i=1;
					}
				}else {
					i=i/2;
				}
			}
			out[idx]=out[idx]/sum;
			if(idx==0) {
			}
		}
		return out;
	}
	
	public double[][] getPerlin(double[][] input, double step) {
		double[][] out=new double[input.length][input[0].length];
		for(int idy=0;idy<input.length;idy++) {
			for(int idx=0;idx<input[idy].length;idx++) {
				int x1=-1,x2=-1,y1=-1,y2=-1;
				double power=1, sum=0, d=-1, n1=-1, n2=-1;
				for(double i=input[idy].length, layer=1;(int)i!=0; sum+=power, power=power*step,d=-1, layer++, x1=-1, x2=-1, y1=-1, y2=-1,n1=-1,n2=-1) {
					if(layer==1) {
						d=input[0][0];
					}else {
						for(double s=0;x1<0;s+=i) {
							if((s+i)>=idx) {
								if(((s+i)<input[idy].length)) {
									x1=(int)s;
									x2=(int)(s+i);
								}else {
									x1=(int)s;
									x2=0;
								}
							}
						}
						for(double s=0;y1<0;s+=i) {
							if((s+i)>=idy) {
								if(((s+i)<input.length)) {
									y1=(int)s;
									y2=(int)(s+i);
								}else {
									y1=(int)s;
									y2=0;
								}
							}
						}
						n1=(input[y1][x1]-((input[y1][x1]-input[y1][x2])/i)*(idx-x1));
						n2=(input[y2][x1]-((input[y2][x1]-input[y2][x2])/i)*(idx-x1));
						d=(n1-((n1-n2)/i)*(idy-y1));			
					}
					out[idy][idx]+=(power*d);
					if((int)i==1) { 
						i=0;
					}
					if(layer==1) {
						i=(i*0.5);
						if((int)i==0) {
							i=1;
						}
					}else {
						i=i/2;
					}
				}
				out[idy][idx]=out[idy][idx]/sum;
			}
		}
		return out;
	}
	
}
