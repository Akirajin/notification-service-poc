Feature: Get categories

  Scenario: Get all categories
    Given I am a user
    When I call GET http://localhost:8080/categories
    Then the response status code should be 200
    And the response body should be a JSON array with the following elements:
      """
      [
        {
          "name": "Sports"
        },
        {
          "name": "Finance"
        },
        {
          "name": "Movies"
        }
      ]
      """