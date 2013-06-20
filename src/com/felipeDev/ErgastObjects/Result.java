/*
 The MIT License (MIT)

Copyright (c) 2013 Felipe Herranz<felhr85@gmail.com>

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
 * This class represents the result of a single driver in a GP.
 * @author Felipe Herranz (felhr85@gmail.com)
 *
 */
public class Result 
{
	private int number;
	private int position;
	private String positionText;
	private int points;
	private Driver driver;
	private Constructor constructor;
	private int grid;
	private int lap;
	private String status;
	private Time time;
	private FastestLap fastestLap;
	private AverageSpeed averageSpeed;
	
	public Result(int number, int position, String positionText, int points,
			Driver driver, Constructor constructor, int grid, int lap,
			String status, Time time, FastestLap fastestLap,
			AverageSpeed averageSpeed) 
	{
		this.number = number;
		this.position = position;
		this.positionText = positionText;
		this.points = points;
		this.driver = driver;
		this.constructor = constructor;
		this.grid = grid;
		this.lap = lap;
		this.status = status;
		this.time = time;
		this.fastestLap = fastestLap;
		this.averageSpeed = averageSpeed;
	}


	public int getNumber() 
	{
		return number;
	}


	public void setNumber(int number) 
	{
		this.number = number;
	}


	public int getPosition() 
	{
		return position;
	}


	public void setPosition(int position) 
	{
		this.position = position;
	}


	public String getPositionText() 
	{
		return positionText;
	}


	public void setPositionText(String positionText)
	{
		this.positionText = positionText;
	}


	public int getPoints()
	{
		return points;
	}


	public void setPoints(int points) 
	{
		this.points = points;
	}


	public Driver getDriver()
	{
		return driver;
	}


	public void setDriver(Driver driver)
	{
		this.driver = driver;
	}


	public Constructor getConstructor() 
	{
		return constructor;
	}


	public void setConstructor(Constructor constructor)
	{
		this.constructor = constructor;
	}


	public int getGrid() 
	{
		return grid;
	}


	public void setGrid(int grid)
	{
		this.grid = grid;
	}


	public int getLap()
	{
		return lap;
	}


	public void setLap(int lap) 
	{
		this.lap = lap;
	}


	public String getStatus() 
	{
		return status;
	}


	public void setStatus(String status) 
	{
		this.status = status;
	}


	public Time getTime() 
	{
		return time;
	}


	public void setTime(Time time) 
	{
		this.time = time;
	}


	public FastestLap getFastestLap() 
	{
		return fastestLap;
	}


	public void setFastestLap(FastestLap fastestLap) 
	{
		this.fastestLap = fastestLap;
	}


	public AverageSpeed getAverageSpeed() 
	{
		return averageSpeed;
	}


	public void setAverageSpeed(AverageSpeed averageSpeed) 
	{
		this.averageSpeed = averageSpeed;
	}
	
	
	
	
	
		
}
