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
package com.felipeDev.ErgastApi;

import com.felipeDev.ErgastObjects.*;
import com.felipeDev.simpleJson.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * This facade-style class provides easy methods to get information of Ergast Developer API
 * More information about Ergast API <a href="http://ergast.com/mrd/"> here </a> 
 * @author Felipe Herranz (felhr85@gmail.com)
 *
 */
public class ErgastAPI 
{
	/** Limit of results returned in array fields (SeasonTable.Seasons, DriverTable.Drivers...) */
	private int limit;
	private int offset;
	/** Maximum number of elements available */
	private int total;
	
	//----TOKENS
	public final static String CIRCUITS_TOKEN = "circuits";
	public final static String CONSTRUCTORS_TOKEN = "constructors";
	public final static String DRIVERS_TOKEN = "drivers";
	public final static String GRID_TOKEN = "grid";
	public final static String RESULTS_TOKEN = "results";
	public final static String FASTESTS_TOKEN = "fastests";
	public final static String STATUS_TOKEN = "status";
	public final static String CONSTRUCTOR_STANDINGS_TOKEN = "constructorStandings";
	public final static String DRIVERS_STANDINGS_TOKEN = "driversStandings";
	public final static String PITSTOPS_TOKEN = "pitstops";
	public final static String CURRENT_TOKEN = "current";
	public final static String LAST_TOKEN = "last";
	
	// Termination files
	
	private QueryValues queryValues;
	
	public ErgastAPI()
	{
		this.limit = 30;
		this.offset = 0;
		this.queryValues = new QueryValues();
		
	}
	// Getters and setters
	
	public int getLimit() 
	{
		return limit;
	}

	public void setLimit(int limit) 
	{
		this.limit = limit;
	}

	public int getOffset() 
	{
		return offset;
	}

	public void setOffset(int offset) 
	{
		this.offset = offset;
	}

	public int getTotal() 
	{
		return total;
	}
	
	public void setTotal(int total)
	{
		this.total = total;
	}
	// Methods to set query parameters
	public void putValue(String key, String value)
	{
		queryValues.putString(key, value);
	}
	
	public String getValue(String key)
	{
		return queryValues.getString(key);
	}
	
	public void resetQuery()
	{
		queryValues.resetQuery();
	}
	
	/**
	 * 
	 * @return A list of selected seasons
	 */
	public List<Season> getSeasons()
	{
		String terminationFile = "seasons.json";
		String limitString = "?limit=" + String.valueOf(limit);
		String offsetString = "&offset=" + String.valueOf(offset);
		
		if(queryValues.isQuery()) // There is at least one parameter
		{
			List<String> keys = new ArrayList<String>();
			List<String> values = new ArrayList<String>();
			Iterator<String> e,t;
			queryValues.getParameters(keys, values);
			e = keys.iterator();
			t = values.iterator();
			String query = "";
			while(e.hasNext())
			{
				String key = e.next();
				String value = t.next();
				query = query + key + "/" + value + "/";
			}
			String finalString = query + terminationFile + limitString + offsetString;
			try 
			{
				String jsonResponse = APIConnection.getResponse(finalString);
				List<Season> seasons = JsonHandler.getSeasons(jsonResponse);
				return seasons;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return null;
			}
		}else // There is no parameters. So It performs the basic query. It lists all values
		{
			try 
			{
				String finalString = terminationFile + limitString + offsetString;
				String jsonResponse = APIConnection.getResponse(finalString);
				List<Season> seasons = JsonHandler.getSeasons(jsonResponse);
				return seasons;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
	}

	/**
	 * A class to handle connection with Ergast API. This nested class provides upper class with
	 * a response in json format
	 * @author Felipe Herranz (felhr85@gmail.com)
	 *
	 */
	private static class APIConnection
	{
		private final static String ERGAST_URI="http://ergast.com/api/f1/";
		
		private APIConnection()
		{
			
		}
		
		/**
		 * 
		 * @param A coherent String with the API guidelines, for example:
		 * "2010/status" or "current/constructorStandings"
		 * @return A string with the response, in json format
		 * @throws Exception, specifically IOException,MalformedURLException or a generic
		 * exception due to a HTTP Code != 200
		 */
		public static String getResponse(String query) throws Exception
		{
			StringBuilder totalString = new StringBuilder();
			String uriUrl = ERGAST_URI + query;
			URL url = new URL(uriUrl);
			URLConnection newConnection = url.openConnection();
			HttpURLConnection httpConnection = (HttpURLConnection) newConnection;
			int responseCode = httpConnection.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK)
			{
				InputStream dataFlow = httpConnection.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(dataFlow,"UTF-8"));
				String line;
				while((line = br.readLine()) != null)
				{
					totalString.append(line);
				}	
			}else
			{
				Exception e = new Exception("HTTP Code Error: " + String.valueOf(responseCode) + " URL: " + uriUrl);
				e.printStackTrace();
				throw e;
			}
			return totalString.toString();
		}
		
		
		
	}
	
