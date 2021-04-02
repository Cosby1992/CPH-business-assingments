package main.usercode.valueconstraints.date;

import main.generated.valuedomains.Date;

/**
 * This class is the implementation class for the Date constraint validDate
 * No description given
 */
public class ValidDate
{



    /**
     * Checks the validDate constraint for the Date value domain.
     * No description given
     * @param date  The instance value to be checked
     * @return      the reason the constraint is violated, or <tt>null</tt> if
     *              the constraint is not violated
     */
    public static String checkValidDate(Date date)
    {
        // Implementation of constraint validDate
        // WARNING : Any code outside the following begin and end tags
        // will be lost when re-generation occurs.
        
        // EDMA_non-generated_code_begin

        int day = date.day().value();
        if (day <= 28)
            return null;
        switch (date.month().value()) {
        case 2:
            if (day > 29)
                return "February can not have more than 29 days";
            // day == 29
            int year = date.year().value();
            if (year % 4 == 0 && (!(year % 100 == 0) || year % 400 == 0))
                return null;
            return Integer.toString(year) + " is not a leap year, so February can not have 29 days";
        case 4:
        case 6:
        case 9:
        case 11:
            if (day <= 30)
                return null;
            return "April, June, September and November can not have more than 30 days";
        default:
            return null;
        }

        // EDMA_non-generated_code_end
    }


}
