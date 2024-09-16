package dh22km.course.recycleviewsnap

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import dh22km.course.simple_wheel_picker.BaseWheelPickerView
import dh22km.course.simple_wheel_picker.CustomWheelPickerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val values: ArrayList<String> = arrayListOf(
            "Hook",
            "Hulk",
            "Sentry",
            "Constantine",
            "Superman",
            "Spiderman",
        )

//        val layout = LinearLayout(this)
//        layout.layoutParams = LinearLayout.LayoutParams(
//            LinearLayout.LayoutParams.MATCH_PARENT,
//            LinearLayout.LayoutParams.MATCH_PARENT
//        )

        val customWheelPicker = CustomWheelPickerView(this)

        customWheelPicker.layoutParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.MATCH_PARENT
        )

        customWheelPicker.setWheelListener(object : BaseWheelPickerView.WheelPickerViewListener {
            override fun didSelectItem(picker: BaseWheelPickerView, index: Int) {
                println("Selected Item: ${customWheelPicker.adapter.values.getOrNull(index)}")
            }
        })

        customWheelPicker.selectedIndex = 1
        customWheelPicker.setData(values)

        //layout.addView(customWheelPicker)


        // Set the layout as the content view of the activity
        setContentView(customWheelPicker)
    }
}
