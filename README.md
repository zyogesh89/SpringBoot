# POC

This application bases on spring boot microservice architecture with following microservices.

1. Eureka service (http://localhost:8411/) : 
	
	Eureka Server is an application that holds the information about all client-service applications. 
	Every Micro service will register into the Eureka server and Eureka server knows all the client applications running on each port and IP address. 
	Eureka Server is also known as Discovery Server.

2. Strore Service 
	
   Store service is an application that holds all business requiremnets
   
   a. GET call :  http://localhost:8420/product/all 
		Responce :
					[
						{
							"productId": 1,
							"productCode": "P1",
							"productName": "BMW",
							"productPoints": 10
						},
						{
							"productId": 2,
							"productCode": "P2",
							"productName": "Benz",
							"productPoints": 20
						},
						{
							"productId": 3,
							"productCode": "P3",
							"productName": "Maruti Suzuki Baleno",
							"productPoints": 30
						},
						{
							"productId": 4,
							"productCode": "P4",
							"productName": "Hyundai Elite i20",
							"productPoints": 40
						},
						{
							"productId": 5,
							"productCode": "P5",
							"productName": "Land Rover",
							"productPoints": 50
						}
					]
      b. POST call :   http://localhost:8420/purchase
			Request : 
						{
						"customerId" : 1,
						"products" :[4,5]
					}
					
							
			Responce (According to inputs):
					i.   OK : Success
					ii.  Not have enough points  
					iii. FAILED
					iv.  Please add atleast one product
					V.   Customer does not exist in store
					VI.  Please select existing product	
					
					
3. Zuul service
				Spring Cloud has created an embedded Zuul proxy to ease the development of a common use case where a UI application wants to make proxy calls to one or more back end services. 
				This feature is useful for a user interface to proxy to the back end services it requires, avoiding the need to manage CORS and authentication concerns independently for all the back ends.
						
			 a. GET call :   http://localhost:8401/yogesh/store/product/all 
		Responce :
					[
						{
							"productId": 1,
							"productCode": "P1",
							"productName": "BMW",
							"productPoints": 10
						},
						{
							"productId": 2,
							"productCode": "P2",
							"productName": "Benz",
							"productPoints": 20
						},
						{
							"productId": 3,
							"productCode": "P3",
							"productName": "Maruti Suzuki Baleno",
							"productPoints": 30
						},
						{
							"productId": 4,
							"productCode": "P4",
							"productName": "Hyundai Elite i20",
							"productPoints": 40
						},
						{
							"productId": 5,
							"productCode": "P5",
							"productName": "Land Rover",
							"productPoints": 50
						}
					]
      b. POST call :     http://localhost:8401/yogesh/store/purchase
			Request : 
						{
						"customerId" : 1,
						"products" :[4,5]
					}
					
							
			Responce (According to inputs):
					i.   OK : Success
					ii.  Not have enough points  
					iii. FAILED
					iv.  Please add atleast one product
					V.   Customer does not exist in store
					VI.  Please select existing product			
					
					
4. Deployment with excutable jar(Linux server) This enclude load balancing

		a. startupServices.sh
		
		nohup  java -Dspring.profiles.active=dev -jar eureka-service-0.0.1-SNAPSHOT.jar >  /logs/eureka-service.log 2>&1 &
		nohup  java -Dspring.profiles.active=dev -jar store-service-0.0.1-SNAPSHOT.jar >  /logs/store-service.log 2>&1 &
		
		nohup  java -Dspring.profiles.active=dev -Dserver.port=8412 -jar eureka-service-0.0.1-SNAPSHOT.jar >  /logs/eureka-service-8412.log 2>&1 &
		nohup  java -Dspring.profiles.active=dev -Dserver.port=8432 -jar store-service-0.0.1-SNAPSHOT.jar >  /logs/store-service-8432.log 2>&1 &

		nohup  java -Dspring.profiles.active=dev -jar zuul-service-0.0.1-SNAPSHOT.jar  >  /logs/fazuul-service.log 2>&1 &
				
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					