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
 * A class to represents information of a driver
 * @author Felipe Herranz (felhr85@gmail.com)
 *
 */
public class Driver 
{
	private String driverId;
	private String url;
	private String givenName;
	private String familyName;
	private String dateOfBirth;
	private String nationality;
	
	
	public Driver(String driverId, String url, String givenName,
			String familyName, String dateOfBirth, String nationality)
	{
		this.driverId = driverId;
		this.url = url;
		this.givenName = givenName;
		this.familyName = familyName;
		this.dateOfBirth = dateOfBirth;
		this.nationality = nationality;
	}


	public String getDriverId() 
	{
		return driverId;
	}


	public void setDriverId(String driverId)
	{
		this.driverId = driverId;
	}


	public String getUrl() 
	{
		return url;
	}


	public void setUrl(String url) 
	{
		this.url = url;
	}


	public String getGivenName() 
	{
		return givenName;
	}


	public void setGivenName(String givenName) 
	{
		this.givenName = givenName;
	}


	public String getFamilyName() 
	{
		return familyName;
	}


	public void setFamilyName(String familyName)
	{
		this.familyName = familyName;
	}


	public String getDateOfBirth() 
	{
		return dateOfBirth;
	}


	public void setDateOfBirth(String dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
	}


	public String getNationality()
	{
		return nationality;
	}


	public void setNationality(String nationality) 
	{
		this.nationality = nationality;
	}
	
	
	
	

}
