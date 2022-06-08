package com.example.fragment_manager2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragment_manager2.main.MainActivity
import com.example.fragment_manager2.R
import com.example.fragment_manager2.adapter.UserAdapter
import com.example.fragment_manager2.data.User
import com.example.fragment_manager2.myinterface.PostClickHandler


class HomeFragment : Fragment(), PostClickHandler {

    lateinit var recycleView: RecyclerView
    lateinit var mMainActivity: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        recycleView = view.findViewById(R.id.recycleView)
        mMainActivity = activity as MainActivity
        recycleView.layoutManager =
            LinearLayoutManager(mMainActivity, LinearLayoutManager.VERTICAL, false)
        val userAdapter = UserAdapter(this)
        userAdapter.setData(getListUser())
        recycleView.adapter = userAdapter

        val itemDecoration: RecyclerView.ItemDecoration =
            DividerItemDecoration(mMainActivity, DividerItemDecoration.VERTICAL)
        recycleView.addItemDecoration(itemDecoration)
        return view
    }

    private fun getListUser(): ArrayList<User> {
        val list: ArrayList<User> = ArrayList()
        for (i in 1..20) {
            val user = User("This is user " + i)
            list.add(user)
        }
        return list
    }

    override fun clickedPostItem(user: User) {
        val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(user)
        findNavController().navigate(action)
    }
}