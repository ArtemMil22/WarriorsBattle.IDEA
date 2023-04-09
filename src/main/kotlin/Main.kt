fun main() {

    println("Enter the number of warriors in each team:")
    val numberOfWarriors = readLine()?.toInt() ?: return
    val team1 = Team(numberOfWarriors)
    val team2 = Team(numberOfWarriors)
    val battle = Battle(team1, team2)


    while (!battle.isBattleFinished) {
        battle.performNextIteration()
        when (val state = battle.getBattleState()) {
            is BattleState.InProgress -> println("Team 1 Health: ${state}, Team 2 Health: $state")
            is BattleState.Team1Victory -> println("Team 1 is the winner!")
            is BattleState.Team2Victory -> println("Team 2 is the winner!")
            is BattleState.Draw -> println("It's a draw!")
        }
    }
}
//    val team1 = Team(numberOfWarriors)
//    val team2 = Team(numberOfWarriors)
//    val battle = Battle(team1, team2)
//
//    while (!battle.battleFinished) {
//        val battleState = battle.performIteration()
//
//        when (battleState) {
//            is BattleState.Progress -> {
//                println("Team 1 health: ${battleState.team1Health}, Team 2 health: ${battleState.team2Health}")
//            }
//            is BattleState.Team1Won -> {
//                println("Team 1 won!")
//            }
//            is BattleState.Team2Won -> {
//                println("Team 2 won!")
//            }
//            is BattleState.Draw -> {
//                println("Draw!")
//            }
//        }
//    }
//
//    if (team1.isAlive()) {
//        println("Final winner: Team 1")
//    } else {
//        println("Final winner: Team 2")
//    }