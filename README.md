J-Ergast
========

A java implementation to get information of Ergast Developer Api.

This is just a simple wrapper. 
All the praises should be given to this amazing guys who provided us with a lot of data about F1 history. http://ergast.com/mrd/

Tell me about the wrapper
--------------------------------------
I tried to keep the same objects that API gives you in json string. That means We have a good amount of classes, some of them are truly important and other not so. Somebody may say: "We can do it simpler". Yes, I agree with that but my main objective was building a generic wrapper to my own other projects. Maybe I will not use all features and possibilities but, who knows, maybe other people doing other stuff will use them. Let´s talk more deeply about important classes.
Some important classes
--------------------------------------
- Season class: you get an object of this class when yo run this query: [Season List](http://ergast.com/mrd/methods/seasons). The code: [Season.java](https://github.com/felHR85/J-Ergast/blob/master/src/com/felipeDev/ErgastObjects/Season.java).

- Race class: Without doubt this is the most important class(The code: [Race.java](https://github.com/felHR85/J-Ergast/blob/master/src/com/felipeDev/ErgastObjects/Race.java)). All data of a single race is here like season,round,wikipedia url,race name,circuit object information,date and time. These values are always in a race object but in some queries there are special values like: List of qualyfing results, list of laps, list of pitstops and list of results. You get a race object when you run these queries:
	- [Qualifying Results](http://ergast.com/mrd/methods/qualifying)
	- [Lap Times](http://ergast.com/mrd/methods/laps)
	- [Pit Stops](http://ergast.com/mrd/methods/pitstops)
	- [Race Results](http://ergast.com/mrd/methods/results)
- Driver/Constructor: These classes are pretty straightforward. Info about a given driver or constructor. [Driver info](http://ergast.com/mrd/methods/drivers) [Constructor info](http://ergast.com/mrd/methods/constructors). The code: [Constructor.java](https://github.com/felHR85/J-Ergast/blob/master/src/com/felipeDev/ErgastObjects/Constructor.java) [Driver.java](https://github.com/felHR85/J-Ergast/blob/master/src/com/felipeDev/ErgastObjects/Driver.java)

- Standing class: Base class of DriverStandings and ConstructorStandings. [Standings](http://ergast.com/mrd/methods/standings) The code: [Standings](https://github.com/felHR85/J-Ergast/blob/master/src/com/felipeDev/ErgastObjects/Standing.java)

- Status class: A finishing status code [Finishing status](http://ergast.com/mrd/methods/status) and the code: [Status.java](https://github.com/felHR85/J-Ergast/blob/master/src/com/felipeDev/ErgastObjects/Status.java)

Show me some code
--------------------------------------
First of all I will show the first common steps.
~~~
ErgastAPI api = new ErgastAPI();
api.setLimit(100); // the maximum number of values api will send us (default 30)
api.putValue(ErgastAPI.YEAR, "2008");
api.putValue(ErgastAPI.DRIVERS_TOKEN,"alonso");
// A simple query for a year 2008 and a single driver. Remember query parameters will be erased when you call a function.
~~~
If we want to know the seasons of Alonso in F1
~~~
api.putValue(ErgastAPI.DRIVERS_TOKEN,"alonso");
List<Season> seasons = api.getSeasons();
~~~
Or maybe all seasons in F1, in that case We dont need a query
~~~
List<Season> seasons = api.getSeasons();
~~~
Maybe you need first 60 seasons
~~~
api.setLimit(60);
List<Season> seasons60 = api.getSeasons();
~~~
You can use offset parameter
~~~
api.setLimit(30);
api.setOffset(10);
List<Season> seasonsWithOffset = api.getSeasons();
~~~
Do you remember those beautiful times of Alonso winning for Renault? I dont.
~~~
api.putValue(ErgastAPI.DRIVERS_TOKEN,"alonso");
api.putValue(ErgastAPI.CONSTRUCTORS_TOKEN, "renault");
List<Season> seasonsRenault = api.getSeasons();
~~~
Do you need data about Q1,Q2 and Q3 of round 5 of 2008 season?
~~~
api.putValue(ErgastAPI.YEAR,"2008");
api.putValue(ErgastAPI.ROUND, "5");
List<Race> races = api.getQualifyingOfRace();
~~~
Maybe You need those data but You dont need to know all the data about the race because You do really now them.
~~~
api.putValue(ErgastAPI.YEAR,"2008");
api.putValue(ErgastAPI.ROUND, "5");
List<Qualifying> pos = api.getQualifyingOfRace2();
~~~
You need to know information about races where Alonso get a second place with Ferrari
~~~
api.setLimit(100);
api.putValue(ErgastAPI.DRIVERS_TOKEN,"alonso");
api.putValue(ErgastAPI.CONSTRUCTORS_TOKEN, "ferrari");
List<Race> races = api.getResults(2);
~~~






