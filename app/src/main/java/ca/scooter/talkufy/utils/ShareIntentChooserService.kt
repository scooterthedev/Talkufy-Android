package ca.scooter.talkufy.utils

import android.content.ComponentName
import android.content.IntentFilter
import android.os.Build
import android.service.chooser.ChooserTarget
import android.service.chooser.ChooserTargetService
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.M)
class ShareIntentChooserService : ChooserTargetService() {
    override fun onGetChooserTargets(
        targetActivityName: ComponentName?,
        matchedFilter: IntentFilter?
    ): MutableList<ChooserTarget> {
        val targets:MutableList<ChooserTarget> = ArrayList()
        for (target in targets) {
            val targetName = target.title
            val  targetIcon = target.icon
            val targetRanking = target.score
            val targetComponentName = target.componentName
            val targetExtras = target.intentExtras
            targets.add( ChooserTarget(
                    targetName, targetIcon, targetRanking, targetComponentName, targetExtras
            ))
        }
        return targets
    }
}