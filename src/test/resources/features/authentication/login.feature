Feature: Login
  Customers must provide credentials in order to access the site.

  Rule: Customer must provide valid credentials to access site

    Example: Mark logs in with valid credentials
      Given Mark is a registered user
      When he logs in using valid credentials
      Then he should be presented with the catalog

    Scenario Outline: Login with invalid credentials
      Given Mark is on the login page
      When he attempts to login with "<username>" and "<password>"
      Then he should be refused access because: <outcome>

      Examples:
        | username      | password       | outcome                                                                   |
        | standard_user | wrong_password | Epic sadface: Username and password do not match any user in this service |
        | unknown_user  | secret_sauce   | Epic sadface: Username and password do not match any user in this service |


  Rule: Locked-out users should be blocked
    Example: The one where Mary's account is blocked
      Given Mary is a registered user
      But her account is blocked
      When she logs in using valid credentials
      Then she should be refused access because: Sorry, this user has been locked out.