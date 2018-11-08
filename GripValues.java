package org.usfirst.frc.team3630.robot;

import java.util.ArrayList;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;

public class GripValues 
{
	private double centerX;
	private double centerY;
	private double area;
	private double height;
	private double width;
	public Mat inputImage = new Mat();
	private int size;
	private MatOfPoint contour;
	
	public GripValues()
	{
		
	}
	
	public void getValues()
	{
		setValues(); //sets needed values, the process should end and the RIOis not forced to make the calculations all the time - do we need them during teleop?
		for(int i = 0; i<size; i++)
		{
			contour = Robot.contours.get(i);
			Rect r = Imgproc.boundingRect(contour);
			centerX = r.x + r.width/2;
			centerY = r.y + r.height/2;
			area = Imgproc.contourArea(contour);
			height = r.height;
			width = r.width;
		}
	}
	
	public void setValues()
	{
		Robot.pipeline.process(Robot.source);
		Robot.contours = Robot.pipeline.filterContoursOutput();
		size = Robot.contours.size();
	}
}
