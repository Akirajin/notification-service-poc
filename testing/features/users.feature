Feature: Get users

  Scenario: Get all users
    Given I am a user
    When I call GET http://localhost:8080/users
    Then the response status code should be 200
    And the response body should be a JSON array with the following elements:
      """
      [
        {
          "name": "Thomas",
          "email": "thomas.ueda@alumni.usp.br",
          "phone": "+5511988888888",
          "subscribedCategories": [
            "MOVIES"
          ],
          "channels": [
            "EMAIL"
          ],
          "id": 1
        },
        {
          "name": "Akira",
          "email": "akirajin@gmail.com",
          "phone": "+5511988888881",
          "subscribedCategories": [
            "FINANCE"
          ],
          "channels": [
            "PUSH",
            "SMS"
          ],
          "id": 2
        },
        {
          "name": "Ueda",
          "email": "thomas.ueda@alumni.usp.br",
          "phone": "+5511988888882",
          "subscribedCategories": [
            "MOVIES",
            "SPORTS"
          ],
          "channels": [
            "SMS"
          ],
          "id": 3
        }
      ]
      """