# Automation tests

Prueba Tecnica de automatización de pruebas UI para el sitio:  
https://practicetestautomation.com/practice-test-login/  
Implementado con Java, Maven, JUnit 5 y Selenium.

---

## Requisitos

- JDK 8 (o superior compatible)
- Maven 3.9+
- Google Chrome (recomendado) o Microsoft Edge
- Conexión a internet (para dependencias y drivers)

---

## Stack Tecnológico

- Java 8
- JUnit 5
- Selenium WebDriver 4.8.3
- WebDriverManager
- AssertJ

---

## Cobertura de Pruebas

La prueba tecnica incluye los 3 escenarios:

- Positive login (credenciales válidas)
- Negative username (usuario inválido)
- Negative password (contraseña inválida)

---

## Estructura del Proyecto

- src/test/java/.../pages — Page Objects (LoginScreen, DashboardScreen, BaseScreen)
- src/test/java/.../domain — Reglas y expectativas (LoginRules, LoginExpectation)
- src/test/java/.../tests — Tests (LoginTest, BaseTest)
- src/test/java/.../support — Soporte (driver holder, screenshots) (WebDriverHolder, ScreenshotOnFailureExtension)
- src/test/java/.../driver — Factoría de WebDriver (DriverFactory)

---

## Ejecución Local (comandos)

Compilar sin ejecutar test:

```bash
mvn -q -DskipTests=true test-compile
```

Ejecutar Tests:

```bash
mvn clean test
```

Abrir en Navegador Visible:

```bash
mvn clean test -Dheadless=false
```

Modo Demo:

```bash
mvn clean test -Dheadless=false -DdemoPauseMillis=3000
```

Ejecutar en Edge:

```bash
mvn clean test -Dbrowser=edge
```

Problemas de permisos en Maven Local

```bash
mvn "-Dmaven.repo.local=.m2repo" clean test
```

## Generar Reportes

```bash
mvn surefire-report:report
# luego abrir:
open target/site/surefire-report.html
```

- Resultados JUnit XML: `target/surefire-reports`
- Screenshots en fallos: `target/screenshots`

## Limpiar Build / artifacts

```bash
mvn clean
# o
rm -rf target
```

## Notas tecnicas

- Uso de selectores estables (`id`, `className` y `linkText`)
- evito el uso sleeps para sincronizacion
- Validación de login exitoso incluye: URL, Texto y Visibilidad del botón Log out
- implementacion de explicitas centralizadas en `BaseScreen`
- preparado de ejecucion headless y data-driven
- `demoPauseMillis` se usa unicamente para revision manual
- Driver instanciado por DriverFactory y almacenado en WebDriverHolder (ThreadLocal)
