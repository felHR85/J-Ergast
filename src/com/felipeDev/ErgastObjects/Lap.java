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
 * <p>Information about timings in a given lap</p>
 * 
 * <b>Lap time data is available from the 2011 season onwards</b>
 * @author Felipe Herranz (felhr85@gmail.com)
 *
 */
public class Lap 
{
	private int number;
	private List<Timing> timings;
	
	
	public Lap(int number, List<Timing> timings) 
	{
		this.number = number;
		this.timings = timings;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public List<Timing> getTimings() {
		return timings;
	}


	public void setTimings(List<Timing> timings) {
		this.timings = timings;
	}
	
}
