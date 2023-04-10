abstract class AbstractWarrior(
    maxHealth: Int,
    override val chanceToDodge: Int,
    private val accuracy: Int,
    private val weapon: AbstractWeapon,
) : Warrior {

    override var isKilled = false

    private var currentHealth = maxHealth
    override fun toAttack(warrior: Warrior) {
        if (!weapon.isArmed) {
            val shots = weapon.getAmmoToShoot()
            var totalDamage = 0
            shots.forEach { _ ->
                if (avoidShot(warrior)) {
                    println("Missed! ha-ha!")
                } else {
                    totalDamage += calculateDamage()
                }
            }
            warrior.beingHit(totalDamage)
        } else {
            weapon.reload()
            println("Reloaded their weapon.")
        }
    }

    private fun avoidShot(warrior: Warrior): Boolean {
        val roll = (1..100).random()
        return roll <= warrior.chanceToDodge
    }

    private fun calculateDamage(): Int {
        val roll = (1..100).random()
        return if (roll <= accuracy) {
            (1..10).random()
        } else {
            println("missed!")
            0
        }
    }

    override fun beingHit(damage: Int) {
        currentHealth -= damage
        if (currentHealth <= 0) {
            isKilled = true
            currentHealth = 0
            println("Was killed!")
        } else {
            println("Took $damage damage and has $currentHealth health left.")
        }
    }
}
