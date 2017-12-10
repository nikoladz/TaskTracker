package DAO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentLinkedQueue;

public class DBUtility {
    private static DBUtility instance = null;
    private static int connectionPoolSize = 5;
    private ConcurrentLinkedQueue<Connection> connectionPool = null;
    private static Logger logger = LogManager.getLogger();

    private DBUtility(){
        try{

            logger.info("Initializing database connection pool.");

            connectionPool = new ConcurrentLinkedQueue<>();
            for(int i=0; i<connectionPoolSize; i++){
                connectionPool.add(DriverManager.getConnection("jdbc:mariadb://localhost:3306/tasktracker?user=tasktracker&password=123"));
            }

            logger.info("Database connection pool initialized.");

        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }
    public static synchronized DBUtility getInstance() {
        if(instance == null){
            instance = new DBUtility();
        }
        return instance;
    }

    public Connection getConnection(){
        return connectionPool.poll();
    }

    public void putConnection(Connection connection){
        connectionPool.add(connection);
    }
}
