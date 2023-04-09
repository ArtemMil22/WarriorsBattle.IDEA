import Weapons.sniperRifle

class WarriorSenior : AbstractWarrior(
    300, 30, 80, sniperRifle
) {
    override val isKilled: Boolean = false
    override fun beingHit(damage: Int) {
        println("OOOhhh")
    }
}