package uz.smd.aliftech.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_main.*
import uz.smd.aliftech.R
import uz.smd.aliftech.data.entities.MarsProperty
import uz.smd.aliftech.util.runLayoutAnimation

/**
 * Created by Siddikov Mukhriddin on 2/13/21
 */
@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {
    lateinit var navcontroller: NavController
    private val adapter = RecyclerAdapter()
    private val viewModel: MainViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list.adapter = adapter
        handleLiveData()
        clickListener()
        navcontroller = Navigation.findNavController(view)
        runLayoutAnimation(list)
    }

    fun clickListener() {

        adapter.setOnClickListener {
            val bundle = bundleOf("url1" to it)
            navcontroller.navigate(R.id.action_mainFragment_to_descriptionFragment, bundle)
        }
    }

    @SuppressLint("FragmentLiveDataObserve")
    fun handleLiveData() {
        viewModel.data.observe(this, myData)
    }

    private val myData = Observer<List<MarsProperty>> {
        adapter.submitList(it)
    }
}