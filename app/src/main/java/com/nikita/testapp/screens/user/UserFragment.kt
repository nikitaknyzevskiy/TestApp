package com.nikita.testapp.screens.user


import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.nikita.testapp.R
import com.nikita.testapp.db.model.UserModel.UserModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_user.*


class UserFragment : Fragment(), Observer<UserModel> {

    private val mViewModel: UserViewModel by lazy {
        ViewModelProviders.of(this).get(UserViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mViewModel.getUser(arguments?.getString("id")!!).observe(this, this)

        user_call_btn.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${user_phone.text}")
            startActivity(intent)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onChanged(data: UserModel?) {
        if (data == null)
            return

        Picasso.get()
            .load(data.picture.large)
            .into(user_avatar)

        user_name.text = "${data.name.first} ${data.name.last}"

        user_phone.text = data.phone
    }


}
