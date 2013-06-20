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
 * A simple class to encapsulate information about the fastest lap of a driver
 * @author Felipe Herranz (felhr85@gmail.com)
 *
 */
public class FastestLap 
{
	private int rank;
	private int lap;
	private Time time;
	
	
	public FastestLap(int rank, int lap, Time time) 
	{
		this.rank = rank;
		this.lap = lap;
		this.time = time;
	}


	public int getRank() 
	{
		return rank;
	}


	public void setRank(int rank) 
	{
		this.rank = rank;
	}


	public int getLap() 
	{
		return lap;
	}


	public void setLap(int lap) 
	{
		this.lap = lap;
	}


	public Time getTime() 
	{
		return time;
	}


	public void setTime(Time time) 
	{
		this.time = time;
	}
	
	
	
	
	
	

}
