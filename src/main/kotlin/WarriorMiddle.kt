import Weapons.automaticGun

class WarriorMiddle : AbstractWarrior(
    200, 20, 50, automaticGun
) {
    override var isKilled: Boolean = false
}