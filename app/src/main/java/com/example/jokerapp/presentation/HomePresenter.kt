package com.example.jokerapp.presentation

import android.os.Handler
import android.os.Looper
import com.example.jokerapp.model.Category
import com.example.jokerapp.view.CategoryItem
import com.example.jokerapp.view.HomeFragment

class HomePresenter(private val view: HomeFragment) {

    // VIEW -> PRESENTER
    // PRESENTER -> VIEW

    fun findAllCategories() {
        fakeRequest()
    }

    fun onSucess(response: List<Category>){
        val categories = mutableListOf<CategoryItem>()

        for (category in response){
            categories.add(CategoryItem(category))
        }
        view.showCategories(categories)
    }

    //SIMULAR UMA REQUISIÇÃO HTTP
    fun fakeRequest() {
        Handler(Looper.getMainLooper()).postDelayed({
            val response = arrayListOf(
                Category("Categoria 1", 0xffface6e),
                Category("Categoria 2", 0xffecd16d),
                Category("Categoria 3", 0xffded36e),
                Category("Categoria 4", 0xffcfd571)
            )
            //Lista Pronta (response)
            onSucess(response)
        }, 2000)
    }
}