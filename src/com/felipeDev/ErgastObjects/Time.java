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
 * A simple class to encapsulate the time achieve by a driver in a Grand Prix.
 * @author Felipe Herranz (felhr85@gmail.com)
 *
 */
public class Time 
{
	private float millis;
	private String time;
	
	
	public Time(float millis, String time)
	{
		this.millis = millis;
		this.time = time;
	}


	public float getMillis() 
	{
		return millis;
	}


	public void setMillis(float millis) 
	{
		this.millis = millis;
	}


	public String getTime() 
	{
		return time;
	}


	public void setTime(String time) 
	{
		this.time = time;
	}
	
	
	
	
	
	

}
