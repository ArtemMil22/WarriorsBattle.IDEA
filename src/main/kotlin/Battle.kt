class Battle(private val team1: Team, private val team2: Team) {
    var isBattleFinished: Boolean = false


    fun getBattleState(): BattleState {

        val team1Alive = team1.teamList.any { it.isKilled }
        val team2Alive = team2.teamList.any { it.isKilled }

        return if (team1Alive && team2Alive) {
            BattleState.Progress(team1.teamList.filter { !it.isKilled }.sumOf { it.chanceToDodge },
                team2.teamList.filter { !it.isKilled }.sumOf { it.chanceToDodge })
        } else {
            isBattleFinished = true
            when {
                !team1Alive && !team2Alive -> BattleState.Draw
                !team1Alive -> BattleState.Team2Victory
                else -> BattleState.Team1Victory
            }
        }
    }

    fun performNextIteration() {
        team1.teamList.shuffle()
        team2.teamList.shuffle()

        val team1Alive = team1.teamList.any { !it.isKilled }
        val team2Alive = team2.teamList.any { !it.isKilled }

        if (team1Alive && team2Alive) {
            for (i in team1.teamList.indices) {
                if (!team1.teamList[i].isKilled && !team2.teamList[i].isKilled) {
                    team1.teamList[i].toAttack(team2.teamList[i])
                }
            }
        } else {
            isBattleFinished = true
        }
    }
}


