Feature: Hello API
  Scenario: Say hello to a user
    Given I have a HelloController
    When I ask it to say hello to "Jenkins"
    Then it should answer "Hello, Jenkins!"
