package ca.scooter.talkufy.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import ca.scooter.talkufy.R


class TitleSubtitleView : LinearLayout {
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        initView()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initView()
    }

    constructor(context: Context) : super(context) {
        initView()
    }

    private fun initView() {
        val view = View.inflate(context, R.layout.item_selector, null)
        addView(view)
    }
}