First you need to run mvn initialize flyway:migrate clean install -Pgenerate-sources  
this is for genereting your DB, your jooq components ,mappers and etc.


0.get the clone the repo 
https://github.com/stanislavAtanasov/mco-questionnaire.git
1.you need to genere DB, jooq,mappers and etc so execute 
mvn initialize flyway:migrate clean install -Pgenerate-sources 
2. You need to prepare your jar
mvn install
3.Since this is a Spring Boot application you should execute java -jar /target/build.jar
java -jar .\target\mco-0.0.1-SNAPSHOT.jar
4. Go to brawser and have fun
http://localhost:8085 
