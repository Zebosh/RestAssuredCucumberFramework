Feature:
When I get countries
Then I verify that list countries is available in response

  @bhavani4
  Scenario: When I get countries , I verify that vietnam exists in the response
    When I get countries
    Then I verify that status code is 200
    Then I verify Vietnam exists in the response