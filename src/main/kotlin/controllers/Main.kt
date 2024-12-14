package org.example.controllers

import java.util.*

/**
 * Funció principal que gestiona la compra de bitllets.
 *
 * @author Usman y Diego
 * @since 14/12/2024
 */
fun main() {
    val scanner = Scanner(System.`in`)
    var seguirAmbLaCompra = true

    while (seguirAmbLaCompra) {
        mostrarMenu()

        if (scanner.hasNextInt()) {
            when (val opcio = scanner.nextInt()) {
                1 -> gestionarCompra(scanner)
                4321 -> aturarMaquina().also { seguirAmbLaCompra = false }
                else -> println("Opció no vàlida. Si us plau, torna-ho a intentar.")
            }
        } else {
            scanner.next() // Descarta l'entrada no vàlida
            println("Entrada no vàlida. Introdueix un número.")
        }
    }
}

/**
 * Mostra el menú principal de l'aplicació.
 *
 * @author Usman y Diego
 * @since 14/12/2024
 */
fun mostrarMenu() {
    println("Benvinguts!! Què vols fer?")
    println("1. Comprar bitllet")
    println("4321. Aturar la màquina")
    print("Selecciona una opció: ")
}

/**
 * Gestiona la compra d'un bitllet.
 *
 * @param scanner L'escàner per llegir l'entrada de l'usuari.
 * @author Usman y Diego
 * @since 14/12/2024
 */
fun gestionarCompra(scanner: Scanner) {
    val tipusBitllet = seleccionarTipusBitllet(scanner)
    val numZones = seleccionarZones(scanner)
    val numBitllets = seleccionarNumeroBitllets(scanner)
    val preuTotal = calcularPreuTotal(tipusBitllet, numZones, numBitllets)
    finalitzarCompra(preuTotal, scanner)
}

/**
 * Atura la màquina mitjançant el codi secret.
 *
 * @author Usman y Diego
 * @since 14/12/2024
 */
fun aturarMaquina() {
    println("Codi secret introduït. Aturant la màquina...")
}

/**
 * Solicita el tipus de bitllet que l'usuari desitja comprar.
 *
 * @param scanner L'escàner per llegir l'entrada de l'usuari.
 * @return El tipus de bitllet seleccionat.
 * @author Usman y Diego
 * @since 14/12/2024
 */
fun seleccionarTipusBitllet(scanner: Scanner): Int {
    println("Selecciona el tipus de bitllet que desitges comprar:")
    println("1. Bitllet senzill")
    println("2. TCasual")
    println("3. TUsual")
    println("4. TFamiliar")
    println("5. TJove")
    print("Introdueix el número del tipus de bitllet: ")
    return if (scanner.hasNextInt()) scanner.nextInt() else error("Entrada no vàlida")
}

/**
 * Solicita el nombre de zones seleccionades per l'usuari.
 *
 * @param scanner L'escàner per llegir l'entrada de l'usuari.
 * @return El nombre de zones seleccionades.
 * @author Usman y Diego
 * @since 14/12/2024
 */
fun seleccionarZones(scanner: Scanner): Int {
    println("Selecciona el nombre de zones (1-3): ")
    return if (scanner.hasNextInt()) scanner.nextInt() else error("Entrada no vàlida")
}

/**
 * Solicita el nombre de bitllets que es volen comprar.
 *
 * @param scanner L'escàner per llegir l'entrada de l'usuari.
 * @return El nombre de bitllets seleccionats.
 * @author Usman y Diego
 * @since 14/12/2024
 */
fun seleccionarNumeroBitllets(scanner: Scanner): Int {
    println("Introdueix el nombre de bitllets (1-3): ")
    return if (scanner.hasNextInt()) scanner.nextInt() else error("Entrada no vàlida")
}


