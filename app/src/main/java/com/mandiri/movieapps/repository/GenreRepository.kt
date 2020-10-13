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

package com.mandiri.movieapps.repository

import androidx.lifecycle.MutableLiveData
import com.mandiri.movieapps.api.service.MovieService
import com.mandiri.movieapps.models.entity.Genres
import com.mandiri.movieapps.room.GenreDao
import com.skydoves.sandwich.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

class GenreRepository constructor(
    private val movieService:  MovieService,
    private val genreDao: GenreDao
) : Repository {

    init {
        Timber.d("Injection GenreRepository")
    }

}
