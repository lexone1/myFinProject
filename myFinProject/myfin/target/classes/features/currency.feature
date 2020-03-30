@myFin
@currency
Feature: Currency
  As a default User of the system
  I can verify current/future rates

  Background:
    Given I open MyFin currency page

  Scenario Outline: Verify current/future currency using UI/REST
    Given Verify "Торги на Белорусской валютно-фондовой бирже на cегодня." page displayed
    When I get current "<Currency Type>" rate
    Then I should see current "<Currency Type>" rate greater "0.01"
    When I get future "<Currency Type>" rate via REST
    Then I compare current and future "<Currency Type>" rates

    Examples:
      | Currency Type |
      | USD           |
      | RUB           |
      | EUR           |