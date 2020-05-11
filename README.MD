#hello-azure-function

This product contains a simple hello-world  template that
 can be used both locally and as an azure function.

## How to run locally
Running in a cloud environment is all fine and dandy
, however at some point we want to be able to test things
 locally without redeploying and waiting on a cloud
  environment with possible lagging logging. To achive
   this, one can simply run 
   ```bash
mvn clean package azure-functions:run
   ```
The logging will print the endpoints and possible methods
 that are accessible.

## How to deploy to the cloud
Running in a cloud environment, what can sound more fancy
. To deploy this in a cloud environment, you only need to
 run 
 ```bash
    mvn cleean package azure-functions:deploy
 ```


##See also
//TODO, insert confluence links once available.