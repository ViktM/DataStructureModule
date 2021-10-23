# Library app

##Features

###View all books

`GET     /library/allbooks (domain.BookResource)`

###Search by author

`GET     /library/authorSearch?author= (domain.BookResource)` <- type partial name of author in path. 
For example: `GET /library/authorSearch?author=Dostoevsky`

