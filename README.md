Here we are trying to save a generic Json data into DB.

Todo so there are 3 approaches -

M1-> First we need to defined one entity class which will contain all the fields
which our json data will have and then we can defined that entity in our main entity
like Author and Book. see on below link -
https://github.com/ayushdgupta/quarkus-json-data-in-db-postgre

But in this approach we fixed the columns / keys in our json like we already defined
the structure of the json data so this approach will not work if you want to
process any kind of json data.

M2-> Second approach is to use 3rd party library HibernateTypes-52 or 54 whatever.
But the problem with this approach is it uses a third party library which might not
be allowed at organizational level. follow below link for 2nd approach
https://github.com/ayushdgupta/quarkus-generic-json-data-storage

M3-> Third approach is store the Json data as string in db and when you will fetch that
data from db then convert it into a Map<String, Object>.
this code is based on third approach.

In this approach if you will create tables in your db automatically then by default
the JSON Column will be generated with type Varchar(255) which has limit on data
so we need to change the datatype manually in db to 'text' which don't have any limit.