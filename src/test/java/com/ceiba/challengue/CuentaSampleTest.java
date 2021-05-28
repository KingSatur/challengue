package com.ceiba.challengue;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.ceiba.challengue.exceptions.DineroInsuficienteException;

class CuentaSampleTest {
	CuentaSample cuenta;

	// En caso de que se quiera usar un metodo del cicla de vida y en cada metodo
	// anotado con @Test
	TestInfo testInfo;
	TestReporter testReporter;

	@BeforeAll
	static void beforeAll() {
		// Inicializar algun recurso, alguna conexion
		System.out
				.println("Inicializando todas las pruebas");
	}

	@AfterAll
	static void afterAll() {
		System.out.println("Finalizando todas las pruebas");
	}

	@BeforeEach
	void initMetodoTest(TestInfo testInfo,
			TestReporter testReporter) {
		System.out.println("Iniciando el metodo: "
				+ testInfo.getDisplayName());
		this.cuenta = new CuentaSample("Leonel",
				new BigDecimal("26.700"));
	}

	@AfterEach
	void finished() {
//		System.out.println("Finalizando el metodo");
	}

	@Tag("logic")
	@DisplayName("Logica de negocio")
	@Nested
	class CuentaTest {

		// No se puede usar beforeAll y afterAll en clases anidadas

		@Test
		@DisplayName("Probando el nombre de la cuenta")
		void testNombreCuenta(TestInfo testInfo,
				TestReporter testReporter) {
			System.out.println(testInfo.getTags());
			String str = "Leonel";
			cuenta.setSaldo(BigDecimal.valueOf(25.000));
			Assertions.assertEquals(str,
					cuenta.getPersona());

		}

		@Test
		void testSaldoCuenta() {
			assertNotNull(cuenta.getSaldo(),
					"El saldo no puede ser nulo");
			assertEquals(26.700,
					cuenta.getSaldo().doubleValue());
			assertFalse(cuenta.getSaldo()
					.compareTo(new BigDecimal(0)) < 0);

		}

		@Test
		void testReferenciaCuenta() {
			CuentaSample sample = new CuentaSample("2",
					new BigDecimal("75"));
			CuentaSample sample2 = new CuentaSample("2",
					new BigDecimal("75"));
			// Equals compara por referencia por defecto
//			assertNotEquals(sample, sample2)
			assertEquals(sample2, sample);

			// Comprar por valores

		}

		@DisplayName("Probando debito cuenta repetir")
		@RepeatedTest(value = 5, name = "Repeticion numero {currentRepetition} de {totalRepetitions}")
		void testDebidoCuenta(RepetitionInfo info) {

			// UTILIZAR REPETICION DE TEST CUANDO TRABAJAMOS CON ALEATORIEDAD
			if (info.getCurrentRepetition() == 3) {
				// DO SOMETHING, its flexible
				System.out.println(
						"Estamos en la repeticion 3");
			}
			CuentaSample sample = new CuentaSample("Messi",
					new BigDecimal("75.000"));
			sample.debito(new BigDecimal("11.000"));
			assertNotNull(sample.getSaldo());
			assertEquals(64.000,
					sample.getSaldo().doubleValue());

		}

		@Nested
		class PruebasParametrizadas {
			@Disabled
			@ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
			@ValueSource(strings = { "10.000", "15.000",
					"20.000" })
			void testCreditoCuentaValueSource(
					String monto) {
				CuentaSample sample = new CuentaSample(
						"Messi", new BigDecimal(monto));
				sample.credito(new BigDecimal("10.000"));
				assertNotNull(sample.getSaldo());
				assertTrue(sample.getSaldo()
						.compareTo(BigDecimal.ZERO) > 0);

			}

			@Disabled
			@ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
			@CsvSource({ "1,10.000", "2,15.000",
					"3,20.000" })
			void testCreditoCuentaCsvSource(String index,
					String monto) {
				System.out
						.println(index + " ---> " + monto);
				CuentaSample sample = new CuentaSample(
						"Messi", new BigDecimal(monto));
				sample.credito(new BigDecimal("10.000"));
				assertNotNull(sample.getSaldo());
				assertTrue(sample.getSaldo()
						.compareTo(BigDecimal.ZERO) > 0);

			}

