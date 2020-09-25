package org.javaclass2020;

public class TaxBracket
{
    private String grade;
    private String bracket;
    private double taxPercent;
    private double description;

    public String getGrade()
    {
        return grade;
    }

    public void setGrade(String grade)
    {
        this.grade = grade;
    }

    public String getBracket()
    {
        return bracket;
    }

    public void setBracket(String bracket)
    {
        this.bracket = bracket;
    }

    public double getTaxPercent()
    {
        return taxPercent;
    }

    public void setTaxPercent(double taxPercent)
    {
        this.taxPercent = taxPercent;
    }
}
