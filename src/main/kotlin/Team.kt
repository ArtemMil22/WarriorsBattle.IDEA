import kotlin.random.Random

class Team(countMembers: Int) {
    init {
        generateWarriors(countMembers)
    }

    val teamList = mutableListOf<Warrior>()
    private fun generateWarriors(countMembers: Int): List<Warrior> {
        repeat(countMembers) {
            val random = Random.nextInt(100)
            val warrior = when {
                random < 30 -> WarriorSenior()
                random < 60 -> WarriorMiddle()
                else -> WarriorJunior()
            }
            teamList.add(warrior)
        }
        return teamList
    }
}
//(numberOfWarriors: Int) {
//    val warriors = mutableListOf<Warrior>()
//    init {
//        for (i in 1..numberOfWarriors) {
//            warriors.add(createWarrior())
//        }
//    }
//    private fun createWarrior(): Warrior {
//        val rank = Random.nextInt(1, 11)
//        return Warrior(rank)
//    }
//    fun isAlive() = warriors.any { it.isKilled }
//    fun shuffleWarriors() {
//        warriors.shuffle()
//    }
//    private fun createTeam(countMembers: Int):List<Warrior> {
//        val seniorWarriors = (countMembers * 0.2).toInt()
//        val juniorWarriors = (countMembers * 0.5).toInt()
//        val middleWarriors = (countMembers - (seniorWarriors + juniorWarriors))
////        teamList =
////            when {
////                it < seniorWarriors -> WarriorSenior("Senior Warrior $")
////                it >= seniorWarriors && it < (seniorWarriors + juniorWarriors) -> WarriorMiddle("Junior Warrior $it")
////                else -> WarriorJunior("Rookie Warrior $it")
////            }
//        for (i in 1..countMembers){
//         when(Random.nextInt(countMembers)){
//             in 60..100 -> teamList.add(WarriorSenior())
//             in 30..60 -> teamList.add(WarriorMiddle())
//             in 0..30 -> teamList.add(WarriorJunior())
//         }
//        }
//        return teamList
//    }
/*
class Team(private val numberOfWarriors: Int) {
val warriors: List<Warrior> = createWarriors(numberOfWarriors)
private fun createWarriors(number: Int): List<Warrior> {
    val list = mutableListOf<Warrior>()
    for (i in 1..number) {
        list.add(generateWarrior())
    }
    return list
}
private fun generateWarrior(): Warrior {
    val rank = (1..10).random()
    return when (rank) {
        in 1..3 -> Warrior(Rank.PRIVATE)
        in 4..6 -> Warrior(Rank.CORPORAL)
        in 7..8 -> Warrior(Rank.SERGEANT)
        in 9..10 -> Warrior(Rank.CAPTAIN)
        else -> Warrior(Rank.PRIVATE)
    }
}
class Team(private val numOfWarriors: Int) {
private var warriors: List = listOf()
init {
    setTeam()
}
private fun setTeam() {
    val seniorWarriors = (numOfWarriors * 0.2).toInt()
    val juniorWarriors = (numOfWarriors * 0.5).toInt()
    val rookieWarriors = (numOfWarriors - (seniorWarriors + juniorWarriors))

    warriors = List(numOfWarriors) {
        when {
            it < seniorWarriors -> SeniorWarrior("Senior Warrior $it")
            it >= seniorWarriors && it < (seniorWarriors + juniorWarriors) -> JuniorWarrior("Junior Warrior $it")
            else -> RookieWarrior("Rookie Warrior $it")
        }
    }
}
 */