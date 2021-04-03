# P9_patient Backend
This application is a medical web services application, il allows CRUD operations for a Patient : 
1. Create a Patient
2. Update a patient
3. Delete a Patient
4. Get a Patient
5. Get all Patients


## Technical:
1. Framework: Spring Boot v2.2.5
2. Java 8
3. MySQL 8.X and H2 for tests
4. Maven 3.6
5. Hibernate is used for the domain, but not used to init database object (please run script_data.sql)


## Setup 
1. Setup a database MySQL with "p9ocr" schema for developements and tests
2. Run script script_data.sql to create tables and users
3. Install Java: https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html
4. Spring : https://spring.io


## Docker
The Docker file has been set, this application is enabled for Docker

Docker commands are (type from root folder P9_patient): 
1. Build the image : "docker build --tag patient ."
2. Run the image : "docker run -p 8045:8045 patient"
3. Stop the image  : "docker stop patient ."
4. Remove the image :  "docker rmi -f patient"


## Unit Test
1. Unit tests are written for Utils, Domain, Repository and Controller
2. Integration tests are written for controller


# Maven
1. mvn clean install
2. mvn clean verify  : generate tests and tests reports
3. mvn site  : generate all reportings
4. mvn spring-boot:run (run app)
5. mvn spring-boot:stop (stop app) 


## Run & tests
1. Run P9PatientApplication
2. Open in a browser http://localhost:8045 for test environment


### Other consideration
JAVADOC has been initialized and needs to be completed.
JASYPT tuto : https://www.geeksforgeeks.org/how-to-encrypt-passwords-in-a-spring-boot-project-using-jasypt/
JASYPT Online encryption tool : https://www.devglan.com/online-tools/jasypt-online-encryption-decryption (secret key 123456)
JASYPT https://blog.impulsebyingeniance.io/utilisation-de-jasypt-sous-spring-boot/