	/**
	 * A class to deserialize json data to objects of the package com.felipeDev.ErgastObjects
	 * @author Felipe Herranz (felhr85@gmail.com)
	 *
	 */
	private static class JsonHandler
	{
		private final static String MR_DATA = "MRData";
		private final static String TOTAL = "total";
		private final static String SEASON_TABLE = "SeasonTable";
		private final static String SEASONS = "Seasons";
		private final static String SEASON = "season";
		private final static String URL = "url";
		private final static String RACE_TABLE = "RaceTable";
		private final static String RACES = "Races";
		private final static String ROUND = "round";
		private final static String RACE_NAME = "raceName";
		private final static String CIRCUIT = "Circuit";
		private final static String CIRCUIT_ID = "circuitId";
		private final static String CIRCUIT_NAME = "circuitName";
		private final static String LOCATION = "location";
		private final static String LAT = "lat";
		private final static String LONG = "long";
		private final static String LOCALITY = "locality";
		private final static String COUNTRY = "country";
		private final static String DATE = "date";
		private final static String TIME = "time";
		private final static String QUALIFYING_RESULTS = "QualifyingResults";
		private final static String NUMBER = "number";
		private final static String POSITION = "position";
		private final static String DRIVER = "driver";
		private final static String CONSTRUCTOR = "constructor";
		private final static String Q1 = "Q1";
		private final static String Q2 = "Q2";
		private final static String Q3 = "Q3";
		private final static String DRIVER_ID = "driverId";
		private final static String GIVEN_NAME = "givenName";
		private final static String FAMILY_NAME = "familyName";
		private final static String DATE_OF_BIRTH = "dateOfBirth";
		private final static String NATIONALITY = "nationality";
		private final static String CONSTRUCTOR_ID = "constructorId";
		private final static String NAME = "name";
		private final static String CONSTRUCTOR_TABLE = "ConstructorTable";
		private final static String CONSTRUCTORS = "Constructors";
		private final static String TIMINGS = "Timings";
		private final static String LAPS = "Laps";
		
		private JsonHandler()
		{
			
		}
		
		// ===========================================================
		// Season methods
		// ===========================================================
		/**
		 * A json response from API to a List of Season objects
		 * @param A string with a json response from API
		 * @return A list of Season objects
		 */
		public static List<Season> getSeasons(String jsonResponse)
		{
			List<Season> seasonList;
			JSONObject o = getJsonObject(jsonResponse);
			JSONObject mrData = getJsonObject(o,MR_DATA);
			JSONObject seasonTable = getJsonObject(mrData,SEASON_TABLE);
			JSONArray seasons = getJsonArray(seasonTable,SEASONS);
			int lengthArray = seasons.size();
			seasonList = new ArrayList<Season>(lengthArray);
			for(int i = 0;i <= lengthArray -1;i++)
			{
				JSONObject element = getJsonObject(seasons,i);
				int year = Integer.parseInt((String) element.get(SEASON));
				String url = (String) element.get(URL);
				seasonList.add(new Season(year,url));
			}
			return seasonList;
		}
		
