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

package com.mandiri.movieapps.api.service

import com.mandiri.movieapps.models.network.DiscoverMovieResponse
import com.mandiri.movieapps.models.network.GenreListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TheDiscoverService {

  @GET("/3/discover/movie?language=en&sort_by=popularity.desc")
  fun fetchDiscoverMovie(@Query("page") page: Int): Call<DiscoverMovieResponse>

  @GET("/3/genre/movie/list?language=en-US")
  fun fetchGenres(): Call<GenreListResponse>
}
