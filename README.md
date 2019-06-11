Spring Boot V2 JMX : Toggling Features
Adding Toggling features to Spring boot rest api  .  follow  these  three  steps  
  1. create a java class with  @EnableMBeanExport  for JMX initialization  
      @Configuration
      @EnableMBeanExport
      public class JMXFeaturesTogglingConfiguration {
              // this is empty class , used for just enabling the Mbean
       }
  2. create a java to enable the toggling 
  
  example: 

        package com.springboot.v2.intercetors;

        import org.springframework.context.annotation.Configuration;
        import org.springframework.context.annotation.EnableMBeanExport;

        @Configuration
        @EnableMBeanExport
        public class JMXFeaturesTogglingConfiguration {
         // this is empty class , used for just enabling the Mbean
        }
  
 3.   Create a java class with @ManagedResource(objectName = "PD:category=MBeans,name=togglingFeaturesMbean", description = "Get/Set log         level for the category specified", log = true, logFile = "jmx-platform.log")

           2.1  objectname can include type 
           example : "MbeanExample:type=exampleModelBean" or PD:category  "PD:category=MBeans,name=togglingFeaturesMbean"
           2.2  class name should end with Mbean word like this TogglingFeaturesMbean   
       
                @Component
                @ManagedResource(objectName = "PD:category=MBeans,name=togglingFeaturesMbean", 
                description = "Get/Set log level for the category specified", log = true, logFile = "jmx-platform.log")
                public class TogglingFeaturesMbean {

                    private Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
                    private boolean getClaimRecord = true;
                    private boolean postClaimRecord = true;
                    private boolean updateClaimRecord = true;
                    private boolean deleteClaimRecord = true;

                    @ManagedAttribute
                    public boolean isGetClaimRecord() {
                        return getClaimRecord;
                    }

                    @ManagedAttribute
                    public void setGetClaimRecord(boolean getClaimRecord) {
                        this.getClaimRecord = getClaimRecord;
                    }
                    
 
 TESTING JMX IN LOCAL   activate and deactivate Toggling 

    1.  start  spring boot application 

    2.  at terminal type jconsole   like this  
           C:\Users\xyz\dt\SpringBootV2\src\main\java\com\springboot\v2>jconsole
           
    3. in pop up window of java monitoring & management console 
        select Local Process 
        select your Springboot Application  then clcik on connect 
        
    4. its ok to select  the insecure connection as its sample program 
    5. select Mbeans tab -> select select PD--> Mbeans --> here you can see your           togglingfeatures class name  like this   togglingFeaturesMbean
    6. select Attributes then change values and refresh  --> DONE
    
    
    

   



 
 
