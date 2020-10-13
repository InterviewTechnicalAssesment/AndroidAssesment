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

package com.mandiri.movieapps.view.ui.main

import androidx.lifecycle.*

import com.mandiri.movieapps.compose.DispatchViewModel
import com.mandiri.movieapps.models.entity.Genres
import com.mandiri.movieapps.models.entity.Movie
import com.mandiri.movieapps.models.network.GenreListResponse
import com.mandiri.movieapps.repository.DiscoverRepository
import com.mandiri.movieapps.repository.GenreRepository
import timber.log.Timber

class MainActivityViewModel constructor(
  private val discoverRepository: DiscoverRepository
) : DispatchViewModel() {

  private var moviePageLiveData: MutableLiveData<Int> = MutableLiveData()

  val movieListLiveData: LiveData<List<Movie>>
  val genreListLiveData: List<Genres>

  val toastLiveData: MutableLiveData<String> = MutableLiveData()

  init {
    Timber.d("injection MainActivityViewModel")

    this.movieListLiveData = moviePageLiveData.switchMap { page ->
      launchOnViewModelScope {
        discoverRepository.loadMovies(page) { toastLiveData.postValue(it) }
      }
    }
    this.genreListLiveData = discoverRepository.loadGenreList() { toastLiveData.postValue(it) }
  }

  fun postMoviePage(page: Int) = moviePageLiveData.postValue(page)
}
