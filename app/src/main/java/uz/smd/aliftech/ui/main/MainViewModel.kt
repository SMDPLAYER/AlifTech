package uz.smd.aliftech.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import uz.smd.aliftech.data.entities.MarsProperty
import uz.smd.aliftech.model.MyRepository
import java.util.concurrent.Executors

/**
 * Created by Siddikov Mukhriddin on 2/13/21
 */
class MainViewModel @ViewModelInject constructor(private val repository: MyRepository) :
    ViewModel() {
    lateinit var data: LiveData<List<MarsProperty>>

    init {
        viewModelScope.launch {
            data = repository.getData()
        }
    }
}



