Feature: Testing login with correct and incorrect credentials

Background:
  		Given I have the LoginPage

Scenario Outline: Successful Login when correct credentials are passed 
		When I enter correct username <username1> and correct password <password1>
		Then I will be  successfully logged in

Examples:
|username1	| 	password1|
|himanshuchaudhary	|	Himanshu@321#|

Scenario Outline: Error message displayed when incorrect credentials are passed	
		When I enter incorrect username <username1> and incorrect password <password1>
		Then I will see an error message 

Examples:
|username1	| 	password1|
|tomsmith12	|	SuperPassword!|
|dkjhvjkhfhf|		kswl;kwk  |
|sdasdas    |		sdasdsa   |
