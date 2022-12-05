package com.java.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.datasource.DataSource;
import com.java.dto.MovieVO;

public class MovieDAOImpl implements MovieDAO {
	
        private DataSource dataSource = DataSource.getInstance();
	
	
	    private List<MovieVO> getMovieList(ResultSet rs) throws SQLException {
	    MovieVO movie = null;
		List<MovieVO> movieList = new ArrayList<MovieVO>();
		while (rs.next()) {

			movie = new MovieVO();
			movie.setMovie_identical_number(rs.getString("movie_identical_number"));
			movie.setMovie_title(rs.getString("movie_title"));
			movie.setMovie_runtime(rs.getDate("movie_runtime"));
			movie.setMovie_director(rs.getString("movie_director"));
			movie.setMovie_genre(rs.getString("movie_genre"));
			movie.setMovie_releasedate(rs.getDate("movie_releasedate"));
			movie.setMovie_rating(rs.getString("movie_rating"));
			movie.setMovie_Description(rs.getString("movie_description"));
						
			
			movieList.add(movie);
		}

		return movieList;
	}

	@Override
	public List<MovieVO> selectSearchMovieList(String keyword) throws SQLException {
		
		Connection conn = dataSource.getConnection();

		Statement stmt = conn.createStatement();
		String sql = "select * from movie where title like '%'||'"+keyword+"'||'%'";
		
		ResultSet rs = stmt.executeQuery(sql);
		
		List<MovieVO> movieList = getMovieList(rs);
	
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(conn!=null) conn.close();
			
			
		return movieList;
	}

	@Override
	public List<MovieVO> selectMovieListByTheater(String theater_identical_number) throws SQLException {
		Connection conn = dataSource.getConnection();

		Statement stmt = conn.createStatement();
		String sql = "select * from movie where theater_identical_number = "+theater_identical_number;
		
		ResultSet rs = stmt.executeQuery(sql);
		
		List<MovieVO> movieList = getMovieList(rs);
	
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(conn!=null) conn.close();
			
			
		return movieList;
	}



	@Override
	public MovieVO selectMovieByMovie_identical_number(String movie_identical_number) throws SQLException {
		
		Connection conn = dataSource.getConnection();
		
		String sql = "select * from movie where movie_identical_number = ?";		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, movie_identical_number);
		
		ResultSet rs = pstmt.executeQuery();
		
		List<MovieVO> movieList = getMovieList(rs);
		MovieVO movie = movieList.size() > 0 ? movieList.get(0):null;
		
		
		if(rs!=null) rs.close();		
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
		
		return movie;
	}

	@Override
	public void insertMovie(MovieVO movie) throws SQLException {
		
		Connection conn = dataSource.getConnection();
		String sql = "insert into " 
				   + "movie( movie_identical_number, movie_title, movie_runtime, movie_director, movie_genre, movie_releasedate, movie_rating, movie_description,movie_actor) "  
				   + "values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,movie.getMovie_identical_number());
		pstmt.setString(2,movie.getMovie_title());
		pstmt.setDate(3, new java.sql.Date(movie.getMovie_runtime().getTime()));
		pstmt.setString(4,movie.getMovie_director());
		pstmt.setString(5,movie.getMovie_genre());
		pstmt.setDate(6, new java.sql.Date(movie.getMovie_releasedate().getTime()));
		pstmt.setString(7,movie.getMovie_rating());
		pstmt.setString(8,movie.getMovie_Description());
		pstmt.setString(9, movie.getMovie_actor());
		
		
		pstmt.executeUpdate();
		
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
	
	}

	@Override
	public void updateMovie(MovieVO movie) throws SQLException {
		Connection conn = dataSource.getConnection();
		String sql = " update movie" 
					+" set " 
				    +" getMovie_identical_number=?,getMovie_title=?,getMovie_runtime=?,getMovie_director=?, getMovie_genre=?, getMovie_releasedate=?, "  
				    +" getMovie_rating=?, getMovie_description=? ";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,movie.getMovie_identical_number());
		pstmt.setString(2,movie.getMovie_title());
		pstmt.setDate(3,(Date) movie.getMovie_runtime());
		pstmt.setString(4,movie.getMovie_director());
		pstmt.setString(5,movie.getMovie_genre());
		pstmt.setDate(6,(Date) movie.getMovie_releasedate());
		pstmt.setString(7,movie.getMovie_rating());
		pstmt.setString(8,movie.getMovie_Description());
		
		pstmt.executeUpdate();
		
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
	}

	@Override
	public void deleteMovie(String movie_identical_number) throws SQLException {
        
		Connection conn = dataSource.getConnection();
		
		String sql = "delete from movie where movie_identical_number=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, movie_identical_number);
		pstmt.executeUpdate();
		
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();

	}



}
