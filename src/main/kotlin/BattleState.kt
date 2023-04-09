sealed class BattleState {

    object InProgress : BattleState()

    data class Team1Victory(val team1Health: Team) : BattleState()

    data class Team2Victory(val team2Health: Team) : BattleState()

    object Draw : BattleState()
}
//  class Progress(val team1Health: Int, val team2Health: Int) : BattleState()
//    object Team1Won : BattleState()
//    object Team2Won : BattleState()
//    object Draw : BattleState()