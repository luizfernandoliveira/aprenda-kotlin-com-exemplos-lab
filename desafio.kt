enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome:String)

data class ConteudoEducacional(val nome: String, val duracao: Int, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(vararg usuario: Usuario) {
        for (usuarios in usuario) {
            inscritos.add(usuarios)
        }
    }
}

fun main() {
    val curso1 = ConteudoEducacional("python", 100, Nivel.INTERMEDIARIO)
    val curso2 = ConteudoEducacional("Kotlin", 30, Nivel.AVANCADO)
    val usuario1 = Usuario("Fernando")
    val usuario2 = Usuario("Luiz")
    val formacao1 = Formacao("Android", listOf(curso2))
    val formacao2 = Formacao("Análise de Dados", listOf(curso1))
  
    formacao1.matricular(usuario1, usuario2)
    formacao2.matricular(usuario1)
    
    println("Inscritos em ${formacao1.nome}:")
    for (inscrito in formacao1.inscritos){
        print("- ")
        println("${inscrito.nome}")
    }
    
    println("")
    println("Inscritos em ${formacao2.nome}:")
    for (inscrito in formacao2.inscritos){
        print("- ")
        println("${inscrito.nome}")
    }
}
