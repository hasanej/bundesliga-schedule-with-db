package id.hasaneljabir.bundesligaschedule.view

import id.hasaneljabir.bundesligaschedule.model.TeamData

interface DetailMatchView {

    interface View {
        fun showLogoHome(team: TeamData)
        fun showLogoAway(team: TeamData)
    }

    interface Presenter {
        fun getLogoHome(id: String)
        fun getLogoAway(id: String)
        fun onDestroyPresenter()
    }
}