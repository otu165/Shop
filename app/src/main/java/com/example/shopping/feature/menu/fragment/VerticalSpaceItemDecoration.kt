package com.example.shopping.feature.menu.fragment

import android.graphics.Rect
import androidx.recyclerview.widget.RecyclerView

class VerticalSpaceItemDecoration(private val topSpace : Int,
                                  private val leftSpace : Int,
                                  private val rightSpace : Int,
                                  private val bottomSpace : Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, itemPosition: Int, parent: RecyclerView) {
        outRect.top = topSpace
        outRect.left = leftSpace
        outRect.right = rightSpace
        outRect.bottom = bottomSpace
    }
}