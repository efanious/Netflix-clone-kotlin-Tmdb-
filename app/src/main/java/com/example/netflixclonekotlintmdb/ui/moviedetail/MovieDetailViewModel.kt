package com.example.netflixclonekotlintmdb.ui.moviedetail

import android.app.Application
import android.text.TextUtils
import androidx.arch.core.util.Function
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.Transformations
import com.example.netflixclonekotlintmdb.data.remote.response.Result

//class MovieDetailViewModel {
//}

class MovieDetailViewModel(application: Application, movie: Result) : AndroidViewModel(application) {


//    private val mRepository: DataRepository
//    private val mProducts: LiveData<List<ProductEntity>>
//    fun setQuery(query: CharSequence?) {
//        // Save the user's query into the SavedStateHandle.
//        // This ensures that we retain the value across process death
//        // and is used as the input into the Transformations.switchMap above
//        mSavedStateHandler.set(QUERY_KEY, query)
//    }

    /**
     * Expose the LiveData Products query so the UI can observe it.
     */
//    val products: LiveData<List<Any>>
//        get() = mProducts
//
//    companion object {
//        private const val QUERY_KEY = "QUERY"
//    }
//
//    init {
//        mRepository = (application as BasicApp).getRepository()
//
//        // Use the savedStateHandle.getLiveData() as the input to switchMap,
//        // allowing us to recalculate what LiveData to get from the DataRepository
//        // based on what query the user has entered
//        mProducts = Transformations.switchMap<CharSequence?, List<ProductEntity>>(
//            mSavedStateHandler.getLiveData("QUERY", null),
//            label@ Function<CharSequence?, LiveData<List<ProductEntity>>> { query: CharSequence? ->
//                if (TextUtils.isEmpty(query)) {
//                    return@label mRepository.getProducts()
//                }
//                mRepository.searchProducts("*$query*")
//            } as Function<CharSequence?, LiveData<List<ProductEntity>>>)
//    }
}
