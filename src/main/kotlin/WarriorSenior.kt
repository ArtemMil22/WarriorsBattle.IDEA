import Weapons.sniperRifle

class WarriorSenior : AbstractWarrior(
    300, 30, 80, sniperRifle
) {
    override var isKilled: Boolean = false
}