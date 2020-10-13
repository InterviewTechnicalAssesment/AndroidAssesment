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

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.skydoves.baserecyclerviewadapter.BaseAdapter
import com.skydoves.baserecyclerviewadapter.RecyclerViewPaginator
import com.mandiri.movieapps.R
import com.mandiri.movieapps.extension.visible
import com.mandiri.movieapps.models.Keyword
import com.mandiri.movieapps.models.Review
import com.mandiri.movieapps.models.Video
import com.mandiri.movieapps.models.entity.Movie
import com.mandiri.movieapps.models.entity.Genres
import com.mandiri.movieapps.view.adapter.GenreListAdapter
import com.mandiri.movieapps.view.adapter.MovieListAdapter
import com.mandiri.movieapps.view.adapter.ReviewListAdapter
import com.mandiri.movieapps.view.adapter.VideoListAdapter
import com.mandiri.movieapps.view.ui.main.MainActivityViewModel
import com.skydoves.whatif.whatIfNotNull
import com.skydoves.whatif.whatIfNotNullOrEmpty

@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, baseAdapter: BaseAdapter) {
  view.adapter = baseAdapter
}

@BindingAdapter("adapterMovieList")
fun bindAdapterMovieList(view: RecyclerView, movies: List<Movie>?) {
  movies.whatIfNotNull {
    (view.adapter as? MovieListAdapter)?.addMovieList(it)
  }
}

@BindingAdapter("adapterGenreList")
fun bindAdapterGenresList(view: RecyclerView, genres: List<Genres>?) {
  genres.whatIfNotNull {
    (view.adapter as? GenreListAdapter)?.addGenreList(it)
  }
}

@BindingAdapter("paginationMovieList")
fun paginationMovieList(view: RecyclerView, viewModel: MainActivityViewModel) {
  RecyclerViewPaginator(
    recyclerView = view,
    isLoading = { false },
    loadMore = { viewModel.postMoviePage(it) },
    onLast = { false }
  ).run {
    threshold = 4
    currentPage = 1
  }
}

@BindingAdapter("adapterVideoList")
fun bindAdapterVideoList(view: RecyclerView, videos: List<Video>?) {
  videos.whatIfNotNullOrEmpty {
    (view.adapter as? VideoListAdapter)?.addVideoList(it)
    view.visible()
  }
}

@BindingAdapter("adapterReviewList")
fun bindAdapterReviewList(view: RecyclerView, reviews: List<Review>?) {
  view.setHasFixedSize(true)
  reviews.whatIfNotNullOrEmpty {
    (view.adapter as? ReviewListAdapter)?.addReviewList(it)
    view.visible()
  }
}

@BindingAdapter("mapKeywordList")
fun bindMapKeywordList(chipGroup: ChipGroup, keywords: List<Keyword>?) {
  keywords.whatIfNotNullOrEmpty {
    chipGroup.visible()
    for (keyword in it) {
      chipGroup.addView(
        Chip(chipGroup.context).apply {
          text = keyword.name
          isCheckable = false
          setTextAppearanceResource(R.style.ChipTextStyle)
          setChipBackgroundColorResource(R.color.colorPrimary)
        })
    }
  }
}

