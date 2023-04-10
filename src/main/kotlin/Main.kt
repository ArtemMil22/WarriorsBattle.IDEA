fun main() {

    println("Enter the number of warriors in each team:")
    val numbersOfTeammates = readLine()?.toInt() ?: return
    val team1 = Team(numbersOfTeammates)
    val team2 = Team(numbersOfTeammates)
    val battle = Battle(team1, team2)

    while (!battle.isBattleFinished) {
        println(battle.getBattleState())
        battle.performNextIteration()
    }
    when (val state = battle.getBattleState()) {
        is BattleState.Progress -> println("Team 1 Health: ${state}, Team 2 Health: $state")
        is BattleState.Team1Victory -> println("Team 1 is the winner!")
        is BattleState.Team2Victory -> println("Team 2 is the winner!")
        is BattleState.Draw -> println("It's a draw!")
    }
}
