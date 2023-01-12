package com.example.projectjuara.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectjuara.ICallBackNetwork
import com.example.projectjuara.MainActivity
import com.example.projectjuara.R
import com.example.projectjuara.adapter.MovieListAdapter
import com.example.projectjuara.model.OMDBDetailResponse
import com.example.projectjuara.model.SearchItem
import kotlinx.android.synthetic.main.fragment_list_order.*
import kotlinx.android.synthetic.main.fragment_list_order.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListOrder.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListOrder : Fragment(),ICallBackNetwork {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list_order, container, false)

//        view.btnSearch.setOnClickListener(View.OnClickListener {
//            (activity as MainActivity).searchMovie(view.spinner.selectedItem.toString(),this)
//            view.textView3.setText(view.spinner.selectedItem.toString())
//        })

        view.spinner.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                (activity as MainActivity).searchMovie(view.spinner.selectedItem.toString(),this@ListOrder)
                view.textView3.setText(view.spinner.selectedItem.toString())
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ListOrder.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ListOrder().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    lateinit var dataMovie :List<SearchItem>
    override fun onFinish(data: List<SearchItem>) {
        dataMovie = data
        var adapterx = MovieListAdapter()
        adapterx.data = data

        recyclerOrder.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterx
        }

    }

    override fun onFinishDetail(data: OMDBDetailResponse) {
        TODO("Not yet implemented")
    }

    override fun onFailed() {
        Toast.makeText(context,"Gagal mendownload data", Toast.LENGTH_LONG).show()
    }
}