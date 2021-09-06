package com.a2048.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.a2048.R
import com.a2048.view.ui.GamerTextView

/**
 * Gameboard adapter class to render the boxes on gameview
 */
class GameBoardAdapter(_context: Context, array: ArrayList<Int>) : BaseAdapter() {

    private var list = array
    private var context = _context

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(context).inflate(R.layout.grid,null)
        view.findViewById<GamerTextView>(R.id.text).text = if(list[position]>0) list[position].toString() else ""
        return view
    }

    fun setData(array: java.util.ArrayList<Int>) {
        list = array
        notifyDataSetChanged()
    }
}