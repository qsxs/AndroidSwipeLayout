package com.daimajia.swipedemo.base

import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.chad.library.adapter.base.util.MultiTypeDelegate

abstract class BaseRecyclerAdapter<T> : BaseQuickAdapter<T, BaseViewHolder> {
    constructor(layoutResId: Int, data: List<T>?) : super(layoutResId, data)
    constructor(data: List<T>?) : super(data)
    constructor(@LayoutRes layoutResId: Int) : super(layoutResId)

//    private var mMultiTypeDelegate: MultiTypeDelegate<T>? = null

    fun doOnItemClick(action: (BaseRecyclerAdapter<T>, T, View, Int) -> Unit) {
        setOnItemClickListener { _, view, position ->
            action.invoke(this, getItem(position)!!, view, position)
        }
    }

    fun doOnChildItemClick(action: (BaseRecyclerAdapter<T>, T, View, Int) -> Unit){
        setOnItemChildClickListener { _, view, position ->
            action.invoke(this, getItem(position)!!, view, position)
        }
    }

    fun setMultiTypeDelegate(delegate: (T?) -> Int): MultiTypeDelegate<T> {
        val mMultiTypeDelegate = object : MultiTypeDelegate<T>() {
            override fun getItemType(item: T?): Int {
                return delegate.invoke(item)
            }
        }
        multiTypeDelegate = mMultiTypeDelegate
        return mMultiTypeDelegate
    }

//    fun setMultiTypeDelegate(delegate: MultiTypeDelegate<T>?) {
//        mMultiTypeDelegate = delegate
//    }
//
//    fun getMultiTypeDelegate(): MultiTypeDelegate<T>? {
//        return mMultiTypeDelegate
//    }
//
//    override fun remove(@IntRange(from = 0L) position: Int) {
//        if (mData == null || position < 0 || position >= mData.size
//        ) return
//        val entity = mData[position]
//        if (entity is IExpandable<*>) {
//            removeAllChild(entity as IExpandable<*>, position)
//        }
//        removeDataFromParent(entity)
//        super.remove(position)
//    }
//
//    /**
//     * 移除父控件时，若父控件处于展开状态，则先移除其所有的子控件
//     *
//     * @param parent         父控件实体
//     * @param parentPosition 父控件位置
//     */
//    protected open fun removeAllChild(parent: IExpandable<*>, parentPosition: Int) {
//        if (parent.isExpanded) {
//            val chidChilds = parent.subItems
//            if (chidChilds == null || chidChilds.size == 0) return
//            val childSize = chidChilds.size
//            for (i in 0 until childSize) {
//                remove(parentPosition + 1)
//            }
//        }
//    }
//
//    /**
//     * 移除子控件时，移除父控件实体类中相关子控件数据，避免关闭后再次展开数据重现
//     *
//     * @param child 子控件实体
//     */
//    protected open fun removeDataFromParent(child: T) {
//        val position = getParentPosition(child)
//        if (position >= 0) {
//            val parent = mData[position] as IExpandable<*>
//            parent.subItems.remove(child)
//        }
//    }
//
//    /**
//     * 该方法用于 IExpandable 树形列表。
//     * 如果不存在 Parent，则 return -1。
//     *
//     * @param position 所处列表的位置
//     * @return 父 position 在数据列表中的位置
//     */
//    fun getParentPositionInAll(position: Int): Int {
//        val data = data
//        val multiItemEntity: T? = getItem(position)
//        if (isExpandable(multiItemEntity)) {
//            val expandableBean = multiItemEntity as IExpandable<*>?
//            for (i in position - 1 downTo 0) {
//                val entity = data[i]
//                if (isExpandable(entity) && expandableBean!!.level > (entity as IExpandable<*>).level) {
//                    return i
//                }
//            }
//        } else {
//            for (i in position - 1 downTo 0) {
//                val entity = data[i]
//                if (isExpandable(entity)) {
//                    return i
//                }
//            }
//        }
//        return -1
//    }
//
//    override fun getDefItemViewType(position: Int): Int {
//        return if (mMultiTypeDelegate != null) {
//            mMultiTypeDelegate!!.getDefItemViewType(mData, position)
//        } else {
//            super.getDefItemViewType(position)
//        }
//    }
//
//    override fun onCreateDefViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder? {
//        var layoutId = mLayoutResId
//        if (mMultiTypeDelegate != null) {
//            layoutId = mMultiTypeDelegate!!.getLayoutId(viewType)
//        }
//        return createBaseViewHolder(parent, layoutId)
//    }
}

fun BaseViewHolder.setSelected(@IdRes viewId: Int, selected: Boolean): BaseViewHolder {
    val view: View = getView<View>(viewId)
    view.isSelected = selected
    return this
}