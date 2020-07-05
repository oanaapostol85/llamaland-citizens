# Find the citizens of Llamaland to celebrate
Application input: 
- the path of the file containing the citizens of Llamaland supporting the monarchy
- the path of the file containing the citizens of Llamaland who are not supporting the monarchy

## File Content Example 
### Citizens of Llamaland supporting the monarchy  

    Brown,Bobby,10-11-1959,bobby.brown@ilovellamaland.com
    O'Rourke,Betsy,28-02-1900,betsy@heyitsme.com
    Von Tappo,Alfredo,01-01-1920,alfie@vontappo.llama.land   
    
### Citizens of Llamaland who are not supporting the monarchy  

    betsy@heyitsme.com
    randomperson@llama.land  
    
## Getting Started 
- Run the following commands in the project root:

      mvn clean package
      java -jar target/llamaland-citizens-1.0.0-SNAPSHOT.jar

- Enter the path of the file containing the citizens of Llamaland supporting the monarchy when prompted 
- Enter the path of the file containing the citizens of Llamaland who are not supporting the monarchy when prompted 
   
#### Run unit tests
- Run the following command in the project root:

      mvn test  