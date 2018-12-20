import java.util.Random

fun main(args: Array<String>) {
    println()
    println("*** BATALHA NAVAL ***")
    println()
    println("1 - Iniciar jogo Humano vs Computador")
    println("0 - Sair")
    println()
    var opcao: Int?
    var tabuleiroSize: Int?
    var nomeNaoFormatado :String
    var jogador: String =""
    var tabuleiro: String =""


    do {
        opcao = readLine()!!.toIntOrNull()

        when (opcao) {

            0 -> {
            }//Sair do programa

            1 -> {//Iniciar
                println("Escolha o tamanho do tabuleiro:")
                tabuleiroSize = readLine()!!.toIntOrNull()
                //valida tamanho tabuleiro
                while (tabuleiroSize == null || tabuleiroSize < 8 || tabuleiroSize >= 99) {
                    println(">>> Tamanho de tabuleiro inválido, tente novamente")
                    tabuleiroSize = readLine()!!.toIntOrNull()
                }


                println("Introduza o nome do jogador:")
                //valida nome
                do {
                    nomeNaoFormatado = readLine().orEmpty()
                    var jogadorCaracteres =0
                    for (caracter in nomeNaoFormatado) {
                        if (caracter != ' ') {
                            jogadorCaracteres++
                        }
                    }
                    if(nomeNaoFormatado.isEmpty() || jogadorCaracteres == 0 ){
                        println(">>> Nome inválido, tente novamente")
                    }
                }while(nomeNaoFormatado.isEmpty() || jogadorCaracteres == 0 )

                //formata nome
                var primeiroCaracter: Int =0
                var nomeOk=false
                for (caracter in 0..nomeNaoFormatado.length-1 ) {
                    if (nomeNaoFormatado[caracter] != ' ') {
                        primeiroCaracter++
                    }
                    if(primeiroCaracter>=1&&nomeNaoFormatado[caracter] == ' '){
                        nomeOk=true
                    }
                    if(nomeOk==false) {
                        if (primeiroCaracter == 1) {
                            jogador = jogador + nomeNaoFormatado[caracter].toUpperCase().toString()
                        } else {
                            jogador = jogador + nomeNaoFormatado[caracter].toLowerCase().toString()
                        }

                    }
                }






                println()
                println("Mapa do ${jogador}:")

                var numespaco = 1
                var count = 0
                //linha mar
                for (linha in 1..tabuleiroSize) {
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
                numespaco =1
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

                //inserir mavios
                println("$jogador, introduz a posição para 1 navio-tanque:")

                var navioTanque: Int?= readLine()!!.toIntOrNull()
                var tatuleiroTemp:String =""
                //valida navio-tanque

                while (navioTanque == null || navioTanque>tabuleiroSize-3 || navioTanque<0 ) {
                    println(">>> Possicao invalida inválido, tente novamente")
                    navioTanque= readLine()!!.toIntOrNull()
                }

                for(esp in 1..tabuleiroSize-1){
                    if(esp ==navioTanque ||esp ==navioTanque+1||esp ==navioTanque+2 ){
                        tatuleiroTemp = "${tatuleiroTemp}3"
                    }else{
                        tatuleiroTemp = "${tatuleiroTemp}~"
                    }
                }
                tabuleiro =tatuleiroTemp

                println("$tabuleiro")


            }
            else -> {
                println(">>> Dados de entrada inválidos, tente novamente")
            }
        }
    } while (opcao != 0)
}