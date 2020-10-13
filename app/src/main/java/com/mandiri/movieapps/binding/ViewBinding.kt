/*
 * Designed and developed by 2020 Syafiq Muhammad
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mandiri.movieapps.binding

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mandiri.movieapps.api.Api
import com.mandiri.movieapps.extension.requestGlideListener
import com.mandiri.movieapps.extension.visible
import com.mandiri.movieapps.models.entity.Movie
import com.skydoves.whatif.whatIfNotNull

@BindingAdapter("toast")
fun bindToast(view: View, text: LiveData<String>) {
  text.value.whatIfNotNull {
    Toast.makeText(view.context, it, Toast.LENGTH_SHORT).show()
  }
}

@BindingAdapter("visibilityByResource")
fun bindVisibilityByResource(view: View, anyList: List<Any>?) {
  anyList.whatIfNotNull {
    view.visible()
  }
}

@SuppressLint("SetTextI18n")
@BindingAdapter("bindReleaseDate")
fun bindReleaseDate(view: TextView, movie: Movie) {
  view.text = "Release Date : ${movie.release_date}"
}

@BindingAdapter("bindBackDrop")
fun bindBackDrop(view: ImageView, movie: Movie) {
  movie.backdrop_path.whatIfNotNull(
    whatIf = {
      Glide.with(view.context).load(Api.getBackdropPath(it))
        .listener(view.requestGlideListener())
        .into(view)
    },
    whatIfNot = {
      Glide.with(view.context).load(Api.getBackdropPath(movie.poster_path))
        .listener(view.requestGlideListener())
        .into(view)
    }
  )
}