		/**
		 * APi returns data of qualifying results embedded in a Race object, in a
		 * field called "qualifyingResults". This method returns the Race object. If you
		 * want only Results. Use getQualifyingResults2
		 * @param jsonResponse
		 * @return Race object
		 */
		public static Race getQualifyingResults(String jsonResponse)
		{
			JSONObject o = getJsonObject(jsonResponse);
			Race race = getRaceObject(o);
			JSONObject mrData = getJsonObject(o,MR_DATA);
			JSONObject raceTable = getJsonObject(mrData,RACE_TABLE);
			JSONArray races = getJsonArray(raceTable,RACES);
			JSONObject singleRace = getJsonObject(races,0);
			JSONArray qualifying = getJsonArray(singleRace,QUALIFYING_RESULTS);
			List<Position> qResults = getQualifyingResultsList(qualifying);
			race.setQualifyingResults(qResults);			
			return race;
		}
		/**
		 * It return just qualifying data, ignoring race information
		 * @param jsonResponse
		 * @return List of Position objects
		 */
		public static List<Position> getQualifyingResults2(String jsonResponse)
		{
			Race race = getQualifyingResults(jsonResponse);
			return race.getQualifyingResults();
		}
		/**
		 * This methods returns information about constructors.
		 * @param jsonResponse
		 * @return List of constructor objects
		 */
		public static List<Constructor> getConstructorInformation(String jsonResponse)
		{
			JSONObject o = getJsonObject(jsonResponse);
			JSONObject mrData = getJsonObject(o,MR_DATA);
			JSONObject constructorTable = getJsonObject(mrData,CONSTRUCTOR_TABLE);
			JSONArray constructorsArray = getJsonArray(constructorTable,CONSTRUCTORS);
			int length = constructorsArray.size();
			List<Constructor> list = new ArrayList<Constructor>(length);
			for(int i=0;i<= length -1;i++)
			{
				list.add(getConstructorObject(getJsonObject(constructorsArray,i)));
			}
			return list;
			
		}
		/**
		 * This method returns information about laps of a single race. Lap information
		 * appears embedded in a Race object.
		 * @param jsonResponse
		 * @return
		 */
		public static Race getLaps1(String jsonResponse)
		{
			JSONObject o = getJsonObject(jsonResponse);
			Race race = getRaceObject(o);
			JSONObject mrData = getJsonObject(o,MR_DATA);
			JSONObject raceTable = getJsonObject(mrData,RACE_TABLE);
			JSONArray races = getJsonArray(raceTable,RACES);
			JSONObject singleRace = getJsonObject(races,0);
			JSONArray arrayLaps = getJsonArray(singleRace,LAPS);
			race.setLaps(getLapList(arrayLaps));
			return race;
		}
		/**
		 * Information about laps of a single race.
		 * @param jsonResponse
		 * @return
		 */
		public static List<Lap> getLaps2(String jsonResponse)
		{
			Race race = getLaps1(jsonResponse);
			return race.getLaps();
		}
		
		// ===========================================================
		// Private methods
		// ===========================================================
		
		private static JSONObject getJsonObject(String jsonResponse)
		{
			JSONObject o = (JSONObject) JSONValue.parse(jsonResponse);
			return o;
		}
		
		private static JSONObject getJsonObject(JSONObject o,String field)
		{
			JSONObject obj = (JSONObject) o.get(field);
			return obj;
		}
		
		private static JSONObject getJsonObject(JSONArray array,int index)
		{
			JSONObject obj = (JSONObject) array.get(index);
			return obj;
		}
		
		private static JSONArray getJsonArray(JSONObject o,String field)
		{
			JSONArray array = (JSONArray) o.get(field);
			return array;
		}
		
		private static Race getRaceObject(JSONObject o)
		{
			JSONObject mrData = getJsonObject(o,MR_DATA);
			JSONObject raceTable = getJsonObject(mrData,RACE_TABLE);
			JSONArray races = getJsonArray(raceTable,RACES);
			// It will be an array with just one object
			JSONObject race = getJsonObject(races,0);
			
			int season = Integer.parseInt((String) race.get(SEASON));
			int round = Integer.parseInt((String) race.get(ROUND));
			String url = (String) race.get(URL);
			String raceName = (String) race.get(RACE_NAME);
			String date = (String) race.get(DATE);
			String time = (String) race.get(TIME);
			
			JSONObject circuit = getJsonObject(race,CIRCUIT);
			String circuitId = (String) circuit.get(CIRCUIT_ID);
			String urlCircuit = (String) circuit.get(URL);
			String circuitName = (String) circuit.get(CIRCUIT_NAME);
			
			
			JSONObject location = getJsonObject(circuit,LOCATION);
			float lat = Float.valueOf((String) location.get(LAT));
			float longitude = Float.valueOf((String) location.get(LONG));
			String locality = (String) location.get(LOCALITY);
			String country = (String) location.get(COUNTRY);
			Location loc = new Location(lat,longitude,locality,country); 
			
			Circuit circ = new Circuit(circuitId,urlCircuit,circuitName,loc);
			Race raceObj = new Race(season,round,url,raceName,circ,date,time);
			return raceObj;
		}
		
