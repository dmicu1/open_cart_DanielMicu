@login
Feature: Login Usuario

  Background:
    Given : Me encuentro en la pagina Home
    And   : Seleciono desde el menu de account la opcion de login

  @smokeLoginCredencialesValidas
  Scenario Outline: Login con credenciales validas

    When : Ingreso mis credenciales "<email>" y "<password>"
    Then : El login se realiza correctamente
    Examples:
      | email                  | password    |
      | danielmicu26@gmail.com | Hiberus2024 |

  @ValidarNoPoderRealizarLoginIngresandoContraseñaInvalida
  Scenario Outline: Login ingresando data Contraseña invalida

    When : Ingreso mis credenciales "<email>" y "<password>" invalido
    Then : El login NO se puede realizar
    Examples:
      | email                  | password |
      | danielmicu26@gmail.com | Hiberus  |

