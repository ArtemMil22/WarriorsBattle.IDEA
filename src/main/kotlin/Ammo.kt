import kotlin.random.Random

enum class Ammo(
    private val damage: Int,
    private val criticalDamageChance: Int,
    private val ratioCriticalDamage: Int,
) {
    SIMPLE_BULLET(3, 5, 2),
    BIG_BULLET(5, 10, 3),
    SNIPER_BULLET(10, 30, 4);

    fun getCurrentDamage(ammo: Ammo): Int {
        return if (Random.nextInt(until = 100) <= ammo.criticalDamageChance) {
            ammo.damage * ammo.ratioCriticalDamage
        } else ammo.damage
    }
}