package uz.smd.aliftech.util

import android.content.Context
import android.graphics.Point
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import androidx.recyclerview.widget.RecyclerView
import uz.smd.aliftech.R


/**
 * Created by Siddikov Mukhriddin on 2/14/21
 */
fun getScreenWidth(context: Context): Int {

        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        val size = Point()
        display.getSize(size)

    return size.y
}
fun runLayoutAnimation(recyclerView: RecyclerView) {
    val context: Context = recyclerView.context
    val controller: LayoutAnimationController =
        AnimationUtils.loadLayoutAnimation(context, R.anim.fall_down)
    recyclerView.layoutAnimation = controller
//    recyclerView.adapter!!.notifyDataSetChanged()
    recyclerView.scheduleLayoutAnimation()
}