Feature: Inicio de Sesión en la Aplicación Web

Scenario: Inicio de sesión exitoso con credenciales válidas
  Given el usuario está en la página de inicio de sesión
  When el usuario ingresa el nombre de usuario "standard_user" y la contraseña "secret_sauce"
  And hace Clic en el botón de inicio de sesión
  Then el usuario debería ver la página de productos

Scenario: Inicio de sesión fallido con contraseña incorrecta
  Given el usuario está en la página de inicio de sesión
  When el usuario ingresa el nombre de usuario "standard_user" y la contraseña "wrong_password"
  And hace Clic en el botón de inicio de sesión
  Then el usuario debería ver un mensaje de error "Epic sadface: Username and password do not match any user in this service"

Scenario: Inicio de sesión fallido con campos vacíos
  Given el usuario está en la página de inicio de sesión
  When el usuario deja el campo de nombre de usuario y contraseña vacíos
  And hace Clic en el botón de inicio de sesión
  Then el usuario debería ver un mensaje de error "Epic sadface: Username is required"