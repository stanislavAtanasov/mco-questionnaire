First you need to run mvn initialize flyway:migrate clean install -Pgenerate-sources  
this is for genereting your DB, your jooq components ,mappers and etc.

Since this is a Spring Boot application you should execute java -jar /target/build.jar
0.get the repo and unrar it 
1. mvn initialize flyway:migrate clean install -Pgenerate-sources 
2.mvn install
3.java -jar .\target\mco-0.0.1-SNAPSHOT.jar
4. go to http://localhost:8085 
