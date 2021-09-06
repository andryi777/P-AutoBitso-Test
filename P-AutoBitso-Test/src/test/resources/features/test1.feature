Feature: Crer roles de usuario
Como usuario admin debo asegurar la correcta configuración de los roles

Scenario Outline: Validar roles configurados
  Given accedo a la web rimac.com
  When reviso roles <roles>
  Then debe de mostrar los roles correctamente
  Examples:
    |roles|
    | cajero|
    | tesorero|
    | abogado|