package id.hasaneljabir.bundesligaschedule.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import id.hasaneljabir.bundesligaschedule.fragment.LastMatchFragment
import id.hasaneljabir.bundesligaschedule.fragment.NextMatchFragment

class MatchViewPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {
    private val pages = listOf(
        LastMatchFragment(),
        NextMatchFragment()
    )

    override fun getItem(position: Int): Fragment { return pages[position] as Fragment }

    override fun getCount(): Int { return pages.size }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Last Match"
            else -> "Next Match"
        }
    }
}