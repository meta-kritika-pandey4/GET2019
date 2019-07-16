package com.metacube.get2019;

/**
 * It is a class that calculates
 * area of various shapes
 * @admin Kritika
 */
public class Area{
	
	private double area;
	
	/**
	 * It is a method used to find the area of triangle
	 * @param height
	 * @param width
	 * @return area
	 */
	public double triangleArea(double height,double width){
		area=(height*width)/2;
		return area;
	}
	
	/**
	 * It is a method used to find the area of square
	 * @param width
	 * @return area
	 */
	public double squareArea(double width){
		area=width*width;
		return area;
	}
	
	/**
	 * It is a method used to find the area of rectangle
	 * @param height
	 * @param width
	 * @return area
	 */
	public double rectangleArea(double height,double width){
		area=height*width;
		return area;
	}
	
	/**
	 * It is a method used to find the area of circle
	 * @param radius
	 * @return area
	 */
	public double circleArea(double radius){
		area=3.14*radius*radius;
		return area;
	}
}
	
	
					
			
			