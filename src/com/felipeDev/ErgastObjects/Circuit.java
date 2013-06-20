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
 * This class represents a circuit. It provides name, a wikipedia link and a object with info
 * about location
 * @author Felipe Herranz <felhr85@gmail.com>
 *
 */
public class Circuit 
{
	private String circuitId;
	/** Wikipedia page about this circuit */
	private String url;
	private String circuitName;
	private Location location;
	
	
	public Circuit(String circuitId, String url, String circuitName,
			Location location) 
	{
		this.circuitId = circuitId;
		this.url = url;
		this.circuitName = circuitName;
		this.location = location;
	}


	public String getCircuitId() 
	{
		return circuitId;
	}


	public void setCircuitId(String circuitId) 
	{
		this.circuitId = circuitId;
	}


	public String getUrl() 
	{
		return url;
	}


	public void setUrl(String url) 
	{
		this.url = url;
	}


	public String getCircuitName() 
	{
		return circuitName;
	}


	public void setCircuitName(String circuitName) 
	{
		this.circuitName = circuitName;
	}


	public Location getLocation() 
	{
		return location;
	}


	public void setLocation(Location location) 
	{
		this.location = location;
	}

	

}
