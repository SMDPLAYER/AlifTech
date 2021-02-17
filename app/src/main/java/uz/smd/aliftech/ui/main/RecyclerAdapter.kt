package uz.smd.aliftech.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_task.view.*
import uz.smd.aliftech.R
import uz.smd.aliftech.data.entities.MarsProperty
import uz.smd.aliftech.util.getScreenWidth

class RecyclerAdapter :
    RecyclerView.Adapter<VH>() {
    private var click: ((String) -> Unit)? = null
    private val list: ArrayList<MarsProperty> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH = VH(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_task, parent, false
        )
    )

    fun setOnClickListener(f: (String) -> Unit) {
        click = f
    }

    fun submitList(ls: List<MarsProperty>) {
        list.clear()
        list.addAll(ls)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: VH, position: Int) = holder.bind(list[position], click)

}

class VH(override val containerView: View) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {
    fun bind(posts: MarsProperty, click: ((String) -> Unit)?) {
        val image = itemView.imageType
        itemView.getLayoutParams().height = getScreenWidth(itemView.getContext()) / 3
        Glide.with(image.context)
            .load(posts.icon)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image)
            )
            .into(image)
        itemView.textExecutor.text = posts.startDate
        itemView.textName.text = posts.endDate
        itemView.name.text = posts.name
        itemView.textType.setText(R.string.remote)
        if (adapterPosition>0)
        itemView.imageNew.visibility=View.VISIBLE
        itemView.setOnClickListener {
            click?.invoke(posts.url)
        }
    }
}