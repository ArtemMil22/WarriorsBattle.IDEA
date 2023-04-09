import Weapons.gun

class WarriorJunior : AbstractWarrior(
    100, 10, 30, gun
) {
    override var isKilled: Boolean = false
    override fun beingHit(damage: Int) {
        println("Oaahhh")
    }
    override val chanceToDodge: Int
        get() = TODO("Not yet implemented")
}