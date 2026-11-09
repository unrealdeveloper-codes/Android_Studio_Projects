package com.anshul.section12

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.GridView
import android.widget.ScrollView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

//    //Listview
//    lateinit var list : ListView

//    //RecycleView
//    private lateinit var recycleList : RecyclerView
//    private lateinit var countryNameList : ArrayList<String>
//    private lateinit var countryDetailsList : ArrayList<String>
//    private lateinit var imageList : ArrayList<Int>
//    private lateinit var adapter : CountryAdapter

//    //GridView
//    private lateinit var gridView : GridView
//    private lateinit var nameList : ArrayList<String>
//    private lateinit var imageList : ArrayList<Int>

//    //scroll view
//    lateinit var scrollView : ScrollView

    //wevview
    lateinit var webView: WebView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //wevview
        setContentView(R.layout.webview)

        webView = findViewById(R.id.webviewid)

        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.google.com/")

        onBackPressedDispatcher.addCallback(this,callback)


//        //scroll view
//        setContentView(R.layout.scrollview)
//
//        scrollView = findViewById(R.id.scrollviewid)


//        //grid view
//        setContentView(R.layout.gridview)
//
//        gridView = findViewById(R.id.gridViewid)
//
//        fill()
//
//        val adapter = AnimalAdapter(this,nameList,imageList)
//
//        gridView.adapter = adapter
//
//        gridView.setOnItemClickListener { _, _, position, _->
//            Toast.makeText(applicationContext,"You selected ${nameList[position]}",Toast.LENGTH_SHORT).show()
//
//         }


//        //RecycleView
//        setContentView(R.layout.recycleview)
//
//        recycleList = findViewById(R.id.recycleView)
//
//        recycleList.layoutManager =  LinearLayoutManager(this@MainActivity)
//
//        countryNameList = ArrayList()
//        countryDetailsList = ArrayList()
//        imageList = ArrayList()
//
//        countryNameList.add("India")
//        countryNameList.add("USA")
//        countryNameList.add("Russia")
//
//        countryDetailsList.add("This is India")
//        countryDetailsList.add("This is USA")
//        countryDetailsList.add("This is Russia")
//
//        imageList.add(R.drawable.indiaflag)
//        imageList.add(R.drawable.usaflag)
//        imageList.add(R.drawable.russsiaflag)
//
//        adapter = CountryAdapter(countryNameList,countryDetailsList,imageList,this@MainActivity)
//
//        recycleList.adapter = adapter


        //listView
//        setContentView(R.layout.listview)
//
//        list = findViewById(R.id.listview)
//
//        var countrylist = resources.getStringArray(R.array.countries)
//
//        var arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,countrylist)
//
//        list.adapter = arrayAdapter
//
//
//        list.setOnItemClickListener { parent, view, position, id ->
//
//            val countryName = parent.getItemAtPosition(position)
//
//            Toast.makeText(applicationContext, "Your country name is $countryName", Toast.LENGTH_LONG).show()
//        }


    }

    //web view

    private val callback = object : OnBackPressedCallback(true) {

        override fun handleOnBackPressed() {

            if (webView.canGoBack()) {
                webView.goBack()
            } else {
                finish()
            }

        }

    }


    //gridview
//    private fun fill(){
//        nameList = ArrayList()
//        imageList = ArrayList()
//
//        nameList.add("CAT")
//        nameList.add("DOG")
//        nameList.add("LION")
//        nameList.add("BIRD")
//        nameList.add("CHICKEN")
//        nameList.add("FISH")
//        nameList.add("MONKEY")
//        nameList.add("RABBIT")
//
//        imageList.add(R.drawable.cat)
//        imageList.add(R.drawable.dog)
//        imageList.add(R.drawable.lion)
//        imageList.add(R.drawable.bird)
//        imageList.add(R.drawable.chicken)
//        imageList.add(R.drawable.fish)
//        imageList.add(R.drawable.monkey)
//        imageList.add(R.drawable.rabbit)
//
//    }


}

