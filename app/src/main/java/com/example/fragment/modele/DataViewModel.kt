package com.example.fragment.modele

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataViewModel : ViewModel() {
    private var _dataForBinding = MutableLiveData<DataForBinding>()
    val dataForBinding : LiveData<DataForBinding> = _dataForBinding

    init{
        _dataForBinding.value = DataForBinding()
    }
    fun updateDataForBinding(data : DataForBinding){
        _dataForBinding.value = data
    }
    fun getDataForBinding() : DataForBinding{
        return _dataForBinding.value?: DataForBinding()
    }
}