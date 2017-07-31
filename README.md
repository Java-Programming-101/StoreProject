# StoreProject
This project is developed mainly during our Java Programming Meetup. That is a e-commerce application that is being developed only for educational purposes.

This project has been developed with the intention of showing how different technologies, languages and frameworks can interact with each other.

# Setting up

To set up this project you will need the following tools. (we have assumed for this that you already have the latest JDK installed)

- Maven 
  - Head over to https://www.mkyong.com/maven/how-to-install-maven-in-windows/ and follow the instructions on installing maven.
  
- An IDE 
  - Intellij (any IDE should work however Intellij is the IDE We have used in the group as it is integrated well with maven) 

- MySql Workbench  ( https://dev.mysql.com/downloads/installer/ )
  - Download and install MySQL, When given the option select the developer installation and accept all the defaults. You will be asked to create a root account with a password REMEMBER THE PASSWORD. 
  - When MySQL has been installed, The workbench should be accessible. Open it up and select the root user, you will be prompted for your password.
  - On the left hand side you should be able to see the word "Schemas" under that you should see a box with "Filter objects" in it, right click under there and select "Create Schema"
  - Call Schema "storedb"
  - Hit apply
  - MySQL should be set up and ready to go. 

- NodeJS
  - Head over to https://nodejs.org/en/ 
  - Download node JS and follow the instructions for installation. 
  
  
# Clone the project

- Select "Clone or Download"
- Copy the Https link (here for ease of use -> https://github.com/Java-Programming-101/StoreProject.git )
- Open intellij
- Select new project from version control 
- Select Github 
- Paste the link into the Git reposetory URL box. 
- Click Clone. 

# Some quick house keeping

#### Database connection configuration.
- Remember the password you set for Mysql?
- Open Intellij and this project. 
- navigate to \StoreProject\StoreServiceLayer\src\main\resources\application.properties
- change the password from "qwe123" to the password you set for MySQL
- save your edit. 
- Navigate to \StoreProject\StoreServiceLayer\src\main\java\co\shinetech\StoreBoot.java
- Run the store boot method.

#### Populate some data
- Open MySql Workbench
- Open your "root" user, input your password.
- Click file > Open SQL Script
- Navigate to \StoreProject\StoreDataModel\src\test\resources\sql\categories.sql click open
- Click Run

# Node Package manager
- Open your command line
- Navigate to the StoreUI folder
- Type "npm install" and wait for that to finish. 
- Type "npm start" Providing there are no issues you should have an internet browser pop up. (depending on the state of the project a good looking page may or may not show up but your internet browser should definatly open)


# More detail to come, not complete yet. The following section will be padded out with a very basic description and links to useful resources....

# What Technologies, Tools, Frameworks or libraries are we using?

## Java
    ### JPA
    ### Spring Boot
        #### Spring
        #### Hibernate

## Maven



## MySql

## JavaScript
    ### Node Package Manager
    ### React




