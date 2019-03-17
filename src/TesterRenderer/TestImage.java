package TesterRenderer;


import java.awt.Color;

import org.junit.Test;

import Renderer.ImageWriter;

public class TestImage {

	@Test
	public void test() {
		ImageWriter imageWriter = new ImageWriter("image test0", 500, 500, 500, 500);
		
		for(int i= 0; i<250; i++)
		{
			for(int j= 0; j<250; j++)
			{
				imageWriter.writePixel(i, j, Color.blue);
			}
		}
		for(int i= 250; i<500; i++)
		{
			for(int j= 250; j<500; j++)
			{
				imageWriter.writePixel(i, j, Color.GREEN);
			}
		}
		imageWriter.writeToimage();
		
	}
	@Test
	public void test1() {
		ImageWriter imageWriter = new ImageWriter("image test1", 500, 500, 500, 500);
		
		for(int i= 0; i<500; i++)
		{
			for(int j=0; j<i; j++)
			{
				imageWriter.writePixel(i, j, Color.orange);
			}
		}
		
		imageWriter.writeToimage();
		
	}
}
