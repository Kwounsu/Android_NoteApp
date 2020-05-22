package com.example.noteapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class Adapter(context: Context, private val dataSource: ArrayList<Note>): BaseAdapter() {

    private var layoutInflater: LayoutInflater = context.getSystemService(
        Context.LAYOUT_INFLATER_SERVICE
    ) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val note = getItem(position)
        val viewHolder : ViewHolder
        val listItemRowView : View

        if (convertView == null) {
            listItemRowView = layoutInflater.inflate(R.layout.note_list_item, parent, false)
            viewHolder = ViewHolder()
            viewHolder.noteTitle = listItemRowView.findViewById(R.id.note_title_txt)
            viewHolder.noteDetail = listItemRowView.findViewById(R.id.note_detail_txt)
            listItemRowView.tag = viewHolder
        } else {
            listItemRowView = convertView
            viewHolder = listItemRowView.tag as ViewHolder
        }

        viewHolder.noteTitle.text = note.mNoteTitle
        viewHolder.noteDetail.text = note.mNoteDetail

        return listItemRowView
    }

    override fun getItem(position: Int): Note {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return dataSource.size
    }

    private class ViewHolder {
        lateinit var noteTitle : TextView
        lateinit var noteDetail : TextView
    }

}