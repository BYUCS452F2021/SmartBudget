package com.example.smartbudget;

import com.example.smartbudget.Model.Budget;
import com.example.smartbudget.Model.Category;
import com.example.smartbudget.Model.Expenditure;
import com.example.smartbudget.Model.User;

import java.time.LocalDate;
import java.util.List;

public class DataCache {
    private static DataCache _instance;
    private User _currUser;
    private List<Budget> _currBudgets;
    private Budget _budget;
    private List<Category> _currCategories;
    private LocalDate _currDate;
    private List<Expenditure> _currExpenditures;
    private Category _currCategory;
    private Expenditure _currExpenditure;

    private DataCache() {
    }

    public static DataCache getInstance(){
        if (_instance == null){
            _instance = new DataCache();
        }
        return _instance;
    }

    public User getCurrUser() {
        return _currUser;
    }

    public void setCurrUser(User _currUser) {
        this._currUser = _currUser;
    }

    public Budget getBudget() {
        return _budget;
    }

    public void setBudget(int position) {
        this._budget = _currBudgets.get(position);
    }

    public List<Budget> getCurrBudgets() {
        return _currBudgets;
    }

    public void setCurrBudgets(List<Budget> currBudgets) {
        this._currBudgets = currBudgets;
    }

    public void updateBudgets(List<Budget> newBudgets){
        this._currBudgets.clear();
        _currBudgets.addAll(newBudgets);
    }

    public void updateExpenditures(List<Expenditure> newExpenditures) {
        this._currExpenditures.clear();
        _currExpenditures.addAll(newExpenditures);
    }

    public List<Category> getCurrCategories() { return _currCategories; }

    public void setCurrCategories(List<Category> categories) { this._currCategories = categories; }

    public void updateCategories(List<Category> categories) {
        this._currCategories.clear();
        _currCategories.addAll(categories);
    }

    public LocalDate getCurrDate() {
        return _currDate;
    }

    public void setCurrDate(LocalDate _currDate) {
        this._currDate = _currDate;
    }

    public List<Expenditure> getCurrExpenditures() {
        return _currExpenditures;
    }

    public void setCurrExpenditures(List<Expenditure> _currExpenditure) {
        this._currExpenditures = _currExpenditure;
    }

    public Category getCurrCategory() {
        return _currCategory;
    }

    public void setCurrCategory(Category _currCategory) {
        this._currCategory = _currCategory;
    }

    public Expenditure getCurrExpenditure() {
        return _currExpenditure;
    }

    public void setCurrExpenditure(int position) {
        this._currExpenditure = _currExpenditures.get(position);
    }
}
