package id.hasaneljabir.bundesligaschedule.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import id.hasaneljabir.bundesligaschedule.R
import id.hasaneljabir.bundesligaschedule.api.ApiServices
import id.hasaneljabir.bundesligaschedule.api.ApiUrl
import id.hasaneljabir.bundesligaschedule.model.EventData
import id.hasaneljabir.bundesligaschedule.model.TeamData
import id.hasaneljabir.bundesligaschedule.presenter.DetailMatchPresenter
import id.hasaneljabir.bundesligaschedule.repository.TeamRepositoryImplementation
import id.hasaneljabir.bundesligaschedule.utils.DateUtil
import id.hasaneljabir.bundesligaschedule.view.DetailMatchView
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(), DetailMatchView.View {
    lateinit var event: EventData
    lateinit var presenter: DetailMatchPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val service = ApiUrl.getClient().create(ApiServices::class.java)
        val request = TeamRepositoryImplementation(service)
        presenter = DetailMatchPresenter(this, request)

        event = intent.getParcelableExtra("match")
        presenter.getLogoHome(event.idHomeTeam)
        presenter.getLogoAway(event.idAwayTeam)
        initData(event)
        supportActionBar?.title = event.strEvent
    }

    fun initData(event: EventData) {
        txtDate.text = event.dateEvent?.let { DateUtil.formatDateToMatch(it) }
        txtNameHome.text = event.strHomeTeam
        txtNameAway.text = event.strAwayTeam
        txtScoreHome.text = event.intHomeScore
        txtScoreAway.text = event.intAwayScore
        txtHomeScorer.text = event.strHomeGoalDetails
        txtAwayScorer.text = event.strAwayGoalDetails
        txtGkHome.text = event.strHomeLineupGoalkeeper
        txtGkAway.text = event.strAwayLineupGoalkeeper
        txtDefHome.text = event.strHomeLineupDefense
        txtDefAway.text = event.strAwayLineupDefense
        txtMidHome.text = event.strHomeLineupMidfield
        txtMidAway.text = event.strAwayLineupMidfield
        txtForwardHome.text = event.strHomeLineupForward
        txtForwardAway.text = event.strAwayLineupForward
        txtSubtituteHome.text = event.strHomeLineupSubstitutes
        txtSubtituteAway.text = event.strAwayLineupSubstitutes
    }

    override fun showLogoHome(team: TeamData) {
        Glide.with(applicationContext)
            .load(team.strTeamBadge)
            .apply(RequestOptions().placeholder(R.drawable.ic_no_image))
            .into(imgLogoHome)
    }

    override fun showLogoAway(team: TeamData) {
        Glide.with(applicationContext)
            .load(team.strTeamBadge)
            .apply(RequestOptions().placeholder(R.drawable.ic_no_image))
            .into(imgLogoAway)
    }
}