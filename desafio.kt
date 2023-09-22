// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(vararg usuarios: Usuario) {
        inscritos.addAll(usuarios)
        val duracaoTotal = conteudos.sumOf { it.duracao }
        usuarios.forEach { usuario ->
            println("Usuário ${usuario.nome} está matriculado na formação $nome. Duração total: $duracaoTotal minutos.")
        }
    }
}

fun main() {
    // Criando alguns conteúdos educacionais com duração padrão
    val conteudo1 = ConteudoEducacional("Introdução Prática à Linguagem de Programação Kotlin",60)
    val conteudo2 = ConteudoEducacional("Princípios de Interface de Usuário e Layouts Android", 90)
    val conteudo3 = ConteudoEducacional("Armazenamento de Dados Essencial em Apps Android com Kotlin", 90)
    val conteudo4 = ConteudoEducacional("Programação em Segundo Plano no Android com WorkManager", 120)

    // Criando formações com os conteúdos e associando um nível
    val formacaoKotlinBasico = Formacao("Kotlin Básico", listOf(conteudo1), Nivel.BASICO)
    val formacaoKotlinIntermediario = Formacao("Kotlin Intermediário", listOf(conteudo2, conteudo3), Nivel.INTERMEDIARIO)
    val formacaoKotlinAvancado = Formacao("Kotlin Avançado", listOf(conteudo4), Nivel.AVANCADO)

    // Criando alguns usuários
    val usuario1 = Usuario("João")
    val usuario2 = Usuario("Maria")
    val usuario3 = Usuario("Pedro")
    val usuario4 = Usuario("Paulo")
    val usuario5 = Usuario("Ana")
    
    // Matriculando os usuários nas formações
    formacaoKotlinBasico.matricular(usuario1, usuario4)
    formacaoKotlinIntermediario.matricular(usuario2)
    formacaoKotlinAvancado.matricular(usuario3, usuario5)

    // Verificando os inscritos nas formações
    println("Inscritos na formação ${formacaoKotlinBasico.nome}: ${formacaoKotlinBasico.inscritos.map { it.nome }}")
    println("Inscritos na formação ${formacaoKotlinIntermediario.nome}: ${formacaoKotlinIntermediario.inscritos.map { it.nome }}")
    println("Inscritos na formação ${formacaoKotlinAvancado.nome}: ${formacaoKotlinAvancado.inscritos.map { it.nome }}")
   
}

