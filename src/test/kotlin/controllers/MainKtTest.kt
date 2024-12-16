package controllers

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MainKtTest {

 // Funció: calcularPreuTotal
 @Test
 fun checkCalcularPreuTotalValidInputSingleZone() {
  val tipusBitllet = 1 // Bitllet senzill
  val numZones = 1
  val numBitllets = 2
  val expected = 4.8 // 2.4 * 2
  val result = calcularPreuTotal(tipusBitllet, numZones, numBitllets)
  assertEquals(expected, result, "Error en el càlcul per una zona.")
 }

 @Test
 fun checkCalcularPreuTotalMultipleZones() {
  val tipusBitllet = 3 // TUsual
  val numZones = 2
  val numBitllets = 1
  val expected = 52.5 // 40.0 * 1.3125
  val result = calcularPreuTotal(tipusBitllet, numZones, numBitllets)
  assertEquals(expected, result, "Error en el càlcul per múltiples zones.")
 }

 @Test
 fun checkCalcularPreuTotalZeroBillets() {
  val tipusBitllet = 2 // TCasual
  val numZones = 1
  val numBitllets = 0
  val expected = 0.0 // No hi ha bitllets
  val result = calcularPreuTotal(tipusBitllet, numZones, numBitllets)
  assertEquals(expected, result, "Error en el càlcul quan no hi ha bitllets.")
 }

 // Funció: aplicarIncrementZones
 @Test
 fun checkAplicarIncrementZonesZone1() {
  val basePrice = 10.0
  val result = aplicarIncrementZones(basePrice, 1)
  val expected = 10.0 // Sense increment
  assertEquals(expected, result, "Increment incorrecte per una zona.")
 }

 @Test
 fun checkAplicarIncrementZonesZone2() {
  val basePrice = 10.0
  val result = aplicarIncrementZones(basePrice, 2)
  val expected = 13.125 // 10.0 * 1.3125
  assertEquals(expected, result, "Increment incorrecte per dues zones.")
 }

 @Test
 fun checkAplicarIncrementZonesZone3() {
  val basePrice = 10.0
  val result = aplicarIncrementZones(basePrice, 3)
  val expected = 18.443 // 10.0 * 1.8443
  assertEquals(expected, result, "Increment incorrecte per tres zones.")
 }

 @Test
 fun mostrarMenu() {
  // No es poden fer proves perquè interactua amb l'usuari per mostrar informació.
 }

 @Test
 fun gestionarCompra() {
  // No es poden fer proves perquè interactua amb l'usuari per mostrar informació.
 }

 @Test
 fun aturarMaquina() {
  // Imprimeix a la consola, sense lògica evaluable.
 }

 @Test
 fun seleccionarTipusBitllet() {
  // No es poden fer proves perquè interactua amb l'usuari per mostrar informació.
 }

 @Test
 fun seleccionarZones() {
  // No es poden fer proves perquè interactua amb l'usuari per mostrar informació.
 }

 @Test
 fun seleccionarNumeroBitllets() {
  // No es poden fer proves perquè interactua amb l'usuari per mostrar informació.
 }

 @Test
 fun finalitzarCompra() {
  // No es poden fer proves perquè interactua amb l'usuari per mostrar informació.
 }

 @Test
 fun gestionarPagament() {
  // No es poden fer proves perquè interactua amb l'usuari per mostrar informació.
 }

 @Test
 fun imprimirTiquet() {
  // No es poden fer proves perquè interactua amb l'usuari per mostrar informació.
 }
}
