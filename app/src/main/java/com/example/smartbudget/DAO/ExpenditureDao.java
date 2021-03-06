package com.example.smartbudget.DAO;

import com.example.smartbudget.DAO.relational.SqlDao;
import com.example.smartbudget.DAO.relational.DatabaseSqlManager;
import com.example.smartbudget.Model.Budget;
import com.example.smartbudget.Model.Category;
import com.example.smartbudget.Model.Expenditure;
import com.example.smartbudget.Model.User;

import java.util.List;

public interface ExpenditureDao {
    void createExpenditure(Expenditure expenditure);
    List<Expenditure> getExpendituresForDay(Budget budget, int year, int month, int day);
    List<Expenditure> getExpendituresAll(Budget budget);
    void delete(Expenditure expenditure);
    void update(Expenditure expenditure, Category category);

}
