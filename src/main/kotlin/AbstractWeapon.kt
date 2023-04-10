abstract class AbstractWeapon(
    private val maxAmmo: Int,
    private val fireType: FireType,
) {
    private var currentListAmmo: MutableList<Ammo> = mutableListOf()
    val isArmed get() = currentListAmmo.isNotEmpty()
    abstract fun createAmmo(): Ammo
    fun reload() {
//        currentListAmmo.clear()
        println("I am reloading weapons")
        for (i in 1..maxAmmo) {
            currentListAmmo.add(createAmmo())
        }
    }

    fun getAmmoToShoot(): MutableList<Ammo> {
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
                            currentListAmmo.size - fireType.countShots
                    ) {
                        currentListAmmo.removeAt(i)
                    }
            }
        }
        return currentListAmmo
    }
}




