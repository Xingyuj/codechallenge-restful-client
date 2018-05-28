# codechallenge-restful-client
Client repo for querying datarepublic restful api

## How to run
1. download the client jar file
2. use the command below to query cabs count given medallions and pickup date
``` 
java -jar DataRepublicClient.jar -i -url 54.206.58.168:8080 -med 8F0A1E787329C1C08F8F9120EE68E056,A0B5AF0F9B31690CEBB51ECD27D2BE71 -date 2013-12-06 
```
or use browser to visit following url to query cabs count given medallions and pickup date
```
http://54.206.58.168:8080/cabs?medallions=8F0A1E787329C1C08F8F9120EE68E056,A0B5AF0F9B31690CEBB51ECD27D2BE71&pickup_date=2013-12-06&cached=true
```
3. use the command below to clear cache
``` 
java -jar DataRepublicClient.jar -url 54.206.58.168:8080 -clear
```
or use browser to visit following url to clear cache
```
http://54.206.58.168:8080/clearcache
```
* -i -- with this means ignore cache
* -url -- gives the server address, omit this will use localhost:8080 as default, you can deploy [server](https://github.com/Xingyuj/datarepublic-server) locally or use the default address provided which is a AWS Ec2 which deployed the server.
* -med -- is medallions need to be queried, you can input as many as you want using ',' to split them.
* -date -- requiring pickup date