			@Disabled
			@ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
			@CsvFileSource(resources = "/data.csv")
			void testCreditoCuentaCsvFileSource(
					String monto) {
				System.out.println(monto + " este");
				CuentaSample sample = new CuentaSample(
						"Messi", new BigDecimal(monto));
				sample.credito(new BigDecimal("10.000"));
				assertNotNull(sample.getSaldo());
				assertTrue(sample.getSaldo()
						.compareTo(BigDecimal.ZERO) > 0);

			}

//			@ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
//			@MethodSource("montoList")
//			void testCreditoCuentaMethodSource(String monto) {
//				System.out.println(monto + " este");
//				CuentaSample sample = new CuentaSample("Messi",
//						new BigDecimal(monto));
//				sample.credito(new BigDecimal("10.000"));
//				assertNotNull(sample.getSaldo());
//				assertTrue(sample.getSaldo()
//						.compareTo(BigDecimal.ZERO) > 0);
			//
//			}

//			static List<String> montoList() {
//				return Arrays.asList("10.000", "15.000",
//						"20.000");
//			}

		}

		@Tag("Timeout")
		@DisplayName("Pruebas de timeout")
		@Nested
		class TimeToutTest {

			@Test
			@Disabled
			@Timeout(2)
			void pruebaTimeout()
					throws InterruptedException {
				TimeUnit.MILLISECONDS.sleep(2000);

			}

			@Test
			@Disabled
			@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
			void pruebaTimeout2()
					throws InterruptedException {
				TimeUnit.MILLISECONDS.sleep(5);

			}

			@Test
			@Disabled
			void pruebaTimeout3()
					throws InterruptedException {
				assertTimeout(Duration.ofSeconds(2), () -> {
					TimeUnit.SECONDS.sleep(1);
				});

			}

		}

		@Test
		@Tag("Error")
		@DisplayName("Probando excepcion cuando se saca mas dinero del que se tiene")
		void testDineroInsuficienteException() {
			CuentaSample sample = new CuentaSample("Messi",
					new BigDecimal("75.000"));
			Exception exception = assertThrows(
					DineroInsuficienteException.class,
					() -> {
						sample.debito(
								new BigDecimal("76.000"));
					});
			String actual = exception.getMessage();
			String esperado = "Dinero insuficiente";
			assertEquals(actual, esperado);

		}

		@Test
		@DisplayName("Probando transferencias")
		void testTransferirCuenta() {
			CuentaSample ronaldoAccount = new CuentaSample(
					"Ronaldo", new BigDecimal("85.000"));
			CuentaSample messiAccount = new CuentaSample(
					"Messi", new BigDecimal("100.000"));
			Banco banco = new Banco("Banco verde");
			banco.transferir(ronaldoAccount, messiAccount,
					new BigDecimal("50.000"));
			assertEquals(35.000, ronaldoAccount.getSaldo()
					.doubleValue());
			assertEquals(150.000,
					messiAccount.getSaldo().doubleValue());
		}

		// @Disabled se salta el test
		@Test
		@Disabled
		@DisplayName("Probando que se creen las relaciones entre bancos y cuentas")
		void testRelacionBancoCuentas() {

			// Forzar error
//			fail();

			CuentaSample ronaldoAccount = new CuentaSample(
					"Ronaldo", new BigDecimal("85.000"));
			CuentaSample messiAccount = new CuentaSample(
					"Messi", new BigDecimal("100.000"));
			Banco banco = new Banco("Banco verde");
			banco.addAccount(messiAccount);
			banco.addAccount(ronaldoAccount);

//			assertEquals(23, banco.getAccounts().size());
//			assertEquals("Banco verde2",
//					ronaldoAccount.getBanco().getNombre());
//			assertEquals("Ronaldo",
//					banco.getAccounts().stream()
//							.filter(m -> m.getPersona()
//									.equals("Ronaldo"))
//							.findFirst().get().getPersona());

//			assertTrue(banco.getAccounts().stream()
//					.filter(m -> m.getPersona().equals("Messi"))
//					.findFirst().isPresent());
			// ANOTHER WAY
			assertTrue(banco.getAccounts().stream()
					.anyMatch(m -> m.getPersona()
							.equals("Messi")));

			// AssertAll Way, in order to know what the exact error were
			assertAll(() -> assertEquals(2,
					banco.getAccounts().size(),
					() -> "El numero de cuentas no esta correcto"),
					() -> assertEquals("Banco verde",
							ronaldoAccount.getBanco()
									.getNombre(),
							() -> "Nombre del banco debe ser igual al del banco"),
					() -> assertEquals("Ronaldo", banco
							.getAccounts().stream()
							.filter(m -> m.getPersona()
									.equals("Ronaldo"))
							.findFirst().get()
							.getPersona()),
					() -> assertTrue(banco.getAccounts()
							.stream()
							.anyMatch(m -> m.getPersona()
									.equals("Messi"))));

		}

	}

