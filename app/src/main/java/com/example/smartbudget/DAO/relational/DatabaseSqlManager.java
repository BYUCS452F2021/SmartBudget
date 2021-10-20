package com.example.smartbudget.DAO.relational;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.smartbudget.DAO.BudgetDao;
import com.example.smartbudget.DAO.CategoryDao;
import com.example.smartbudget.DAO.DaoFactory;
import com.example.smartbudget.DAO.ExpenditureDao;
import com.example.smartbudget.DAO.UserDao;
import com.example.smartbudget.Exceptions.DataAccessException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseSqlManager extends SQLiteOpenHelper implements DaoFactory {
    private static DatabaseSqlManager _instance;
    private List<SqlDao> databaseDAOs;
    private SqlDaoFactory factory;

    // Constructor take in path of database to connect to and need to decide how factory sets up DAOs
    // Create tables in constructor

    private DatabaseSqlManager(Context context, String path) {
        super(context, path, null, 1);
        initFactoryAndDao(this.getWritableDatabase());
    }

    private void initFactoryAndDao(SQLiteDatabase db){
        factory = new SqlDaoFactory(db);
        databaseDAOs = new ArrayList<>();
        databaseDAOs.add((UserSqlDao) factory.createUserDao());
        databaseDAOs.add((BudgetSqlDao) factory.createBudgetDao());
        databaseDAOs.add((CategorySqlDao) factory.createCategoryDao());
        databaseDAOs.add((ExpenditureSqlDao) factory.createExpenditureDao());
        createTables();
    }

    private static void init(Context context) {
        _instance = new DatabaseSqlManager(context, "db.sqlite");
    }

    public static DatabaseSqlManager getInstance(Context context) {
        if (_instance == null){
            init(context);
        }
        return _instance;
    }

    public void clearTables() {
        for (SqlDao dao : databaseDAOs){
            dao.clearTable();
        }
    }

    private void createTables() {
        for (SqlDao dao : databaseDAOs){
            dao.createTable();
        }
    }

    public void dropTables() {
        for (SqlDao dao : databaseDAOs){
            dao.dropTable();
        }
    }

    @Override
    public UserDao createUserDao() {
        return factory.createUserDao();
    }

    @Override
    public BudgetDao createBudgetDao() {
        return factory.createBudgetDao();
    }

    @Override
    public CategoryDao createCategoryDao() {
        return factory.createCategoryDao();
    }

    @Override
    public ExpenditureDao createExpenditureDao() {
        return factory.createExpenditureDao();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        createTables();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        dropTables();
        createTables();
    }
}

