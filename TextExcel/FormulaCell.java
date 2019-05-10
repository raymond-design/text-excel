
/**
 * Write a description of class FormulaCell here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class FormulaCell extends RealCell
{
    // instance variables - replace the example below with your own
    //public double doubleValue;
    public String realString;
   // double [] valueList;
   // int [] operList; ''Array
     ArrayList valueList;
    ArrayList operationList;
   // List<Double> valueList;
  //  List<Integer> operationList;

    /**
     * Constructor for objects of class FormulaCell
     */
    public FormulaCell(String formula, Cell[][] sheet)
    {
        // initialise instance variables
        super(formula, sheet);
        realString = formula;
        int i1 = realString.indexOf("(");
        int i2 = realString.indexOf(")");
        String s2 = formula.substring(i1+1,i2).trim();
        if(s2.toLowerCase().equals("sum"))
        {
            
        }
        if(s2.toLowerCase().equals("avg"))
        {
            
        }
        String [] arrString = s2.split(" ");
        for (int i=0; i<arrString.length; i++)
        System.out.println(arrString[i]);
            valueList = new ArrayList<Double>();
            int op;
            int numValues = 0;
    operationList =  new ArrayList<Integer>();
  // operationList = new int[20];
  // valueList = new double[20]; // <Double>();
     System.out.println(" arrstring length " + arrString.length);
     for (int i = 0; i< arrString.length; i++)
   //  String a: arrString)
     //   for (String a: arrString)
        {
            op = isOperation(arrString[i]);
            System.out.println("oper a   " + arrString[i] + "  " +op);
           if (op ==0 )
           {
              // operationList[numOperation] = 
              if(isCell(arrString[i]))
            {
                SpreadsheetLocation cell = new SpreadsheetLocation(arrString[i]);
               // valueList.add(((RealCell)(sheet[cell.getRow()][cell.getCol()])).getDoubleValue());
                double tmp = ((RealCell)(sheet[cell.getRow()][cell.getCol()])).getDoubleValue();
                valueList.add(tmp);
                 System.out.println("oper a   " + arrString[i] + "  " +op + "  "+tmp);
                

            }
            else
              valueList.add(Double.parseDouble(arrString[i]));
              
              numValues++;
            }
            else
            {
               operationList.add(op);
                System.out.println("numvalues     " + numValues);
            }
        }
         System.out.println("arr ln  " + numValues);
     //   double first = 
        doubleValue = (double)(valueList.get(0));
        System.out.println("double value1 " + doubleValue);
        for (int i = 1; i< numValues; i++)
        {
            int oper = (int)(operationList.get(i-1));
            if(oper == 1)
               doubleValue = doubleValue + (double)valueList.get(i);
            else if (oper == 2)
               doubleValue = doubleValue - (double)valueList.get(i);
            else if (oper == 3)
               doubleValue = doubleValue * (double)valueList.get(i);
            else
               doubleValue = doubleValue / (double)valueList.get(i);
             //  System.out.println("double value " + doubleValue + " " + (double)valueList.get(i));
            }
            System.out.println("double value " + doubleValue );
    }

    public int isOperation(String a)
    {
        if(a.equals("+"))
            return 1;
        if(a.equals("-"))
            return 2;
        if(a.equals("*"))
            return 3;
        if(a.equals("/"))
            return 4;
            return 0;
        }
        public boolean isCell(String g)
        {
            return g.matches("[a-zA-Z]+");
        }
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
public String abbreviatedCellText() // text for spreadsheet cell display, must be exactly length 10
    {
    double x = doubleValue;
        String y = Double.toString(x);
        y += "          ";
       // if(val1.length()>=10)
        return y.substring(0,10);
    }
    public String fullCellText() // text for individual cell inspection, not truncated or padded
    {
        return realString; // realString;
       }
       
    public double getDoubleValue()
    {
        return doubleValue;
     }
}
