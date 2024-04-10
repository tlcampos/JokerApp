package com.example.jokerapp.presentation

import com.example.jokerapp.data.CategoryRemoteDataSource
import com.example.jokerapp.data.ListCategoryCallback
import com.example.jokerapp.model.Category
import com.example.jokerapp.view.HomeFragment

class HomePresenter(
    private val view: HomeFragment,
    private val dataSource: CategoryRemoteDataSource
) : ListCategoryCallback {

    fun findAllCategories() {
        view.showProgress()
        dataSource.findAllCategories(this)
    }


    override fun onSuccess(response: List<String>) {
        val categories = response.map { Category(it, 0xFFFF0000) }
        view.showCategories(categories)
    }

    override fun onError(response: String) {
        view.showFailure(response)
        view.hideProgress()
    }

    override fun onComplete() {
        view.hideProgress()
    }

}