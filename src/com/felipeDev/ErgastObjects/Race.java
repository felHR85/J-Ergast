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

import java.util.List;
/**
 * This class provides information about a single race (for example 2011 Spanish Grand Prix)
 * A lot of queries return a race object even if what you are searching is,for example, a list of PitStops
 * in a given race. In this cases the pitStops are embedded in the race object and must be initialized using
 * setters.
 * @author Felipe Herranz (felhr85@gmail.com)
 *
 */
public class Race 
{
	// Basic data of a single race
	private int season;
	
	/** Australian GP round 1; Malaysian GP round 2 ... */
	private int round;
	/** Wikipedia page of this race*/
	
	private String url;
	private String raceName;
	private Circuit circuit;
	private String date;
	private String time;
	
	// This data does not always appear in queries. It usually appears when you search about Qualifying
	private List<Position> qualifyingResults;
	
	// This data does not always appear in queries. It usually appears when you search about Lap Times.
	private List<Lap> laps;
	
	// This data does not always appear in queries. It usually appears when you search about Pit Stops.
	private List<PitStop> pitStops;
	
	// This data does not always appear in queries. It usually appears when you search about Race Results.
	private List<Result> results;
	
	public Race(int season, int round, String url, String raceName,
			Circuit circuit, String date, String time) 
	{
		this.season = season;
		this.round = round;
		this.url = url;
		this.raceName = raceName;
		this.circuit = circuit;
		this.date = date;
		this.time = time;
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

	public String getUrl() 
	{
		return url;
	}

	public void setUrl(String url) 
	{
		this.url = url;
	}

	public String getRaceName() 
	{
		return raceName;
	}

	public void setRaceName(String raceName) 
	{
		this.raceName = raceName;
	}

	public Circuit getCircuit() 
	{
		return circuit;
	}

	public void setCircuit(Circuit circuit)
	{
		this.circuit = circuit;
	}

	public String getDate() 
	{
		return date;
	}

	public void setDate(String date)
	{
		this.date = date;
	}

	public String getTime() 
	{
		return time;
	}

	public void setTime(String time) 
	{
		this.time = time;
	}

	public List<Position> getQualifyingResults() 
	{
		return qualifyingResults;
	}

	public void setQualifyingResults(List<Position> qualifyingResults) 
	{
		this.qualifyingResults = qualifyingResults;
	}

	public List<Lap> getLaps() 
	{
		return laps;
	}

	public void setLaps(List<Lap> laps) 
	{
		this.laps = laps;
	}

	public List<PitStop> getPitStops() 
	{
		return pitStops;
	}

	public void setPitStops(List<PitStop> pitStops) 
	{
		this.pitStops = pitStops;
	}

	public List<Result> getResults() 
	{
		return results;
	}

	public void setResults(List<Result> results)
	{
		this.results = results;
	}
	
	
	
	
	
	
	
	
	

}
