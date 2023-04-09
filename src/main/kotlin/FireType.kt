
    sealed class FireType(val type: String, val countShots: Int){
        object SingleShot: FireType("SingleShoot",1)
        object RapidFire: FireType("RapidFire",3)
    }