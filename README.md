# Library app

##Features

###View all books

`GET     /library/allbooks (domain.BookResource)`

###Search by author

`GET     /library/authorSearch?author= (domain.BookResource)` <- type partial name of author in path. 
For example: `GET /library/authorSearch?author=Dostoevsky`

###Running the app

- From the commandline:
  - Run `gw shadowJar` to create a jar
  - The jar usually ends up in build/libs/{project jar}
  - To run the jar from the command line: `java -jar build/libs/DataStructureModule-1.0-SNAPSHOT.jar server config.yml`

- From IntelliJ:
  - Make sure you have added the working directory and the server argument.
  - ![](../../../../../var/folders/7r/y74rkkb96cd5htysp_1l12g4z3rwl2/T/TemporaryItems/NSIRD_screencaptureui_su5UCL/Screenshot 2021-10-24 at 11.30.10.png)