object Weapons {
    val gun = object : AbstractWeapon(8, FireType.SingleShot) {
        override fun createAmmo(): Ammo {
            return Ammo.SIMPLE_BULLET
        }
    }
    val automaticGun = object : AbstractWeapon(15, FireType.RapidFire) {
        override fun createAmmo(): Ammo {
            return Ammo.BIG_BULLET
        }
    }
    val sniperRifle = object : AbstractWeapon(3, FireType.SingleShot) {
        override fun createAmmo(): Ammo {
            return Ammo.SNIPER_BULLET
        }
    }
}