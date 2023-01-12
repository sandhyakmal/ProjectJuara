package com.example.projectjuara.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OMDBResponse(

	@field:SerializedName("Response")
	val response: String? = null,

	@field:SerializedName("totalResults")
	val totalResults: String? = null,

	@field:SerializedName("Search")
	val search: List<SearchItem?>? = null
) : Parcelable

@Parcelize
data class SearchItem(

	@field:SerializedName("Type")
	val type: String? = null,

	@field:SerializedName("Year")
	val year: String? = null,

	@field:SerializedName("imdbID")
	val imdbID: String? = null,

	@field:SerializedName("Poster")
	val poster: String? = null,

	@field:SerializedName("Title")
	val title: String? = null
) : Parcelable

