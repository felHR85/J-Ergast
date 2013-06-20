/*
 The MIT License (MIT)

Copyright (c) 2013 Felipe Herranz<felipe.herranz@gmail.com>

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 */
package com.felipeDev.ErgastObjects;
/**
 * A simple class to encapsulate information about average speed of a driver
 * @author Felipe Herranz (felhr85@gmail.com)
 *
 */
public class AverageSpeed 
{
	private String units;
	private float speed;
	
	
	public AverageSpeed(String units, float speed) 
	{
		this.units = units;
		this.speed = speed;
	}


	public String getUnits() 
	{
		return units;
	}


	public void setUnits(String units) 
	{
		this.units = units;
	}


	public float getSpeed() 
	{
		return speed;
	}


	public void setSpeed(float speed) 
	{
		this.speed = speed;
	}
	
	
	
	

}
