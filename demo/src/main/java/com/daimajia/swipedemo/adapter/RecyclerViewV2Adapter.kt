package com.daimajia.swipedemo.adapter

import com.chad.library.adapter.base.BaseViewHolder
import com.daimajia.swipedemo.R
import com.daimajia.swipedemo.base.BaseRecyclerAdapter

class RecyclerViewV2Adapter : BaseRecyclerAdapter<String>(R.layout.recyclerview_item) {
    override fun convert(helper: BaseViewHolder, item: String) {
        helper.setText(R.id.text_data, item)
                .addOnClickListener(R.id.ll_content)
                .addOnClickListener(R.id.delete)
                .addOnClickListener(R.id.trash)
    }
}