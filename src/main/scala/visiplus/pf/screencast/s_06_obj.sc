

//----

// Définition de la classe Animal
sealed class Animal(val name: String, val age: Int) {
  // Méthode pour afficher les informations sur l'animal
  def displayInfo() = println(this.toString)

  def this(age:Int) = {
    this("no name", age)
  }

  override def toString = s"Nom : $name, Age : $age"
}

val toto = new Animal("toto", 2)

val noname = new Animal(4)

toto.displayInfo()

object Animal:
  def createRandomAnimal(): Animal =
    new Animal(scala.util.Random.nextInt(30))

  class Chat(name: String, age: Int, var couleur: String) extends Animal(name, age) {
    // Redéfinition de la méthode displayInfo pour afficher les informations sur le chat
    override def displayInfo() = println(s"Nom : $name, Age : $age, Couleur : $couleur")
  }

  class Chien(name: String, age:Int, val couleur:String) extends Animal(name, age)



Animal.createRandomAnimal()


val c: Animal.Chien = new Animal.Chien("felix", 2, "noir")

c.couleur
c.name
c.age
c.displayInfo()




//toto.age = 3


// Définition de la classe Chat qui hérite d'Animal


// Création d'un objet Animal
val animal = new Animal("Lion", 5)
// Affichage des informations sur l'animal
animal.displayInfo()

// Création d'un objet Chat
val chat = new Animal.Chat("Minou", 2, "Gris")
// Affichage des informations sur le chat
chat.displayInfo()
