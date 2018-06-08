# Startup Weekend Team Tracker

#### Allows teams to sign up for a local weekend hack-a-thon event.

#### By _**Matt Miller**_

## Description

This application will allow teams to sign up for a weekend hack-a-thon event with their team name, team members, and a brief description of their team. Users will also be able to add and remove members as well as update team names and descriptions.

#### Specifications

| Specification | Input | Output |
| --- | --- | --- |
| Program will set the team name | Input: "Blue Moon Boys" | Output: "Name: Blue Moon Boys" |
| Program will set the team description | Input: "Just a couple guys looking to shake, rattle, and roll" | Output: "Description: Just a couple guys looking to shake, rattle, and roll" |
| Program will set a team member's name | Input: "Bill" | Output: "Members: Bill" |
| Program will set a team member's skill | Input: "Bass" | Output: "Members: Bill-Bass" |
| Program will display all teams | Input: "Blue Moon Boys, The Hawks" | Output: "Teams: Blue Moon Boys, The Hawks" |
| Program will allow user to view details of specific team | Input: click "Blue Moon Boys" | Output: "Name: Blue Moon Boys/ Members: Bill, Scotty/ Description: Just a couple guys looking to shake, rattle, and roll" |
| Program will allow users to add team members  | Input: "DJ - Drums" | Output: "Members: Bill, Scotty, DJ" |
| Program will allow user to update team name and description | Input: "The Blue Moon Boys/ Just a few guys looking to shake, rattle, and roll" | Output: "Name: The Blue Moon Boys/ Description: Just a few guys looking to shake, rattle, and roll" |
| Program will allow user to update member name, skill, and team | Input: "James/ Guitar/ The Hawks" | Output: "Name: James/ Skill: Guitar/ Team: The Hawks" |
| Program will allow users to delete team members  | Input: "DJ" | Output: "Members: Bill, Scotty" |
| Program will allow users to delete a team  | Input: "The Blue Moon Boys" | Output: "The Hawks" |

## Setup/Installation Requirements

* View program by cloning repository from https://github.com/mattfmiller/event-planning
* Open project in IDE such as IntelliJ IDEA
* Run App.java to compile the program
* Navigate to localhost:4567/ in browser to interact with program

## Known Bugs

* N/A

## Support and contact details

For support, contact: matt.f.miller@live.com

## Technologies Used

* Java
* Spark
* Handlebars
* SQL Database
* H2

### License

This software is licensed under the GPL license.

Copyright © 2018 **Matt Miller**
