@cesta
Feature: Agregar productos al carrito con usuario logeado

  Background:
    Given : Me encuentro en la pagina Home
    And   : Seleciono desde el menu de account la opcion de login
    And   : Ingreso mis credenciales "<email>" y "<password>"

  @smokeValidarContadorYAgregarProductosCesta
  Scenario: Agregar 2 productos al azar desde la seccion "Mp3Players"

    When : Accedo a la seccion Mp3 Players
    And  : Selecciono al azar 2 productos
    Then : Los productos se agregaron correctamente a la cesta

  @ValidarContadorYEliminarProductosCesta
  Scenario: Agregar productos al azar y luego eliminarlos

    When  : Elimino los productos agregados previamente
    Then  : Los productos se eliminan correctamente
