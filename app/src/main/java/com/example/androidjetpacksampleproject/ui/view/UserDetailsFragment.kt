package com.example.androidjetpacksampleproject.ui.view

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import butterknife.ButterKnife
import com.example.androidjetpacksampleproject.R
import com.example.androidjetpacksampleproject.core.BaseFragment
import com.example.androidjetpacksampleproject.core.ViewModelFactory
import com.example.androidjetpacksampleproject.data.repository.UserRepository
import com.example.androidjetpacksampleproject.databinding.LayoutUserDetailsBinding
import com.example.androidjetpacksampleproject.ui.viewmodel.UserViewModel

/**
 * @author Atik Faysal(Android Developer)
 * @Email mdatikfaysal@gmail.com
 * Created 11/9/2021 at 11:53 AM
 */
class UserDetailsFragment : BaseFragment<LayoutUserDetailsBinding, UserViewModel>()
{
    private lateinit var binding: LayoutUserDetailsBinding

    override val layoutId: Int
        get() = R.layout.layout_user_details

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialize()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = viewDataBinding
        binding.lifecycleOwner = this
        binding.userDetails = mViewModel
        ButterKnife.bind(this, mRootView)
    }

    override fun initialize() {}
}