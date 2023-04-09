import Weapons.automaticGun

class WarriorMiddle : AbstractWarrior(
    200, 20, 50, automaticGun
) {
    override val isKilled: Boolean = false
    override fun beingHit(damage: Int) {
        println("aOOhhh")
    }
}