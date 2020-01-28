package com.nikita.testapp.screens.home


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.nikita.testapp.R
import com.nikita.testapp.adapter.UsersAdapter
import com.nikita.testapp.db.model.UserModel.UserModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), Observer<PagedList<UserModel>> {

    private val mViewModel: HomeViewModel by lazy {
        ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }

    private val adapter = UsersAdapter {
        val args = Bundle()
        args.putString("id", it.id)
        Navigation.findNavController(home_list).navigate(R.id.action_homeFragment_to_userFragment, args)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        home_list.layoutManager = LinearLayoutManager(this.context!!).apply {
            orientation = RecyclerView.VERTICAL
        }

        home_list.adapter = adapter

        mViewModel.usersList.observe(this, this)

    }

    override fun onChanged(data: PagedList<UserModel>?) {
        adapter.submitList(data)
    }


}
