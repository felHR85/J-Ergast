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

import java.util.List;

public class StandingList 
{
	private int season;
	private int round;
	private List<Standing> standings;
	
	
	public StandingList(int season, int round, List<Standing> standings) 
	{
		this.season = season;
		this.round = round;
		this.standings = standings;
	}


	public int getSeason() 
	{
		return season;
	}


	public void setSeason(int season)
	{
		this.season = season;
	}


	public int getRound() 
	{
		return round;
	}


	public void setRound(int round) 
	{
		this.round = round;
	}


	public List<Standing> getStandings() 
	{
		return standings;
	}


	public void setStandings(List<Standing> standings) 
	{
		this.standings = standings;
	}
	
	
	
	
	
	
	

}
