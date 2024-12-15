package controllers

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


/**
 * Calcula el preu total de la compra.
 *
 * @param tipusBitllet El tipus de bitllet seleccionat.
 * @param numZones El nombre de zones seleccionades.
 * @param numBitllets El nombre de bitllets seleccionats.
 * @return El preu total de la compra.
 * @author Usman y Diego
 * @since 14/12/2024
 */
fun calcularPreuTotal(tipusBitllet: Int, numZones: Int, numBitllets: Int): Double {
    val preusBitllets = mapOf(
        1 to 2.40,
        2 to 11.35,
        3 to 40.00,
        4 to 10.00,
        5 to 80.00
    )
    val preuPerBitllet = preusBitllets[tipusBitllet] ?: error("Tipus de bitllet no vàlid")
    val preuSenseCanviZones = preuPerBitllet * numBitllets
    return aplicarIncrementZones(preuSenseCanviZones, numZones)
}

/**
 * Aplica un increment al preu segons el nombre de zones seleccionades.
 *
 * @param preu El preu base sense increments.
 * @param numZones El nombre de zones seleccionades.
 * @return El preu total amb l'increment aplicat.
 * @author Usman y Diego
 * @since 14/12/2024
 */
fun aplicarIncrementZones(preu: Double, numZones: Int): Double {
    return when (numZones) {
        1 -> preu
        2 -> preu * 1.3125
        3 -> preu * 1.8443
        else -> error("Nombre de zones no vàlid")
    }
}

/**
 * Finalitza la compra després d'introduir els diners i imprimir el tiquet.
 *
 * @param preuTotal El preu total de la compra.
 * @param scanner L'escàner per llegir l'entrada de l'usuari.
 * @author Usman y Diego
 * @since 14/12/2024
 */
fun finalitzarCompra(preuTotal: Double, scanner: Scanner) {
    val dinersIngresats = gestionarPagament(preuTotal, scanner)
    if (dinersIngresats >= preuTotal) {
        println("Bitllets comprats!")
        println("Canvi a tornar: ${dinersIngresats - preuTotal} €")
        imprimirTiquet(scanner)
    } else {
        println("Import insuficient. La compra s'ha cancel·lat.")
    }
}

/**
 * Gestiona el pagament del bitllet.
 *
 * @param preuTotal El preu total a pagar.
 * @param scanner L'escàner per llegir l'entrada de l'usuari.
 * @return El total de diners introduïts.
 * @author Usman y Diego
 * @since 14/12/2024
 */
fun gestionarPagament(preuTotal: Double, scanner: Scanner): Double {
    println("El preu total és: $preuTotal €")
    print("Introdueix els diners: ")
    var dinersIngresats = 0.0

    while (dinersIngresats < preuTotal) {
        if (scanner.hasNextDouble()) {
            dinersIngresats += scanner.nextDouble()
            if (dinersIngresats < preuTotal) {
                println("Import insuficient. Falten ${preuTotal - dinersIngresats} €")
            }
        } else {
            scanner.next() // Descarta l'entrada no vàlida
            println("Entrada no vàlida. Introdueix un número.")
        }
    }
    return dinersIngresats
}

/**
 * Pregunta a l'usuari si vol un tiquet i actua segons la resposta.
 *
 * @param scanner L'escàner per llegir l'entrada de l'usuari.
 * @author Usman y Diego
 * @since 14/12/2024
 */
fun imprimirTiquet(scanner: Scanner) {
    print("Vols un tiquet? (Si/No): ")
    val resposta = scanner.next().lowercase()
    if (resposta == "si") {
        println("Imprimint el tiquet...")
    }
}