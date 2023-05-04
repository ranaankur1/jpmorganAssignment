@News-Validator
Feature: Fake news detector - scenarios

  Scenario: To check that the news URL is valid
    Given the user navigated to "https://www.theguardian.com/tone/news" Guardian website
    When the user accesses the link to the first news URL
    Then the URL is found to be valid

  Scenario: To check if the news headline is in line with the news content
    Given the user navigated to "https://www.theguardian.com/tone/news" Guardian website
    When the user accesses the link to the first news URL
    And reads through the content of the news
    Then the headline is found to be in line with the news content



  Scenario: To check if the news is found true from other sources through Google search
     Given the user navigated to "https://www.theguardian.com/tone/news" Guardian website
    When the user accesses the link to the first news URL
    And reads through the content of the news
    And navigate to google news "https://news.google.co.uk" and find 2 other sources
    Then the news is found to be valid news in other sources

  Scenario: To check if the news is found true from BBC news website
     Given the user navigated to "https://www.theguardian.com/tone/news" Guardian website
    When the user accesses the link to the first news URL
    And reads through the content of the news
    And navigate to BBC news "https://www.bbc.co.uk/search" and find 2 other sources
    Then the news is found to be valid news in BBC news website

