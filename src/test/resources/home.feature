Feature: Pagina principal del Software

  Scenario: Navegar hacia la Pagina de Registro

    Given : Me encuentro en la pagina Home
    When  : Abro el menu desplegable
    Then  : Se me redirecciona corectamente hacia la pagina de registro usuario

  Scenario: Navegar hacia la Pagina de Login

    Given : Me encuentro en la pagina Home
    And   : Abro el menu desplegable
    Then  : Se me redirecciona corectamente hacia la pagina de login