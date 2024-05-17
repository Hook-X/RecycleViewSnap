package dh22km.course.recycleviewsnap

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layout = LinearLayout(this)
        layout.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )

        val customWheelPicker = CustomWheelPickerView(this)

        customWheelPicker.setWheelListener(object : BaseWheelPickerView.WheelPickerViewListener {
            override fun didSelectItem(picker: BaseWheelPickerView, index: Int) {
                println("Selected Item: ${customWheelPicker.adapter.values.getOrNull(index)}")
            }
        })

        customWheelPicker.selectedIndex = 1

        layout.addView(customWheelPicker)


        // Set the layout as the content view of the activity
        setContentView(layout)
    }
}