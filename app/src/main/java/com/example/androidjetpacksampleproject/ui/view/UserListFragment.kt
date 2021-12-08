package com.example.androidjetpacksampleproject.ui.view

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import com.example.androidjetpacksampleproject.R
import com.example.androidjetpacksampleproject.adapter.UserListAdapter
import com.example.androidjetpacksampleproject.core.BaseFragment
import com.example.androidjetpacksampleproject.data.model.Users
import com.example.androidjetpacksampleproject.databinding.LayoutUserListBinding
import com.example.androidjetpacksampleproject.di.PreferenceManager
import com.example.androidjetpacksampleproject.ui.viewmodel.UserViewModel
import com.example.androidjetpacksampleproject.utils.RecyclerViewUtils
import com.example.androidjetpacksampleproject.utils.Status
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * @author Atik Faysal(Android Developer)
 * @Email mdatikfaysal@gmail.com
 * Created 11/9/2021 at 11:53 AM
 */

@AndroidEntryPoint
class UserListFragment : BaseFragment<LayoutUserListBinding, UserViewModel>()
{
    private lateinit var binding: LayoutUserListBinding
    private val viewModel : UserViewModel by activityViewModels()
    private var adapter = UserListAdapter(arrayListOf())

    private lateinit var progressDialog : ProgressDialog

    @Inject
    lateinit var spManager: PreferenceManager

    override val layoutId: Int
        get() = R.layout.layout_user_list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = viewDataBinding
        binding.lifecycleOwner = this
        binding.userList = mViewModel
        initialize()
        userListObserver()
    }

    override fun initialize() {
        mContext = requireContext()
        RecyclerViewUtils.verticalOrientedRecyclerView(mContext, binding.recyclerView).adapter = adapter
        progressDialog = ProgressDialog(mContext)
        progressDialog.setTitle("Please wait")
        progressDialog.setMessage("Loading...")
        mViewModel.isLoading.observe(viewLifecycleOwner, {
            if(it) progressDialog.show()
            else progressDialog.dismiss()
        })

        spManager.setApiKey("Map key")
        spManager.setUserId("User Id")

        Log.d("print_api_key", spManager.getApiKey())
        Log.d("print_user_id", spManager.getUserId())

    }

    private fun userListObserver()
    {
        mViewModel.usersList.observe(viewLifecycleOwner, {
            when(it.status){
                Status.SUCCESS-> it.data?.let { user -> renderList(user)}
                Status.LOADING -> {}
                Status.ERROR -> Log.d("errorResponse",it.message.toString())
            }
        })
    }

    private fun renderList(items : List<Users>)
    {
        adapter.addData(items)
        adapter.notifyDataSetChanged()
    }
}