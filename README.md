J-Ergast
========

A java implementation to get information of Ergast Developer Api.

This is just a simple wrapper. 
All the praises should be given to this amazing guys who provided us with a lot of data about F1 history. http://ergast.com/mrd/

Tell me more about the classes
--------------------------------------
I tried to keep the same objects that API gives you in json string. That means We have a good amount of classes, some of them are truly important and other not so. Somebody may say: "We can do it simpler". Yes, I agree with that but my main objective was building a generic wrapper to my own other projects. Maybe I will not use all features and possibilities but, who knows, maybe other people doing other stuff will use them. Let´s talk more deeply about important classes.
	- Season class: you get an object of this class when yo run this query: [Season List](http://ergast.com/mrd/methods/seasons). The code: [Season.java](https://github.com/felHR85/J-Ergast/blob/master/src/com/felipeDev/ErgastObjects/Season.java).

	- Race class: Without doubt this is the most important class. All data of a single race is here like season,round,wikipedia url,race name,circuit object information,date and time. These values are always in a race object but in some queries there are special values like: List of qualyfing results, list of laps, list of pitstops and list of results. You get a race object when you run these queries:
		- [Qualifying Results](http://ergast.com/mrd/methods/qualifying)
		- [Lap Times](http://ergast.com/mrd/methods/laps)
		- [Pit Stops](http://ergast.com/mrd/methods/pitstops)
		- [Race Results](http://ergast.com/mrd/methods/results)
	The code: [Race.java](https://github.com/felHR85/J-Ergast/blob/master/src/com/felipeDev/ErgastObjects/Race.java)	

	- Driver/Constructor: These classes are pretty straightforward. Info about a given driver or constructor. [Driver info](http://ergast.com/mrd/methods/drivers) [Constructor info](http://ergast.com/mrd/methods/constructors). The code: [Constructor.java](https://github.com/felHR85/J-Ergast/blob/master/src/com/felipeDev/ErgastObjects/Constructor.java) [Driver.java](https://github.com/felHR85/J-Ergast/blob/master/src/com/felipeDev/ErgastObjects/Driver.java)

	- Standing class: Base class of DriverStandings and ConstructorStandings. [Standings](http://ergast.com/mrd/methods/standings) The code: [Standings](https://github.com/felHR85/J-Ergast/blob/master/src/com/felipeDev/ErgastObjects/Standing.java)

	-

