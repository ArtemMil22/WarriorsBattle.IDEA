sealed class BattleState {

    object InProgress : BattleState()

    data class Team1Victory(val team1Health: Team) : BattleState()

    data class Team2Victory(val team2Health: Team) : BattleState()

    object Draw : BattleState()
}