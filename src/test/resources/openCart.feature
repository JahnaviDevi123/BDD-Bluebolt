Feature: Open Cart Functionality

  Background: Given I navigate to the website peppery

	@testCaseId=1
  Scenario: Verify title and navigation
    Then validate the title of the page

   @testCaseId=2
  Scenario: Furniture category
    When I click on the Furniture category

  @testCaseId=3
  Scenario: Cart category
    Then I click on the Cart button
