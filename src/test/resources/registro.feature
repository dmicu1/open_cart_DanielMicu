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

  @TC2ValidarLosMensajesDeErrorParaValoresLimitesInferiores
  Scenario: Validar los mensajes de error ingresando data por debajo de los limites inferiores
    When : Relleno los campos FirstName,LastName,Telephone,Password
    And  : Hago click en el boton Continue
    Then : Los mensajes se disparan correctamente


  @TC3ValidarLosMensajesDeErrorParaValoresLimitesSuperiores-BUG(campopassword)
  Scenario: Validar los mensajes de error ingresando data por encima de los limites superiores
    When : Relleno los siguentes camposFirstName,LastName,Telephone,Password
    And  : Hago click en el boton Continue
    Then : Los mensajes de error se disparan correctamenete