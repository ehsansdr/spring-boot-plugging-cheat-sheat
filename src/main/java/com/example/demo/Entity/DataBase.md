# data base hint
*************
### **Postgres Connection**
[how-to-connect-spring-boot-project](https://genotechies.medium.com/how-to-connect-spring-boot-project-with-postgresql-database-in-vscode-b0b03b53040d)


for connecting to postgres connection:

download postgres server :           
<img alt="img_2.png" height="300" src="img_2.png"/>
       
<img alt="img_3.png" height="100" src="img_3.png"/>

<img alt="img_4.png" height="100" src="img_4.png"/>

the database name is the name you see in database          
<img alt="img.png" height="450" src="img.png"/>

have this in `pom.xml` :
jpa dependency:      

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
        <!--			search "data jpa" in search in add dependency in intellij-->
        <!--			for having @Entity and @Sequance and ... don't have <scope></scope>-->
        <!--			IntelliJ wil add this dependency with <scope></scope> so omit that-->
        <!--			<scope>system</scope>-->
        <!--			or -->
        <!--			<scope>runtime</scope>-->
     </dependency>


and:           

    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
    </dependency>

application.yml:

or in advanced level:

    # (the name ot database,not server the item that you see in database folder in pgadmin4)
    spring:
        datasource:
            driver-class-name: org.postgresql.Driver
            url: jdbc:postgresql://localhost:5432/       #(the name of database)
            username: postgres # (the username that default is "postgres")
            password: postgres # (the password that i set is "postgres")
    jpa:
        hibernate:
            ddl-auto: update
        # by defulat this is false
        show-sql: true    # when run or hibernate execute command or query  it will be displayed in your ide or in the logs of your application
        properties:
            hibernate:
            format_sql: true
        database: postgresql
        database-platform: org.hibernate.dialect.PostgreSQLDialect

if you one the simple one use this:

    # (the name ot database,not server the item that you see in database folder in pgadmin4)
    spring:
        datasource:
            driver-class-name: org.postgresql.Driver
            url: jdbc:postgresql://localhost:5432/ # (the name ot database)
            username: postgres # (the username that default is "postgres")
            password: postgres # (the password that i set is "postgres")
    jpa:
        hibernate:
            ddl-auto: update    # for developing use create or ubdate
                                # "create drop" create the schama after finishing delete them
                                # "validate" validate schema make but make no change



or:

    spring:
        datasource:
            url: jdbc:postgresql://localhost:5432/nnnn
            username: postgres
            password: postgres
            driver-class-name: org.postgresql.Driver
    jpa:
        hibernate:
            ddl-auto: update
        properties:
            hibernate:
                format_sql: true
        show-sql: true


you can check this gihub repository for copy and pasting better:              
[https://github.com/ali-bouali/book-social-network/blob/main/book-network/src/main/resources/application-dev.yml](book-social-network/blob/main/book-network/src/main/resources/application-dev.yml)
[https://github.com/ali-bouali/spring-boot-bootcamp/blob/main/src/main/resources/application.yml](spring-boot-bootcamp/blob/main/src/main/resources/application.yml)



concreting in dbeaver:       
**download it from its original site**
<img alt="img_1.png" height="500" src="img_1.png"/>              
the data base name will come here the name that we see in `database` folder in pgadmin4
and the exact same name in `url: ... ` in yml file

*********************
VERY IMPORTANT

first you need to install mysql server and you can install that from above link and the tutorial of that in this link too
[https://www.w3-farsi.com/posts/18452/install-mysql-server/]()
then you should install MYSQL Administrator :
[https://www.w3-farsi.com/posts/18452/install-mysql-server/]()

and after that you make sure you have that install base on upper link you can use mysql command prompt (i do not actually know that you can to this by normal command prompt or not)