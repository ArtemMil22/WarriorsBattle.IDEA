abstract class AbstractWeapon constructor(
    private val maxAmmo: Int,
    private val fireType: FireType,
) {
    private val currentListAmmo: MutableList<Ammo> = mutableListOf()
    val isArmed get() = currentListAmmo.isNotEmpty()
    abstract fun createAmmo(): Ammo
    fun reload() {
        for (i in 1..maxAmmo) {
            currentListAmmo.add(createAmmo())
        }
    }

    /* 2/ fun reload() {
    ammoList = (1..maxAmmo).map { createAmmo() }.toMutableList()} */
    fun getAmmoToShoot() {
        if (currentListAmmo.isEmpty()) {
            reload()
        } else {
            when (fireType) {
                FireType.SingleShot ->
                    currentListAmmo.removeAt(
                        currentListAmmo.size - fireType.countShots
                    )
                FireType.RapidFire ->
                    for (
                    i in currentListAmmo.lastIndex
                            downTo
                            currentListAmmo.size - fireType.countShots) {
                        currentListAmmo.removeAt(i)
                    }
            }
        }
    }
}
/*
fun getAmmoForShot(): List<Ammo> {
    val count = when (fireType) {
        is FireType.Single -> 1
        is FireType.Burst -> 3
    }
    val ammoForShot = ammoList.take(count)
    ammoList = ammoList.drop(count).toMutableList()
    return ammoForShot
}
 */
/*
        if (currentListAmmo.isEmpty()) {
            reload()
        } else {
            FireType.SingleShot ->
            currentListAmmo.removeAt(currentListAmmo.lastIndex)
            FireType.RapidFire ->
            for (i in currentListAmmo.lastIndex downTo currentListAmmo.size - fireType.countShots)
            {
                currentListAmmo.removeAt(i)
            }
        }
    }
 */
