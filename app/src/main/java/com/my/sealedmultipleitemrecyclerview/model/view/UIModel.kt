package com.my.sealedmultipleitemrecyclerview.model.view

sealed class UIModel {
    data class ItemOne(val title: String, val itemType: Int):UIModel()
    data class ItemTwo(val title: String, val desc: String, val itemType: Int):UIModel()
    data class ItemThree(val title: String, val itemType: Int):UIModel()


}
