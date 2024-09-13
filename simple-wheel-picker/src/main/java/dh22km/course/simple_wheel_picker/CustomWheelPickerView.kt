package dh22km.course.simple_wheel_picker

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat

class CustomWheelViewHolder(itemView: TextView) :
    BaseWheelPickerView.ViewHolder<CustomWheelPickerView.Item>(itemView) {
    override fun onBindData(data: CustomWheelPickerView.Item) {
        (itemView as TextView).text = data.text
    }
}

class CustomWheelAdapter :
    BaseWheelPickerView.Adapter<CustomWheelPickerView.Item, CustomWheelViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomWheelViewHolder {
        val textView = TextView(parent.context).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, // width
                150 // height, you can adjust it accordingly or use WRAP_CONTENT
            )
            // Set other properties like text alignment, padding, etc.
            gravity = Gravity.CENTER
            textSize = 18f
            setPadding(16, 16, 16, 16)
            setTextColor(Color.BLACK)
        }

        // Return a ViewHolder with the programmatically created TextView
        return CustomWheelViewHolder(textView)
    }
}

class CustomWheelPickerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseWheelPickerView(context, attrs, defStyleAttr) {
    data class Item(val text: String)
    private val values: ArrayList<Item> = arrayListOf(
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
        view
    }

    val adapter: CustomWheelAdapter = CustomWheelAdapter()

    init {
        setAdapter(adapter)
        addView(highlightView)
        (highlightView.layoutParams as? LayoutParams)?.apply {
            width = ViewGroup.LayoutParams.MATCH_PARENT
            height = Color.BLACK
            gravity = Gravity.CENTER_VERTICAL
        }
        adapter.values = values
    }
}