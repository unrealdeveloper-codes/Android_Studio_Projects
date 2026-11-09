package com.anshul.section20part2

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment

class ListFragment : ListFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_list, container, false)

        // Inflate the layout for this fragment
        return  view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val arrayAdapter = activity?.let {
            ArrayAdapter.createFromResource(it, R.array.cities, android.R.layout.simple_list_item_1) }

        listAdapter = arrayAdapter

        listView.setOnItemClickListener { parent, view, position, id ->

            val intent = Intent(activity, SecondActivity::class.java)

            intent.putExtra("position", position)
            startActivity(intent)

        }

    }

}