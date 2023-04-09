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


