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

package com.mandiri.movieapps.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.mandiri.movieapps.models.entity.Genres

@Dao
interface GenreDao {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertGenreList(Genre: List<Genres>)

  @Update
  fun updateMovie(Genre: Genres)

  @Query("SELECT * FROM Genres WHERE id = :id_")
  fun getGenre(id_: Int): Genres

  @Query("SELECT * FROM Genres")
  fun getGenresList(): List<Genres>
}
