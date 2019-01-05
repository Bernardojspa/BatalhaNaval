import java.util.*

//var numero = Random().nextInt(20) + 10

fun main(args: Array<String>) {
    println()
    println("*** BATALHA NAVAL ***")
    println()
    println("1 - Iniciar jogo Humano vs Computador")
    println("0 - Sair")
    println()
    do {
        var queroVoltarAoInicio = false
        var opcao: Int? = readLine()!!.toIntOrNull()

        val contratorpedeiroSize = 3
        val navioTanqueSize = 2
        val submarinoSize = 1
        var navioTanque1Posicao: Int?
        var contratorpedeiro1Posicao: Int?
        var submarino1Posicao: Int?
        var navioTanquePcPosicao: Int
        var contratorpedeiroPcPosicao: Int
        var submarinoPcPosicao: Int

        var tabuleiroSize: Int?
        var nomeNaoFormatado: String = ""
        var jogador: String = ""
        var tabuleiro: String = ""
        var tabluleiroPC: String = ""
        var tatuleiroTemp: String = ""

        var numespaco = 1
        var count = 0

        when (opcao) {


            -1,0 -> {
            }//Sair do programa
            1 -> {//Iniciar


                println()
                println("*** BATALHA NAVAL ***")
                println()
                println("Escolha o tamanho do tabuleiro:")

                tabuleiroSize = readLine()!!.toIntOrNull()
               /* if (tabuleiroSize == -1) {
                    queroVoltarAoInicio = true
                }*/

//----------------------------------------------------------------------------//valida tamanho tabuleiro
                //if (!queroVoltarAoInicio) {
                    while (tabuleiroSize == null || tabuleiroSize < 8 || tabuleiroSize > 99) {
                        println(">>> Tamanho de tabuleiro inválido, tente novamente")
                        tabuleiroSize = readLine()!!.toIntOrNull()
                    }
                    if (tabuleiroSize == -1) {
                        queroVoltarAoInicio = true
                    }
                //}
//----------------------------------------------------------------------------//valida nome
                if (!queroVoltarAoInicio) {
                    println("Introduza o nome do jogador(a):")
                    do {
                        nomeNaoFormatado = readLine().orEmpty()
                        var jogadorCaracteres = 0
                        var jogadorNumerico = 0
                        for (caracter in nomeNaoFormatado) {
                            if (caracter != ' ') {
                                jogadorCaracteres++
                            }
                            if (caracter !in 'A'..'Z' && caracter !in 'a'..'z') {
                                jogadorNumerico++
                            }
                        }
                        if (nomeNaoFormatado.isEmpty() || jogadorCaracteres == 0 || jogadorNumerico > 0) {
                            println(">>> Nome inválido, tente novamente")
                        }
                    } while (nomeNaoFormatado.isEmpty() || jogadorCaracteres == 0 || jogadorNumerico > 0)
                }
//----------------------------------------------------------------------------//formata nome
                if (!queroVoltarAoInicio) {
                    var primeiroCaracter: Int = 0
                    var nomeOk = false
                    for (caracter in 0..nomeNaoFormatado.length - 1) {
                        if (nomeNaoFormatado[caracter] != ' ') {
                            primeiroCaracter++
                        }
                        if (primeiroCaracter >= 1 && nomeNaoFormatado[caracter] == ' ') {
                            nomeOk = true
                        }
                        if (nomeOk == false) {
                            if (primeiroCaracter == 1) {
                                jogador = jogador + nomeNaoFormatado[caracter].toUpperCase().toString()
                            } else {
                                jogador = jogador + nomeNaoFormatado[caracter].toLowerCase().toString()
                            }

                        }
                    }
                    //------------------------------------------mapa base

                    println()
                    println("Mapa do ${jogador}:")


                    //linha mar
                    for (linha in 0..tabuleiroSize - 1) {
                        tabuleiro = "${tabuleiro}~"
                    }
                    print("$tabuleiro")
                    println()
                    //linha cordenadas
                    while (count < tabuleiroSize) {
                        count++
                        print(numespaco)
                        if (numespaco == 9) {
                            numespaco = 0

                        } else {
                            numespaco += 1
                        }
                    }
                    println()
                    //linha cordenadas 10
                    numespaco = 1
                    for (linha in 1..1) {
                        for (coluna in 1..tabuleiroSize) {
                            if (coluna % 10 == 0) {
                                print(numespaco)
                                numespaco += 1
                            } else {
                                print(" ")
                            }
                        }
                        println()
                    }

                }
//----------------------------------------------------------------------------//inserir navio-tanque j1
               // if (!queroVoltarAoInicio) {
                    println("$jogador, introduz a posição para 1 navio-tanque:")

                    navioTanque1Posicao = readLine()!!.toIntOrNull()

                    //valida navio-tanque
                    while (navioTanque1Posicao == null || navioTanque1Posicao > tabuleiroSize - 2 || navioTanque1Posicao < 1) {
                        println(">>> Possicao invalida inválido, tente novamente")
                        navioTanque1Posicao = readLine()!!.toIntOrNull()
                    }
                    navioTanque1Posicao = navioTanque1Posicao - 1
                    for (esp in 0..tabuleiroSize - 1) {
                        if (esp == navioTanque1Posicao || esp == navioTanque1Posicao + 1 || esp == navioTanque1Posicao + 2) {
                            tatuleiroTemp = "${tatuleiroTemp}3"
                        } else {
                            tatuleiroTemp = "${tatuleiroTemp}~"
                        }
                    }
                    tabuleiro = tatuleiroTemp

//----------------------------------------------------------------------------Print Mapa navio-tanque j1
                    println("Mapa do ${jogador}:")
                    println("$tabuleiro")
                    //linha cordenadas
                    numespaco = 1
                    count = 0
                    while (count < tabuleiroSize) {
                        count++
                        print(numespaco)
                        if (numespaco == 9) {
                            numespaco = 0

                        } else {
                            numespaco += 1
                        }
                    }
                    println()
                    //linha cordenadas 10
                    numespaco = 1
                    for (linha in 1..1) {
                        for (coluna in 1..tabuleiroSize) {
                            if (coluna % 10 == 0) {
                                print(numespaco)
                                numespaco += 1
                            } else {
                                print(" ")
                            }
                        }
                        println()
                    }
               // }
//----------------------------------------------------------------------------//inserir contratorpedeiro j1
                //if (!queroVoltarAoInicio) {
                    tatuleiroTemp = ""
                    println("${jogador}, introduz a posição para 1 contratorpedeiro:")

                    contratorpedeiro1Posicao = readLine()!!.toIntOrNull()


                    //valida contratorpedeiro

                    while ((contratorpedeiro1Posicao == null || contratorpedeiro1Posicao > tabuleiroSize - 1 || contratorpedeiro1Posicao < 1) ||
                        (contratorpedeiro1Posicao > navioTanque1Posicao - 2 && contratorpedeiro1Posicao < navioTanque1Posicao + 5)
                    ) {
                        println(">>> Possicao invalida inválido, tente novamente")
                        contratorpedeiro1Posicao = readLine()!!.toIntOrNull()
                    }
                    contratorpedeiro1Posicao = contratorpedeiro1Posicao - 1
                    for (esp in 0..tabuleiroSize - 1) {
                        if ((esp == contratorpedeiro1Posicao || esp == contratorpedeiro1Posicao + 1)) {
                            tatuleiroTemp = "${tatuleiroTemp}2"
                        } else if (esp == navioTanque1Posicao || esp == navioTanque1Posicao + 1 || esp == navioTanque1Posicao + 2) {
                            tatuleiroTemp = "${tatuleiroTemp}3"
                        } else {
                            tatuleiroTemp = "${tatuleiroTemp}~"
                        }
                    }
                    tabuleiro = tatuleiroTemp

//----------------------------------------------------------------------------Print Mapa contratorpedeiro j1
                    println("Mapa do ${jogador}:")
                    println("$tabuleiro")

                    //linha cordenadas
                    numespaco = 1
                    count = 0
                    while (count < tabuleiroSize) {
                        count++
                        print(numespaco)
                        if (numespaco == 9) {
                            numespaco = 0

                        } else {
                            numespaco += 1
                        }
                    }
                    println()
                    //linha cordenadas 10
                    numespaco = 1
                    for (linha in 1..1) {
                        for (coluna in 1..tabuleiroSize) {
                            if (coluna % 10 == 0) {
                                print(numespaco)
                                numespaco += 1
                            } else {
                                print(" ")
                            }
                        }
                        println()
                    }
                //}
//----------------------------------------------------------------------------inserir submarino j1
                //if (!queroVoltarAoInicio) {
                    tatuleiroTemp = ""
                    println("${jogador}, introduz a posição para 1 submarino:")

                    submarino1Posicao = readLine()!!.toIntOrNull()

                    //valida submarino

                    while ((submarino1Posicao == null || submarino1Posicao > tabuleiroSize || submarino1Posicao < 1) ||
                        (submarino1Posicao > navioTanque1Posicao - 1 && submarino1Posicao < navioTanque1Posicao + 5) ||
                        (submarino1Posicao > contratorpedeiro1Posicao - 1 && submarino1Posicao < contratorpedeiro1Posicao + 4)
                    ) {
                        println(">>> Posição do navio inválida, tente novamente")
                        submarino1Posicao = readLine()!!.toIntOrNull()
                    }
                    submarino1Posicao = submarino1Posicao - 1
                    for (esp in 0..tabuleiroSize - 1) {
                        if ((esp == contratorpedeiro1Posicao || esp == contratorpedeiro1Posicao + 1)) {
                            tatuleiroTemp = "${tatuleiroTemp}2"
                        } else if (esp == navioTanque1Posicao || esp == navioTanque1Posicao + 1 || esp == navioTanque1Posicao + 2) {
                            tatuleiroTemp = "${tatuleiroTemp}3"
                        } else if (esp == submarino1Posicao) {
                            tatuleiroTemp = "${tatuleiroTemp}1"
                        } else {
                            tatuleiroTemp = "${tatuleiroTemp}~"
                        }
                    }
                    tabuleiro = tatuleiroTemp
//----------------------------------------------------------------------------Print Mapa submarino j1
                    println("Mapa do ${jogador}:")
                    println("$tabuleiro")

                    //linha cordenadas
                    numespaco = 1
                    count = 0
                    while (count < tabuleiroSize) {
                        count++
                        print(numespaco)
                        if (numespaco == 9) {
                            numespaco = 0

                        } else {
                            numespaco += 1
                        }
                    }
                    println()
                    //linha cordenadas 10
                    numespaco = 1
                    for (linha in 1..1) {
                        for (coluna in 1..tabuleiroSize) {
                            if (coluna % 10 == 0) {
                                print(numespaco)
                                numespaco += 1
                            } else {
                                print(" ")
                            }
                        }
                        println()
                    }
              //  }
//----------------------------------------------------------------------------inserir navio-tanque PC
                //if (!queroVoltarAoInicio) {
                    tatuleiroTemp = ""
                    navioTanquePcPosicao = Random().nextInt(tabuleiroSize)

                    //valida navio-tanque
                    while (navioTanquePcPosicao == null || navioTanquePcPosicao > tabuleiroSize - 2 || navioTanquePcPosicao < 1) {
                        navioTanquePcPosicao = Random().nextInt(tabuleiroSize)
                    }
                    navioTanquePcPosicao = navioTanquePcPosicao - 1
                    for (esp in 0..tabuleiroSize - 1) {
                        if (esp == navioTanquePcPosicao || esp == navioTanquePcPosicao + 1 || esp == navioTanquePcPosicao + 2) {
                            tatuleiroTemp = "${tatuleiroTemp}3"
                        } else {
                            tatuleiroTemp = "${tatuleiroTemp}~"
                        }
                    }
                    tabluleiroPC = tatuleiroTemp
//----------------------------------------------------------------------------//inserir contratorpedeiroPC PC
                    tatuleiroTemp = ""
                    contratorpedeiroPcPosicao = Random().nextInt(tabuleiroSize)

                    //valida contratorpedeiroPC
                    while ((contratorpedeiroPcPosicao == null || contratorpedeiroPcPosicao > tabuleiroSize - 1 || contratorpedeiroPcPosicao < 1) ||
                        (contratorpedeiroPcPosicao > navioTanquePcPosicao - 2 && contratorpedeiroPcPosicao < navioTanquePcPosicao + 5)

                    ) {
                        contratorpedeiroPcPosicao = Random().nextInt(tabuleiroSize)
                    }
                    contratorpedeiroPcPosicao = contratorpedeiroPcPosicao - 1
                    for (esp in 0..tabuleiroSize - 1) {
                        if ((esp == contratorpedeiroPcPosicao || esp == contratorpedeiroPcPosicao + 1)) {
                            tatuleiroTemp = "${tatuleiroTemp}2"
                        } else if (esp == navioTanquePcPosicao || esp == navioTanquePcPosicao + 1 || esp == navioTanquePcPosicao + 2) {
                            tatuleiroTemp = "${tatuleiroTemp}3"
                        } else {
                            tatuleiroTemp = "${tatuleiroTemp}~"
                        }
                    }
                    tabluleiroPC = tatuleiroTemp

//----------------------------------------------------------------------------//inserir submarinoPC PC
                //if (!queroVoltarAoInicio) {
                    tatuleiroTemp = ""
                    submarinoPcPosicao = Random().nextInt(tabuleiroSize)

                    //valida submarinoPC
                    while ((submarinoPcPosicao == null || submarinoPcPosicao > tabuleiroSize || submarinoPcPosicao < 1) ||
                        (submarinoPcPosicao > navioTanquePcPosicao - 1 && submarinoPcPosicao < navioTanquePcPosicao + 5) ||
                        (submarinoPcPosicao > contratorpedeiroPcPosicao - 1 && submarinoPcPosicao < contratorpedeiroPcPosicao + 4)
                    ) {
                        submarinoPcPosicao = Random().nextInt(tabuleiroSize)
                    }
                    submarinoPcPosicao = submarinoPcPosicao - 1
                    for (esp in 0..tabuleiroSize - 1) {
                        if ((esp == contratorpedeiroPcPosicao || esp == contratorpedeiroPcPosicao + 1)) {
                            tatuleiroTemp = "${tatuleiroTemp}2"
                        } else if (esp == navioTanquePcPosicao || esp == navioTanquePcPosicao + 1 || esp == navioTanquePcPosicao + 2) {
                            tatuleiroTemp = "${tatuleiroTemp}3"
                        } else if (esp == submarinoPcPosicao) {
                            tatuleiroTemp = "${tatuleiroTemp}1"
                        } else {
                            tatuleiroTemp = "${tatuleiroTemp}~"
                        }
                    }
                    tabluleiroPC = tatuleiroTemp
                //}
//----------------------------------------------------------------------------Print Mapa PC?
                //if (!queroVoltarAoInicio) {
                    println("Pretende ver o mapa gerado para o Computador? (S/N)")
                    var verMapaPC: String = readLine().orEmpty()

                    while (verMapaPC.isEmpty() || verMapaPC[0] != 'N' || verMapaPC[0] != 'S') {
                        println("Pretende ver o mapa gerado para o Computador? (S/N)cbfdna")
                        verMapaPC = readLine().orEmpty()
                    }
                //}
                  //  if (!queroVoltarAoInicio) {
                    if (verMapaPC[0] == 'S') {
                        println("Mapa do Computador:")
                        println("$tabluleiroPC")
                        //linha cordenadas
                        numespaco = 1
                        count = 0
                        while (count < tabuleiroSize) {
                            count++
                            print(numespaco)
                            if (numespaco == 9) {
                                numespaco = 0

                            } else {
                                numespaco += 1
                            }
                        }
                        println()
                        //linha cordenadas 10
                        numespaco = 1
                        for (linha in 1..1) {
                            for (coluna in 1..tabuleiroSize) {
                                if (coluna % 10 == 0) {
                                    print(numespaco)
                                    numespaco += 1
                                } else {
                                    print(" ")
                                }
                            }
                            println()
                        }
                    }
                //}
//----------------------------------------------------------------------------


            }
            else -> {
                println(">>> Dados de entrada inválidos, tente novamente")
                println(">")
            }
        }
    } while (opcao != 0)
}