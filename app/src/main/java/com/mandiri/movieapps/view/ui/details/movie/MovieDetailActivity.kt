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

package com.mandiri.movieapps.view.ui.details.movie

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import com.mandiri.movieapps.R
import com.mandiri.movieapps.compose.ViewModelActivity
import com.mandiri.movieapps.databinding.ActivityMovieDetailBinding
import com.mandiri.movieapps.models.entity.Movie
import com.mandiri.movieapps.view.adapter.ReviewListAdapter
import com.mandiri.movieapps.view.adapter.VideoListAdapter
import org.koin.android.viewmodel.ext.android.getViewModel

class MovieDetailActivity : ViewModelActivity() {

  private val binding: ActivityMovieDetailBinding by binding(R.layout.activity_movie_detail)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val intentMovie: Movie = intent.getParcelableExtra<Movie>(movieId) as Movie
    with(binding) {
      activity = this@MovieDetailActivity
      lifecycleOwner = this@MovieDetailActivity
      viewModel =
        getViewModel(MovieDetailViewModel::class).apply { postMovieId(intentMovie.id) }
      movie = intentMovie
      videoListAdapter = VideoListAdapter()
      reviewListAdapter = ReviewListAdapter()
    }
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    if (item?.itemId == android.R.id.home) {
      onBackPressed()
    }
    return false
  }

  companion object {
    private const val movieId = "movie"
    fun startActivityModel(context: Context?, movie: Movie) {
      if (context is Activity) {
        context.startActivity(
          Intent(context, MovieDetailActivity::class.java).putExtra(movieId, movie))
      }
    }
  }
}
