package id.hasaneljabir.bundesligaschedule.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import id.hasaneljabir.bundesligaschedule.R
import id.hasaneljabir.bundesligaschedule.adapter.MatchViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPagerMatch.adapter = MatchViewPagerAdapter(supportFragmentManager)
        tabMatch.setupWithViewPager(viewPagerMatch)
    }
}