# Nebraska Test Automation

## Setup

Download and Install Katalon Studio. https://web-api.katalon.com/download/

Once Katalon Studio is installed, open it and login with your Katalon user account.

Clone the TA-Nebraska project repository on your desktop from https://github.com/patriciorodriguezOT/TA-Nebraska. The branch ta-main is the one that contains the test cases executed. This is the most important one and it should be stable. The branch ta-development is which receives the new test cases or updates. Once it is stable, it is merged to ta-main.

Make sure that libraries "javax.mail-1.6.2.jar" and "ashot-1.5.4.jar" are on the Drivers folder of the project. They are used for checking emails received and comparing images.
Links for downloading
"javax.mail-1.6.2.jar" - https://jar-download.com/artifacts/com.sun.mail/javax.mail/1.6.2/source-code
"ashot-1.5.4.jar" - https://jar-download.com/artifacts/ru.yandex.qatools.ashot/ashot/1.5.4/source-code

On Katalon Studio, open the project and verify settings.
- Go to Project -> Settings, select Email section. Set the correct configuration to send Emails Report.
- Go to Project -> Settings, select Katalon TestOps section. Set the correct configuration so the reports are uploaded to the correct project on TestOps.


## Workflow
When a new test script needs to be created or updated, a ticket should be created on Jira with all the details.

Create a new branch from the ta-development branch, using the prefix 'impl-' and the number of the ticket on the name. Once the new changes are applied, it is sent to review and then marged to ta-development.

Currently, to complete the hole process, the tool used is Sourcetree - Git-flow.

## Folder Structure

### Profiles

The Profiles section contains all the Global Variables needed to execute the test cases.

Each profile contains the links, variables, users, and configuration necessary to execute the test scrips in a specific environment.

 - #### QA Env
Contains the global variables needed for vv5qa environment. 

- #### Dev Env
Contains the global variables needed for vv5qa environment. 


### Test Cases

Here are located all the test scripts developed. They are organized by section. Each folder represents a specific form/section of the project.


### Object Repository

Here are located all the elements the test scripts interact with. They are organized by forms. Each folder contains the objects of a specific one.


### Test Suites

A test suite is a collection of multiple different or duplicate test cases.

They are grouped by section or linked processes where one needs from the other. For example, Registration, Applying for a License, and Deny License Application.

#### Individual Test Cases:
In this folder, there is a Test Suite for each test case. This is in case we need to execute a specific script from Test Cloud.

#### Test Suite Collection
Here is the Test Suite Collection which contains all the Test Suites that need to be executed every day.

#### Test Suites - Process
In this folder there are the Test Suites executed on the Test Suite Collection. These TS contains groups of TCs.


#### Test Suites for testing
Used for testing. 


### Keywords

#### api_Connection:
In this folder, there are the classes created in order to handle the JSON response obtained from an API call. Each class contains all the functions for a specific form.

#### compareImages
Here is contained the class used for comparing two images and checking if they are equal or not. In case there is a difference, an image is created marking the differences.

#### generic
Here there are generic functions that are needed to execute the test scripts, like date handling, generating random strings, etc.

#### gmailConnection:
Here is the class used to connect with Gmail account and verify emails received by registration.

#### pages
In this folder, there is a class for each form. These classes contain all the keywords needed to interact with them. Apart from that, all the elements are declared in the corresponding class.

#### tc_listener
Here is the class which contains the functions to be executed after or before a TC is executed.

#### ws
Here are the classes to make the API calls. Each class contains all calls for a specific form.


### Test Listeners
Here is the event that is triggered once the test cases have been completed.

## Test Cases Relationships

As it was mentioned previously, some test cases depends on others to be executed. Below is a diagram with 

![alt text](./ReadmeImages/Test%20Cases%20Relationships.png)