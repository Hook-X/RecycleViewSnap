package dh22km.course.recycleviewsnap

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import dh22km.course.recycleviewsnap.databinding.InfoTextBinding

class CustomWheelViewHolder(itemView: View) :
    BaseWheelPickerView.ViewHolder<CustomWheelPickerView.Item>(itemView) {
    val binding = InfoTextBinding.bind(itemView)
    override fun onBindData(data: CustomWheelPickerView.Item) = with(binding) {
        tvInfo.text = data.text
    }
}

class CustomWheelAdapter :
    BaseWheelPickerView.Adapter<CustomWheelPickerView.Item, CustomWheelViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomWheelViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.info_text, parent, false)
        return CustomWheelViewHolder(view)
    }
}

class CustomWheelPickerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseWheelPickerView(context, attrs, defStyleAttr) {
    data class Item(val text: String)
    private val values: ArrayList<CustomWheelPickerView.Item> = arrayListOf(
        Item("Hook"),
        Item("Hulk"),
        Item("Sentry"),
        Item("Constantine"),
        Item("Superman"),
        Item("Spiderman"),
        Item("Xenos"),
        Item("Narin"),
    )

    private val highlightView: View = run {
        val view = View(context)
        view.background = ContextCompat.getDrawable(context, R.drawable.custom_wheel_highlight_bg)
        view
    }

    val adapter: CustomWheelAdapter = CustomWheelAdapter()

    init {
        setAdapter(adapter)
        addView(highlightView)
        (highlightView.layoutParams as? LayoutParams)?.apply {
            width = ViewGroup.LayoutParams.MATCH_PARENT
            height =
                context.resources.getDimensionPixelSize(R.dimen.custom_wheel_picker_item_height)
            gravity = Gravity.CENTER_VERTICAL
        }
        adapter.values = values
    }
}