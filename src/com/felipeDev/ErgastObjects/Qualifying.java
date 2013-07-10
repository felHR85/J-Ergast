package com.felipeDev.ErgastObjects;

import java.util.List;
/**
 * This class just encapsulate qualifying results of a set of races.
 * @author Felipe Herranz (felhr85@gmail.com)
 *
 */
public class Qualifying 
{
	private List<Position> qualifyingResutls;

	public Qualifying(List<Position> qualifyingResutls) 
	{
		this.qualifyingResutls = qualifyingResutls;
	}

	public List<Position> getQualifyingResutls() {
		return qualifyingResutls;
	}

	public void setQualifyingResutls(List<Position> qualifyingResutls) {
		this.qualifyingResutls = qualifyingResutls;
	}
	
	
}
