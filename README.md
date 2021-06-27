# DaDataAddressesIntegration
<div>Spring Boot 2.5.1</div><br/>
<div>MongoDB 4.4,6</div><br/>

<div>The application is a small REST service. It is possible to request any
an address and the application use the API DaData for returning a clear address.
Next, it will save the given address to the Mongo database and return request id,
generated Mongo. Also, it is possible to contact the service by request id and get
the saved address.</div><br/>
<div>Before starting the project, you should start your mongo server.</div>
<div>For running this project use maven.</div>
<div>For build the project,go to directory with the project and run this command:</div>

```
mvn compile
```

<div>And for runing the project, run the command:</div>

```
mvn exec:java -Dexec.mainClass="com.exchristmas.dadataaddressesintegration.DaDataAddressesIntegrationApplication"
```

<div>Results HTTP requests:</div>
![Alt-текст]()
![Alt-текст]()
![Alt-текст]()