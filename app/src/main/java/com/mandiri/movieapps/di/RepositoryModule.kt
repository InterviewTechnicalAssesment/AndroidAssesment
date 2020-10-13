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

package com.mandiri.movieapps.di

import com.mandiri.movieapps.repository.DiscoverRepository
import com.mandiri.movieapps.repository.GenreRepository
import com.mandiri.movieapps.repository.MovieRepository
import org.koin.dsl.module

val repositoryModule = module {
  single { DiscoverRepository(get(), get()) }
  single { MovieRepository(get(), get()) }
  single { GenreRepository(get(), get()) }
}
