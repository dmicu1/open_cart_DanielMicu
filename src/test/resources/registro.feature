@register
Feature: Registro de usuario nuevo

  Background:
    Given : Me encuentro en la pagina Home
    And   : Seleciono desde el menu de account la opcion de registro

  @smokeTC1HappyPathRegistroUsuarioExitoso
  Scenario: Validar registro de usuario nuevo exitoso

    When : Relleno todos los campos obligatorios
    And  : Hago click en el boton Continue
    Then : El registro se realiza correctamente

  @TC2ValidarRegistroInvalidoLimitesInferiores
  Scenario: Validar NO poder registrarse rellenando con valores limites inferiores
    When : Relleno todos los campos obligatorios con valores limites inferiores
    And  : Hago click en el boton Continue
    Then : El registro No se puede realizar


  @TC3ValidarRegistroInvalidoLimitesSuperiores-BUG(campopassword)
  Scenario: Validar No registrarse rellenando con valores limites superiores
    When : Relleno todos los campos obligatorios con valores limites superiores
    And  : Hago click en el boton Continue
    Then : El registro no se puede realizar exitosamente
