# datarepublic-client
Client repo for querying datarepublic restful api

## how to running
1. download the client jar file
2. use the command below to query the api
``` 
java -jar DataRepublicClient.jar -i -url 54.206.58.168:8080 -med 8F0A1E787329C1C08F8F9120EE68E056,A0B5AF0F9B31690CEBB51ECD27D2BE71 -date 2013-12-06 
```
* -i -- means if ignore cache, 
* -url -- gives the server address, leave blank will using localhost as default, you can deploy [server](https://github.com/Xingyuj/datarepublic-server) locally or use the default address provided which is a AWS Ec2 which deploied the server.
* -med -- is medallions need to be queried, you can input as many as you want using ',' to split them.
* -date -- requiring date
