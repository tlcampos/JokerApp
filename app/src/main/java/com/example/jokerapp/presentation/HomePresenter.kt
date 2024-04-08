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
        view.showProgress()
        fakeRequest()
    }

    fun onSucess(response: List<Category>) {
        val categories = response.map { CategoryItem(it) }
        view.showCategories(categories)
    }
    fun onError(message: String){
        view.showFailure(message)
        view.hideProgress()
    }

    fun onComplete() {
        view.hideProgress()
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

            onComplete()
            //onError("FALHA NA CONEXÃO. TENTE NOVAMENTE MAIS TARDE!")

        }, 1000)
    }
}