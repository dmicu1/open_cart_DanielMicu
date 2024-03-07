@home
Feature: Pagina principal del Software

    Background:
      Given : Me encuentro en la pagina Home

  @smokeNavegarHaciaLaPaginaDeRegistro
  Scenario: Navegar hacia la Pagina de Registro

    When  : Seleciono desde el menu de account la opcion de registro
    Then  : Se me redirecciona corectamente hacia la pagina de registro usuario

  @smokeNavegarHaciaLaPaginaDeLogin
  Scenario: Navegar hacia la Pagina de Login

    When  : Seleciono desde el menu de account la opcion de login
    Then  : Se me redirecciona corectamente hacia la pagina de login