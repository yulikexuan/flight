### How to run
1. This is a spring-boot project and it's original-folder name is "flight"
2. Use "mvn clean install" to rebuild this project
3. Use "mvn spring-boot:run" to run it 
4. Use "mvn verify" to run intergration test
5. URI: 
     - http://127.0.0.1:8080/api/v1/flights/2:31am
     - http://127.0.0.1:8080/api/v1/flights/6am

### Assumptions

1. There is no Time Zone being used

2. Each day has the same flights:
       - { "flight": "Air Canada 8099", "departure": "7:30AM" }, 
       - { "flight": "United Airline 6115", "departure": "10:30AM" }, 
       - { "flight": "WestJet 6456", "departure": "12:30PM" }, 
       - { "flight": "Delta 3833", "departure": "3:00PM" } 

3. Flight Distance:
     - Flight search algorithm will only display flights at a distance 
       (plus or minus) of 5 hours, **EXCLUSIVELY**
       For example:
         - If a departure time is 6:00am, then the distance window is 
           from 1:00am (**exclusive**) to 11:00am (**exclusive**)
           So, both of 1:01am and 10:59am are in the distance window for serach
           both of 1:00am and 11:00 are **NOT** in the distance window for 
           search