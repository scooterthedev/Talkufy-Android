package ca.scooter.talkufy.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import android.view.ViewGroup

class ViewPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    val fragments:MutableList<Fragment> = ArrayList()
    val titles:MutableList<String> = ArrayList()

    fun addFragment(fragment: Fragment, title:String){
        fragments.add(fragment)
        titles.add(title)
    }

    override fun getItem(p0: Int): Fragment = fragments[p0]

    override fun getCount(): Int = fragments.size

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        super.destroyItem(container, position, `object`)
    }


}