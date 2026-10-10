Feature: Product-Store

  @precioProducto
  Scenario Outline: Validación del precio de un producto
    Given estoy en la página de la tienda
    And me logueo con mi usuario "<usuario>" y clave "<clave>"
    When navego a la categoria "<categoria>" y <subcategoria> "Men"
    And agrego 2 unidades del primer producto al carrito
    Then valido en el popup la confirmación del producto agregado
    And valido en el popup que el monto total sea calculado correctamente
    When finalizo la compra
    Then valido el titulo de la pagina del carrito
    And vuelvo a validar el calculo de precios en el carrito

    Examples:
    | usuario         | clave              | categoria  | subcategoria      |
    | lucia@gmail.com | Luci@2026Selenium  | Clothes    | Men               |
    | lucia@gmail.com | Luci@2026Selenium  | Autos      | Women             |

  @loginFallido
  Scenario Outline: Validación de credenciales incorrectas
    Given estoy en la página de la tienda
    When me logueo con mi usuario "<usuario>" y clave "<clave>"
    Then valido que se muestre el mensaje de error "<mensaje_error>"

    Examples:
      | usuario         | clave         | mensaje_error           |
      | tachi@gmail.com | tachi1234/&%@ | Error de autenticación. |
