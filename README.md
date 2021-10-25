# Library app

A java 11, dropwizard application for uni.

## Features

### View all books

`GET     /library/allbooks (domain.BookResource)`

### Search by author

`GET     /library/authorSearch?author= (domain.BookResource)` <- type partial name of author in path. 
For example: `GET /library/authorSearch?author=Dostoevsky`

### Delete author

`GET     /library/deleteAuthor?author= (domain.BookResource)` <- type partial name of author in path.
For example: `GET /library/deleteAuthor?author=Dostoevsky`

### Running the app

- From the commandline:
  - Run `gw shadowJar` to create a jar
  - The jar usually ends up in build/libs/{project jar}
  - To run the jar from the command line: `java -jar build/libs/DataStructureModule-1.0-SNAPSHOT.jar server config.yml`

- From IntelliJ:
  - Make sure you have added the working directory and the server argument.
  - ![Screenshot 2021-10-24 at 11 32 51](https://user-images.githubusercontent.com/38332168/138590125-61208f20-314c-494e-91dd-6a7d1291319a.png)