		private static List<Position> getQualifyingResultsList(JSONArray o)
		{
			int lengthArray = o.size();
			List<Position> qualifyingR = new ArrayList<Position>(lengthArray);
			for(int i = 0;i<= lengthArray -1;i++)
			{
				JSONObject positionObj = getJsonObject(o,i);//(JSONObject) o.get(i);
				int number = Integer.parseInt((String) positionObj.get(NUMBER));
				int pos = Integer.parseInt((String) positionObj.get(POSITION));
				Driver driver = getDriverObject((JSONObject) positionObj.get(DRIVER));
				Constructor constructor = getConstructorObject((JSONObject) positionObj.get(CONSTRUCTOR));
				float q1 = Float.parseFloat((String) positionObj.get(Q1));
				float q2 = Float.parseFloat((String) positionObj.get(Q2));
				float q3 = Float.parseFloat((String) positionObj.get(Q3));
				qualifyingR.add(new Position(number,pos,driver,constructor,q1,q2,q3));
			}
			return qualifyingR;
		}
		
		private static Driver getDriverObject(JSONObject driverObj)
		{
			String driverId = (String) driverObj.get(DRIVER_ID);
			String url = (String) driverObj.get(URL);
			String givenName = (String) driverObj.get(GIVEN_NAME);
			String familyName = (String) driverObj.get(FAMILY_NAME);
			String dateOfBirth = (String) driverObj.get(DATE_OF_BIRTH);
			String nationality = (String) driverObj.get(NATIONALITY);
			return new Driver(driverId,url,givenName,familyName,dateOfBirth,nationality);
		}
		
		private static Constructor getConstructorObject(JSONObject constructorObj)
		{
			String constructorId = (String) constructorObj.get(CONSTRUCTOR_ID);
			String url = (String) constructorObj.get(URL);
			String name = (String) constructorObj.get(NAME);
			String nationality = (String) constructorObj.get(NATIONALITY);
			return new Constructor(constructorId,url,name,nationality);
		}
		
		private static List<Lap> getLapList(JSONArray arrayLap)
		{
			int lengthArray = arrayLap.size();
			List<Lap> laps = new ArrayList<Lap>(lengthArray);
			List<Timing> timingsList;
			for(int i = 0;i<=lengthArray -1;i++)
			{
				JSONObject lap = getJsonObject(arrayLap,i);
				int number = Integer.parseInt((String) lap.get(NUMBER));
				JSONArray timings = getJsonArray(lap,TIMINGS);
				int lengthTimings = timings.size();
				timingsList = new ArrayList<Timing>(lengthTimings);
				for(int j = 0;j<=lengthTimings -1;j++)
				{
					timingsList.add(getTimingObject(getJsonObject(timings,j)));
				}
				laps.add(new Lap(number,timingsList));
			}
			return laps;
		}
		
		
		private static Timing getTimingObject(JSONObject timings)
		{
			String driverId = (String) timings.get(DRIVER_ID);
			int position = Integer.parseInt((String) timings.get(POSITION));
			String time = (String) timings.get(TIME);
			return new Timing(driverId,position,time);
		}
	}
	/**
	 * This class handles all query values
	 * @author Felipe Herranz (felhr85@gmail.com)
	 *
	 */
	private class QueryValues
	{
		private HashMap<String,String> queryValues;
		private int numberOfParameters = 7;
		private boolean isQuery;
		
		public QueryValues()
		{
			queryValues = new HashMap<String,String>(numberOfParameters);
			putValuesToNull();
			isQuery = false;
		}

		public boolean isQuery() 
		{
			return isQuery;
		}
		
		public void putString(String key,String value)
		{
			queryValues.put(key, value);
			if(isQuery == false)
			{
				isQuery = true;
			}
			
		}
		
		public String getString(String key)
		{
			return queryValues.get(key);
		}
		
		public void resetQuery()
		{
			putValuesToNull();
			isQuery = false;
		}
		
		public void getParameters(List<String> keys, List<String> values)
		{
			for(Map.Entry<String, String> entry : queryValues.entrySet() )
			{
				String key = entry.getKey();
				String value = entry.getValue();
				if(value != null)
				{
					keys.add(key);
					values.add(value);
				}
			}
			resetQuery();
		}
		
		private void putValuesToNull()
		{
			queryValues.put(CIRCUITS_TOKEN, null);
			queryValues.put(CONSTRUCTORS_TOKEN, null);
			queryValues.put(DRIVERS_TOKEN, null);
			queryValues.put(GRID_TOKEN, null);
			queryValues.put(RESULTS_TOKEN, null);
			queryValues.put(FASTESTS_TOKEN, null);
			queryValues.put(STATUS_TOKEN, null);
		}
		
			
		
	}

}
