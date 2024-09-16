package dh22km.course.simple_wheel_picker

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class CustomWheelViewHolder(itemView: TextView) :
    BaseWheelPickerView.ViewHolder<String>(itemView) {
    override fun onBindData(data: String) {
        (itemView as TextView).text = data
    }
}

class CustomWheelAdapter :
    BaseWheelPickerView.Adapter<String, CustomWheelViewHolder>() {
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
    private var values: ArrayList<String> = arrayListOf(
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

    fun setData(data: ArrayList<String>) {
        this.values = data;
        adapter.values = values
    }
}