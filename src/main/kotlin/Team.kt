import kotlin.random.Random

class Team(countMembers: Int) {

    val teamList = mutableListOf<Warrior>()

    init {
        createTeam(countMembers)
    }

    private fun createTeam(countMembers: Int): List<Warrior> {
        repeat(countMembers) {
            when (Random.nextInt(100)) {
                in 70..100 -> teamList.add(WarriorSenior())
                in 35..69 -> teamList.add(WarriorMiddle())
                else -> teamList.add(WarriorJunior())
            }
            println(teamList)
        }
        return teamList
    }
}

