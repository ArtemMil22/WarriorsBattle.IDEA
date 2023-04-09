abstract class AbstractWarrior (
    maxHealth: Int,
    override val chanceToDodge: Int,
    val accuracy: Int,
    private val weapon: AbstractWeapon
) : Warrior {
    private var currentHealth = maxHealth
    override fun toAttack(warrior: Warrior) {
        if (!weapon.isArmed) {
            weapon.reload()
        }else {
            weapon.getAmmoToShoot()
        }
    }

    override fun beingHit(damage: Int) {
        currentHealth -= damage
    }
}
