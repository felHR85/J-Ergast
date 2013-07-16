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
 */package com.felipeDev.ErgastObjects;
/**
 * <p>This class gives information about a given position in Qualifying sessions. It contains the number of the
 * driver who achieve it, the number that He wears and objects with more information about the driver itself and constructor
 * Also contains the best lap times in each Q</p>
 * <b>Note: Qualifying results are only fully supported from the 2003 season onwards.</b>
 * @author Felipe Herranz (felhr85@gmail.com)
 *
 */
public class Position 
{
	private int number;
	private int position;
	private Driver driver;
	private Constructor constructor;
	/** Best time in Q1 */
	private String q1;
	/** Best time in Q2*/
	private String q2;
	/** Best time in Q3*/
	private String q3;
	
	
	public Position(int number, int position, Driver driver,
			Constructor constructor, String q1, String q2, String q3) 
	{
		this.number = number;
		this.position = position;
		this.driver = driver;
		this.constructor = constructor;
		this.q1 = q1;
		this.q2 = q2;
		this.q3 = q3;
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


	public String getQ1() 
	{
		return q1;
	}


	public void setQ1(String q1)
	{
		this.q1 = q1;
	}


	public String getQ2() 
	{
		return q2;
	}


	public void setQ2(String q2) 
	{
		this.q2 = q2;
	}


	public String getQ3() 
	{
		return q3;
	}


	public void setQ3(String q3)
	{
		this.q3 = q3;
	}
	
	
	
	
	

}
