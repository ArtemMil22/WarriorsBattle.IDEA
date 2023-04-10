import Weapons.gun

class WarriorJunior : AbstractWarrior(
    100, 10, 30, gun
) {
    override var isKilled: Boolean = false
}