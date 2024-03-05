Feature: Compra usuario logeado

  Background:
    Given : Me encuentro en la pagina Home
    And   : Seleciono desde el menu de account la opcion de login
    And   : Ingreso mis credenciales "<email>" y "<password>"

  Scenario: Comprar 3 productos al azar desde la seccion "Mp3Players"

    When : Accedo a la seccion Mp3 Players
    And  : Selecciono al azar 3 productos
    Then : Los productos se agregaron correctamente a la cesta

