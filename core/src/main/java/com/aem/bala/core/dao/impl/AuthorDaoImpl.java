//package com.aem.bala.core.dao.impl;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.sql.ResultSet;
//import com.aem.bala.core.dao.AuthorDao;
//import com.aem.bala.core.models.Author;
//import com.aem.bala.core.services.DatabaseConnectionService;
//
//public class AuthorDaoImpl implements AuthorDao {
//	private static final Logger LOG = LoggerFactory.getLogger(AuthorDaoImpl.class);
//	Connection con;
//
//	public AuthorDaoImpl() {
//		super();
//
//	}
//
//	public AuthorDaoImpl(Connection con) {
//		this.con = con;
//
//	}
//
//	@Override
//	public List<Author> getAuthors() {
//		List<Author> authors = new ArrayList<Author>();
//		final String SQL = "select * from author";
//		try (PreparedStatement ps = con.prepareStatement(SQL); ResultSet rs = ps.executeQuery();) {
//
//			while (rs.next()) {
//				Author auth = new Author();
//				String id = rs.getString(1);
//				String name = rs.getString(2);
//				auth.setId(id);
//				auth.setId(name);
//				authors.add(auth);
//
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			LOG.error("error in fetching data",e);
//			
//		}
//		
////		System.out.println(authors);
//		return authors;
//	}
//
//}
