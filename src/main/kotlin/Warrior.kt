interface Warrior {
    val isKilled: Boolean
    val chanceToDodge: Int
    fun toAttack(warrior: Warrior)
    fun beingHit(damage: Int)
}