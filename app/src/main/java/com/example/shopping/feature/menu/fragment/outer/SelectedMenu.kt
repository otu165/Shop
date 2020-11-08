package com.example.shopping.feature.menu.fragment.outer

import android.os.Parcel
import android.os.Parcelable

class SelectedMenu constructor(var title : String,
                               var description : String,
                               var cost : String,
                               var image : String) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!) {
    }

    override fun describeContents(): Int = 0

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        p0?.writeString(title)
        p0?.writeString(description)
        p0?.writeString(cost)
        p0?.writeString(image)
    }

    companion object CREATOR : Parcelable.Creator<SelectedMenu> {
        override fun createFromParcel(parcel: Parcel): SelectedMenu {
            return SelectedMenu(parcel)
        }

        override fun newArray(size: Int): Array<SelectedMenu?> {
            return arrayOfNulls(size)
        }
    }

}