package com.split2;

import java.util.List;

import com.split2.models.User;
import com.split2.models.expense.EqualExpense;
import com.split2.models.expense.ExactExpense;
import com.split2.models.expense.Expense;
import com.split2.models.expense.ExpenseMetadata;
import com.split2.models.expense.ExpenseType;
import com.split2.models.expense.PercentExpense;
import com.split2.models.split.PercentSplit;
import com.split2.models.split.Split;

public class ExpenseService {
    public static Expense createExpense(ExpenseType expenseType, double amount, User paidBy, List<Split> splits, ExpenseMetadata expenseMetadata) {
        switch (expenseType) {
            case EXACT:
                return new ExactExpense(amount, paidBy, splits, expenseMetadata);
            case PERCENT:
                for (Split split : splits) {
                    PercentSplit percentSplit = (PercentSplit) split;
                    split.setAmount((amount*percentSplit.getPercent())/100.0);
                }
                return new PercentExpense(amount, paidBy, splits, expenseMetadata);
            case EQUAL:
                int totalSplits = splits.size();
                double splitAmount = ((double) Math.round(amount*100/totalSplits))/100.0;
                for (Split split : splits) {
                    split.setAmount(splitAmount);
                }
                splits.get(0).setAmount(splitAmount + (amount - splitAmount*totalSplits));
                return new EqualExpense(amount, paidBy, splits, expenseMetadata);
            default:
                return null;
        }
    }
}