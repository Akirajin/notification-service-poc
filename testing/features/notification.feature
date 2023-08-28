Feature: Notification feature

  Scenario: Add new notification for SPORTS
    Given I am a user
    And the log is cleared
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


  Scenario: Add new notification for FINANCE
    Given I am a user
    And the log is cleared
    When I call POST http://localhost:8080/notifications:
      """
      {
        "category": "FINANCE",
        "message": "This is the FINANCE news message"
      }
      """
    Then the response status code should be 200
    When I call GET http://localhost:8080/logs
    Then the response status code should be 200
    And the response body should be a JSON array with the following elements:
      """
        [
          {
            "datetime": "2023-08-28T18:02:38.494688841",
            "user": "Akira",
            "channel": [
              "PUSH",
              "SMS"
            ],
            "category": "FINANCE",
            "message": "This is the FINANCE news message"
          }
        ]
      """

  Scenario: Add new notification for MOVIES
    Given I am a user
    And the log is cleared
    When I call POST http://localhost:8080/notifications:
      """
      {
        "category": "MOVIES",
        "message": "This is the MOVIES news message"
      }
      """
    Then the response status code should be 200
    When I call GET http://localhost:8080/logs
    Then the response status code should be 200
    And the response body should be a JSON array with the following elements:
      """
        [
          {
            "datetime": "2023-08-28T18:06:24.193559046",
            "user": "Thomas",
            "channel": [
              "EMAIL"
            ],
            "category": "MOVIES",
            "message": "This is the MOVIES news message"
          },
          {
            "datetime": "2023-08-28T18:06:24.193565211",
            "user": "Ueda",
            "channel": [
              "SMS"
            ],
            "category": "MOVIES",
            "message": "This is the MOVIES news message"
          }
        ]
      """
