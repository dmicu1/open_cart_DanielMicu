Feature: Login Usuario

Background: Navegar hacia la pagina de Login
    Given : Me encuentro en la pagina Home
    And   : Seleciono desde el menu de account la opcion de login

  Scenario Outline: Login con credenciales validas

    When : Ingreso mis credenciales "<email>" y "<password>"
    Then : El login se realiza correctamente