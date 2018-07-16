Feature: Testing login with correct and incorrect credentials

Background:
  		Given I opened the browser and navigate to webpage
@MOB-1     
Scenario Outline: MOB-1 Successful Login when correct credentials are passed 
		When I enter correct username <username1> and correct password <password1>
		Then I will be  successfully logged in

Examples:
|username1	| 	password1|
|himanshuchaudhary	|	Himanshu@321#|

@MOB-2
Scenario Outline: MOB-2 Error message displayed when incorrect credentials are passed	
		When I enter incorrect username <username1> and incorrect password <password1>
		Then I will see an error message 

Examples:
|username1	| 	password1|
|tomsmith12	|	SuperPassword!|