	@Tag("os")
	@Nested
	class SistemaOperativoTest {
		@Test
		@EnabledOnOs(OS.WINDOWS)
		void testSoloWindows() {

		}

		@Test
		@EnabledOnOs({ OS.MAC, OS.LINUX })
		void testSoloMAC_Linux() {

		}

		// Se ejecuta cuando no sea windows
		@Test
		@DisabledOnOs(OS.WINDOWS)
		void testNoWindows() {

		}

	}

	@Nested
	class JavaVersionTest {
		@Test
		@EnabledOnJre(JRE.JAVA_8)
		void soloJdk8() {

		}
	}

	@Nested
	class SystemPropertiesTest {

		@Test
		void imprimirSystemProperties() {
//			Properties props = System.getProperties();
//			props.forEach((k, v) -> {
//				System.out
//						.println("Key: " + k + ", Value: " + v);
//			});
		}

		@Test
		@EnabledIfSystemProperty(named = "java.version", matches = "1.8.0_261")
		void testJavaVersion() {

		}

		@Test
		@DisabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
		void testSolo64() {

		}

		@Test
		@EnabledIfSystemProperty(named = "ENV", matches = "dev")
		void testDev() {

		}

		@Test
		void imprimirVariablesAmbiente() {
			Map<String, String> environmentVariables = System
					.getenv();
			environmentVariables.forEach((key, value) -> {
				System.out.println("Key: " + key
						+ ", Value: " + value);
			});
		}

	}

	class EnvironmentVariables {

		@Test
		@EnabledIfEnvironmentVariable(named = "JAVA_HOME", matches = ".*jdk-15.0.2.*")
		void testJavaHome() {

		}

		@Test
		@EnabledIfEnvironmentVariable(named = "NUMBER_OF_PROCESSORS", matches = "4")
		void testProcesadores() {

		}

		@Test
		@EnabledIfEnvironmentVariable(named = "ENVIRONMENT", matches = "dev")
		void testEnv() {

		}
	}

	@Test
	void testSaldoCuentaDev() {
		boolean esDev = "dev"
				.equals(System.getProperty("ENV"));
		// Se usa el assume para hacer la activacion o desactivacion de forma
		// programatica, sin usar anotaciones
		assumeTrue(esDev);
		assertNotNull(cuenta.getSaldo(),
				"La cuenta no puede ser nula");
		assertEquals(26.700,
				cuenta.getSaldo().doubleValue());
		assertFalse(cuenta.getSaldo()
				.compareTo(new BigDecimal(0)) < 0);

	}

	@Test
	void testSaldoCuentaDev2() {
		boolean esDev = "de"
				.equals(System.getProperty("ENV"));
		// Se usa el assume para hacer la activacion o desactivacion de forma
		// programatica, sin usar anotaciones
		assumingThat(esDev, () -> {
			assertNotNull(cuenta.getSaldo(),
					"La cuenta no puede ser nula");
			assertEquals(26.700,
					cuenta.getSaldo().doubleValue());
			assertFalse(cuenta.getSaldo()
					.compareTo(new BigDecimal(0)) < 0);
		});

	}

}
