
class Battle(private val team1: Team, private val team2: Team) {
    var isBattleFinished: Boolean = false



    fun getBattleState(): BattleState {
        val team1AliveWarriors = team1.teamList.filter { it.chanceToDodge > 0 }
        val team2AliveWarriors = team2.teamList.filter { it.chanceToDodge > 0 }

        return if (team1AliveWarriors.isNotEmpty() && team2AliveWarriors.isNotEmpty()) {
            BattleState.InProgress
        } else {
            isBattleFinished = true
            if (team1AliveWarriors.isEmpty() && team2AliveWarriors.isEmpty()) {
                BattleState.Draw
            } else if (team1AliveWarriors.isEmpty()) {
                BattleState.Team1Victory(team1)
            } else {
                BattleState.Team2Victory(team2)
            }
        }
    }

    fun performNextIteration() {
        val allWarriors = team1.teamList + team2.teamList
        allWarriors.shuffled()
            .forEach { warrior ->
                if (warrior.chanceToDodge <= 0) return@forEach
                val opponentTeam = if (team1.teamList.contains(warrior)) team2 else team1
                val opponentWarrior = opponentTeam.teamList.shuffled().first { it.chanceToDodge > 0 }
                opponentWarrior.beingHit(warrior.chanceToDodge)
            }
    }
}

//class Battle(private val team1: Team, private val team2: Team) {
//    var isOver: Boolean = false
//    private fun performIteration() {
//        val warrior1 = team1.getWarrior()
//        val warrior2 = team2.getWarrior()
//        if (warrior1 != null && warrior2 != null) {
//            warrior2.healthPoints -= warrior1.damage
//            warrior1.healthPoints -= warrior2.damage
//        } else {
//            isOver = true
//        }
//    }
//    fun getBattleState(): BattleState {
//        val team1Alive = team1.hasAliveWarriors()
//        val team2Alive = team2.hasAliveWarriors()
//        return when {
//            !isOver && team1Alive && team2Alive -> BattleState.InProgress
//            isOver && team1Alive && !team2Alive -> BattleState.Team1Won
//            isOver && !team1Alive && team2Alive -> BattleState.Team2Won
//            else -> BattleState.Draw
//        }
//    }
//    fun start() {
//        while (!isOver) {
//            performIteration()
//            println(getBattleState())
//        }
//        val winner = if (team1.hasAliveWarriors()) team1 else team2
//        println("${winner} is the winner!")
//    }
//}
/*
class Battle(private val team1: Team, private val team2: Team) {
private var isFinished: Boolean = false

kotlin
Copy code
private fun nextIteration(): BattleState {
    val shuffledWarriors = (team1.getWarriors() + team2.getWarriors()).shuffled()

    var team1Health = team1.getWarriors().sumBy { it.health }
    var team2Health = team2.getWarriors().sumBy { it.health }

    for (warrior in shuffledWarriors) {
        if (team1Health <= 0 || team2Health <= 0) {
            break
        }
        if (team1.getWarriors().contains(warrior)) {
            team2Health -= warrior.strength
        } else {
            team1Health -= warrior.strength
        }
    }

    return when {
        team1Health > 0 && team2Health <= 0 -> BattleState.Team1Victory
        team2Health > 0 && team1Health <= 0 -> BattleState.Team2Victory
        team1Health <= 0 && team2Health <= 0 -> BattleState.Draw
        else -> BattleState.Progress(team1Health, team2Health)
    }
}

fun getState(): BattleState {
    if (isFinished) {
        TODO()
    }
    val team1Alive = team1.hasAliveWarriors()
    val team2Alive = team2.hasAliveWarriors()

    return if (team1Alive && team2Alive) {
        nextIteration()
    } else {
        isFinished = true
        when {
            team1Alive -> BattleState.Team1Victory
            team2Alive -> BattleState.Team2Victory
            else -> BattleState.Draw
        }
    }
}
}

fun main() {
val numOfWarriors = readLine()?.toInt() ?: 10
val team1 = Team(numOfWarriors)
val team2 = Team(numOfWarriors)

kotlin
Copy code
val battle = Battle(team1, team2)

while (!battle.isFinished) {
    val state = battle.getState()
    when (state) {
        is BattleState.Progress -> println("Team 1 Health: ${state.team1Health}, Team 2 Health: ${state.team2Health}")
        is BattleState.Team1Victory -> println("Team 1 is the winner!")
        is BattleState.Team2Victory -> println("Team 2 is the winner!")
        is BattleState.Draw -> println("It's a draw!")
    }
}
}
 */


