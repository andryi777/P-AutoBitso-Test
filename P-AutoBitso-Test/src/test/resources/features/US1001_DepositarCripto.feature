@tag
Feature: Realizar un depósito en Bitso

  Background: 
    Given access to the web BitsoTest with Mexican mail

  @MakeDeposit
  Scenario Outline: Validate error messages
    Given select criptocurrency "<criptocurrency>"
    When select depositar
    Then should appear a message "¡Ups! Algo salió mal-Esta transacción excede tu límite. Incrementa tu límite de cuenta para continuar."

    Examples: 
      |  0 | criptocurrency |
      |  1 | BTC            |
      |  2 | BAT            |
      |  3 | BCH            |
      |  4 | COMP           |
      |  5 | DAI            |
      |  6 | ETH            |
      |  7 | LTC            |
      |  8 | MANA           |
      |  9 | TUSD           |
      | 10 | USDT           |
      | 11 | XRP            |

  @AddBeneficiary
  Scenario Outline: Validate registry of beneficiary
    Given select menu Perfil-Perfil
    When select beneficiarios
    And register one beneficiario with name "<name>", lastname1 "<lastname1>", lastname2 "<lastname2>", datebirth "<datebirth>", relationship "<relationship>", relationshippercentage "<relationshippercentage>"
    Then should appear a confirmation window

    Examples: 
      | 0 | name | lastname1 | lastname2 | datebirth  | relationship | relationshippercentage |
      | 1 | John | Smith     | Sully     | 10/01/1985 | Conocido     |                     10 |
