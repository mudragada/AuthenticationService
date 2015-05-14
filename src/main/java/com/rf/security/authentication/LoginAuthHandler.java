package com.rf.security.authentication;
import java.io.FileNotFoundException;

import com.rf.util.DatabaseConnectUtil;
import com.rf.util.StringUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class LoginAuthHandler {

	/** A logger for debugging. */
//	private static final Logger log = LogManager.getRootLogger();

	/** Makes sure only one database handler is instantiated. */
	private static LoginAuthHandler singleton = new LoginAuthHandler();

	/** Used to insert a new user into the database. */
	private static final String REGISTER_SQL = "INSERT INTO user_authenticate (username, password, usersalt) "
			+ "VALUES (?, ?, ?);";

	private static final String USER_SQL = "SELECT username FROM user_authenticate WHERE username = ?";

	private static final String SALT_SQL = "SELECT usersalt FROM user_authenticate WHERE username = ?";

	private static final String AUTH_SQL = "SELECT username FROM user_authenticate "
			+ "WHERE username = ? AND password = ?";


	/** Used to configure connection to database. */
	private DatabaseConnectUtil db;

	/**
	 * Initializes an Auth handler for the Login example. Private constructor
	 * forces all other classes to use singleton.
	 */
	private LoginAuthHandler() {
		try {
			this.db = new DatabaseConnectUtil();
			System.out.println("Initialized db connection..");
		} catch (FileNotFoundException e) {
			System.out.println("Unable to find database.properties file");
		} catch (IOException e) {
			System.out.println("Unable to form the connection with the DB");
		}
	}

	/**
	 * Gets the single instance of the database handler.
	 * 
	 * @return instance of the database handler
	 */
	public static LoginAuthHandler getInstance() {
		return singleton;
	}


	/**
	 * Tests if a user already exists in the database. Requires an active
	 * database connection.
	 * 
	 * @param connection
	 *            - active database connection
	 * @param user
	 *            - username to check
	 * @return Status.OK if user does not exist in database
	 * @throws SQLException
	 */
	private boolean duplicateUser(Connection connection, String user)
			throws SQLException {
		boolean status = false;
		try (PreparedStatement statement = connection
				.prepareStatement(USER_SQL);) {
			// plug in user data into ?, 1 means the replace the first "?" with
			// user.
			statement.setString(1, user);
			statement.executeQuery();

			ResultSet results = statement.getResultSet();
			status = results.next() ? false : true;
		}
		return status;
	}

	/**
	 * Tests if a user already exists in the database. !!Can just call this
	 * method to make sure it the username is already in database.
	 * @param user
	 *            - username to check
	 * @return Status.OK if user does not exist in database
	 */
	public boolean duplicateUser(String user) {
		boolean status = false;

		try (Connection connection = db.getConnection()) {
			status = duplicateUser(connection, user);
		} catch (SQLException e) {
			status = false;
			System.out.println(e.getMessage());
		}
		return status;
	}

	/**
	 * Registers a new user, placing the username, password hash, and salt into
	 * the database if the username does not already exist.
	 * 
	 * @param newuser
	 *            - username of new user
	 * @param newpass
	 *            - password of new user
	 * @return {@link Status.OK} if registration successful
	 * @throws SQLException
	 */

	private boolean registerUser(Connection connection, String newuser,
			String newpass) throws SQLException {
		boolean status = false;

		byte[] saltbyte = StringUtil.randomBytes(16);
		String usersalt = StringUtil.encodeHex(saltbyte, 32);
		// save this hash in database.
		String passhash = StringUtil.getHash(newpass, usersalt);

		try (PreparedStatement statement = connection
				.prepareStatement(REGISTER_SQL);) {
			statement.setString(1, newuser);
			statement.setString(2, passhash);
			statement.setString(3, usersalt);
			statement.executeUpdate();
			status = true;
		}
		return status;
	}

	/**
	 * Registers a new user, placing the username, password hash, and salt into
	 * the database if the username does not already exist.
	 * 
	 * @param newuser
	 *            - username of new user
	 * @param newpass
	 *            - password of new user
	 */
	public boolean registerUser(String newuser, String newpass) {
		boolean status = false;

		// make sure we have non-null and non-emtpy values for login
		if (StringUtil.checkString(newuser)
				|| StringUtil.checkString(newpass)) {
			status = false;
			System.out.println(status);
			return status;
		}
		// try to connect to database and test for duplicate user
		try (Connection connection = db.getConnection()) {
			
			status = duplicateUser(connection, newuser);

			// if okay so far, try to insert new user
			if (status == true) {
				status = registerUser(connection, newuser, newpass);
			}
		} catch (SQLException ex) {
			status = false;
			System.out.println(ex.getMessage());
		}

		return status;
	}

	/**
	 * Gets the salt for a specific user.
	 * 
	 * @param connection
	 *            - active database connection
	 * @param user
	 *            - which user to retrieve salt for
	 * @return salt for the specified user or null if user does not exist
	 * @throws SQLException
	 *             if any issues with database connection
	 */
	private String getSalt(Connection connection, String user)
			throws SQLException {
		String salt = null;

		try (PreparedStatement statement = connection
				.prepareStatement(SALT_SQL);) {
			statement.setString(1, user);
			statement.executeQuery();

			ResultSet results = statement.getResultSet();
			salt = results.next() ? results.getString("usersalt") : null;
		}

		return salt;
	}

	/**
	 * Checks if the provided username and password match what is stored in the
	 * database. Requires an active database connection.
	 * 
	 * @param username
	 *            - username to authenticate
	 * @param password
	 *            - password to authenticate
	 * @throws SQLException
	 */
	private boolean authenticateUser(Connection connection, String username,
			String password) throws SQLException {

		boolean status = false;

		try (PreparedStatement statement = connection
				.prepareStatement(AUTH_SQL);) {
			String usersalt = getSalt(connection, username);
			String passhash = StringUtil.getHash(password, usersalt);

			statement.setString(1, username);
			statement.setString(2, passhash);
			statement.executeQuery();

			ResultSet results = statement.getResultSet();
			status = results.next() ? status = true : false;
		}

		return status;
	}

	/**
	 * Checks if the provided username and password match what is stored in the
	 * database. Must retrieve the salt and hash the password to do the
	 * comparison.
	 * 
	 * @param username
	 *            - username to authenticate
	 * @param password
	 *            - password to authenticate

	 */
	public boolean authenticateUser(String username, String password) {
		boolean status = false;
		
		try (Connection connection = db.getConnection()) {
			status = authenticateUser(connection, username, password);
		} catch (SQLException ex) {
			status = false;
			System.out.println(ex.getMessage());
		}
		return status;
	}
}
