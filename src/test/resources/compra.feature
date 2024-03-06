@compra
Feature: Compra usuario logeado

  Background:
    Given : Me encuentro en la pagina Home
    And   : Seleciono desde el menu de account la opcion de login
    And   : Ingreso mis credenciales "<email>" y "<password>"

  @smokeTC1ValidarCompraProductos
  Scenario: Comprar 2 productos al azar desde la seccion "Mp3Players"

    When : Accedo a la seccion Mp3 Players
    And  : Selecciono al azar 2 productos
    Then : Los productos se agregaron correctamente a la cesta

  Scenario: Comprar productos al azar y luego eliminarlos
    When  : Accedo a la seccion Mp3 Players
    And   : Elimino todos los productos de la cesta
    Then  : Los productos se eliminan correctamente
