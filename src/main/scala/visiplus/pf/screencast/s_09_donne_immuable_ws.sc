

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
}

val mutable1 = Mutable(10)
val mutable2 = mutable1
mutable2.add(10)
mutable2.add(20)

//@TODO passer la classe en immuable
case class Immutable(int: Int) {
  def add(amount: Int): Immutable = Immutable(int + amount)
}

val immutable1 = Immutable(10)
val immutable2 =
  immutable1
    .add(10)
    .add(20)



