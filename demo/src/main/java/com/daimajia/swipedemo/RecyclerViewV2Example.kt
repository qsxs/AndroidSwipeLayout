package com.daimajia.swipedemo

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.daimajia.swipedemo.adapter.RecyclerViewV2Adapter
import kotlinx.android.synthetic.main.recyclerview.*

class RecyclerViewV2Example : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recyclerview)

        recycler_view.layoutManager = LinearLayoutManager(this)
        val adapter = RecyclerViewV2Adapter()
        recycler_view.adapter = adapter
        adapter.setNewData(arrayListOf(
//                "1ssssddddddda",
//                "s2sssddddddda",
//                "ss3ssddddddda",
//                "sss4sddddddda",
//                "ssss5ddddddda",
//                "ssssd6dddddda",
//                "ssssdd7ddddda",
//                "ssssddd8dddda",
//                "ssssdddd9ddda",
//                "ssssdddd0ddda",
//                "11ssssddddddda",
//                "ss11ssddddddda",
//                "ssss11ddddddda",
//                "ssssdd11ddddda",
//                "ssssdddd11ddda",
//                "ssssdddddd11da",
//                "ssssddddddda11",
//                "22ssssddddddda",
//                "ss33ssddddddda",
//                "ssss33ddddddda",
//                "ssssdd33ddddda",
//                "ssssdddd33ddda",
//                "ssssdddddd33da",
//                "ssssddddddda33",
                "ssssdd44444ddddda"
        ))

        adapter.doOnChildItemClick { baseRecyclerAdapter, s, view, i ->
            when (view.id) {
                R.id.ll_content -> Toast.makeText(this, s, Toast.LENGTH_LONG).show()
                R.id.trash -> Toast.makeText(this, "$s trash clicked", Toast.LENGTH_LONG).show()
                R.id.delete -> {
                    baseRecyclerAdapter.remove(i)
                    Toast.makeText(this, "$s 删除", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}