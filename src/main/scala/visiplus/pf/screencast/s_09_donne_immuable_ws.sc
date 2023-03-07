

/**
 * =Immutabilité=
 * L'immutabilité est l'une des règles principales qui mène à la programmation fonctionnelle. Elle impose qu'une valeur initialisée ne devrait jamais être remplacée au cours de sa vie, nous obligeant à initialiser une autre valeur si nous voulons appliquer une transformation.
 *
 * L'immutabilité a plusieurs avantages par rapport à la mutabilité :
 *   - Elle nous permet de conserver les états intermédiaires et de les récupérer plus tard.
 *   - Elle facilite le refactoring du code, car elle nous mène à un code référentiellement transparent.
 *   - Elle rend la programmation concurrente beaucoup plus facile à écrire, car rien ne change.
 *   - Pour les classes, elle nous permet de chaîner les opérations pour rendre le code plus lisible (patron : Fluent Interface).
 *
 * Cependant, l'immutabilité a aussi des inconvénients :
 *   - En créant une copie pour chaque opération, elle est moins optimisée que la mutabilité.
 *   - Elle est plus facile à créer des fuites de mémoire (cependant, grâce au collecteur de déchets Java, ce n'est pas un problème pour nous).
 */
class Mutable(var int: Int) {
  self =>
  def add(amount: Int): Unit = self.int = self.int + amount


  override def toString = s"Mutable(int=$int)"
}

val mutable1 = new Mutable(10)
val mutable2 = mutable1
mutable2.add(10)
mutable2.add(20)

mutable2
mutable1



//@TODO passer la classe en immuable
case class Immutable(int: Int) {
  def add(amount: Int): Immutable = copy(int = int + amount)
}

val immutable1 = Immutable(10)
val immutable2 = immutable1.add(10).add(20)
  
immutable1
  




case class CompteBancaireImmutable(solde: Double, id:String):
  def retirer(montant: Double): CompteBancaireImmutable = copy(solde = solde - montant)
  def deposer(montant: Double): CompteBancaireImmutable = copy(solde = solde + montant)



val compte1 = CompteBancaireImmutable(100.0, "1")
val compte2 = compte1.deposer(10.0)

val compte3 = compte2.retirer(20.0).retirer(30.0)

println(compte1.solde) // 100.0
println(compte2.solde) // 110.0
println(compte3.solde) //  60.0
println(compte3.solde - compte1.solde) // 40.0





