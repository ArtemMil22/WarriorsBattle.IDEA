sealed class BattleState {

    data class Progress(
        val team1Health: Int, val team2Health: Int,
    ) : BattleState()

    object Team1Victory : BattleState()

    object Team2Victory : BattleState()

    object Draw : BattleState()
}