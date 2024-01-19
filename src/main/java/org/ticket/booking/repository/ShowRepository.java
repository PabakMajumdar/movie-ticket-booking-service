package org.ticket.booking.repository;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.ticket.booking.entity.Show;

import java.sql.Date;
import java.sql.Time;
import java.util.List;


@Repository
public interface ShowRepository extends JpaRepository<Show, Id> {


   /* @Query("select s.theatres.theatre_id,s.showTiming " +
            "from Show s where s.movie.movie_title= :movie and s.showDate= :date")
    Show filterShowsByTheatre(@Param("movie") String movie_title
            ,@Param("date") String showDate );
*/

    // method to filter theatres by movie ,location and date

    @Query("select s.theatre.theatre_name,s.showTiming " +
            " from Show s WHERE s.movie.movie_title= :movie" +
            " and s.showDate= :date")
    List<Show> filterTheatres(@Param("movie") String movie_title,
                              @Param("city") String city, @Param("date") Date date);

    //display screen with section and seat details to user
    @Query("select s.auditorium.screen_id," +
            "s.auditorium.section," +
            "s.auditorium.capacity,s.auditorium.price from Show s" +
            " where s.theatre.theatre_name= :theatre_name and s.showTiming=: showTime")
    Show selectScreen(@Param("theatre_name") String theatreName,
                     @Param("show_time") Time showTime);

}
