Feature: Notification feature

  Scenario: Add new notification
    Given I am a user
    When I call POST http://localhost:8080/notifications:
      """
      {
        "category": "SPORTS",
        "message": "This is the SPORT news message"
      }
      """
    Then the response status code should be 200
    When I call GET http://localhost:8080/logs
    Then the response status code should be 200
    And the response body should be a JSON array with the following elements:
      """
        [
          {
            "datetime": "2023-08-28T16:03:03.877747773",
            "user": "Ueda",
            "channel": [
              "SMS"
            ],
            "category": "SPORTS",
            "message": "This is the SPORT news message"
          }
        ]
      """
