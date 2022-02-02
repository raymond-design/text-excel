
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
        isFormulaCell=true;
    }
    public double EvalFormula(Cell[][] sheet)
    {
        int i1 = realString.indexOf("(");
        int i2 = realString.indexOf(")");
        String formula = realString;
        String s2 = formula.substring(i1+1,i2).trim();
        if(s2.length()>3) 
        {
        if(s2.substring(0,3).toLowerCase().equals("sum"))
        {
            doubleValue = SumFormula(s2, sheet);
            return doubleValue;
        }
        if(s2.substring(0,3).toLowerCase().equals("avg"))
        {
           doubleValue = AvrFormula(s2, sheet);
           return doubleValue;
        }
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
    // System.out.println(" arrstring length " + arrString.length);
     for (int i = 0; i< arrString.length; i++)
   //  String a: arrString)
     //   for (String a: arrString)
        {
            op = isOperation(arrString[i]);
           // System.out.println("oper a   " + arrString[i] + "  " +op);
           if (op ==0 )
           {
              // operationList[numOperation] = 
              if(isCell(arrString[i]))
            {
                SpreadsheetLocation cell = new SpreadsheetLocation(arrString[i]);
               // valueList.add(((RealCell)(sheet[cell.getRow()][cell.getCol()])).getDoubleValue());
                double tmp = ((RealCell)(sheet[cell.getRow()][cell.getCol()])).getDoubleValue();
                valueList.add(tmp);
             //    System.out.println("oper a   " + arrString[i] + "  " +op + "  "+tmp);
                

            }
            else
              valueList.add(Double.parseDouble(arrString[i]));
              
              numValues++;
            }
            else
            {
               operationList.add(op);
           //     System.out.println("numvalues     " + numValues);
            }
        }
         //System.out.println("arr ln  " + numValues);
     //   double first = 
        doubleValue = (double)(valueList.get(0));
        //System.out.println("double value1 " + doubleValue);
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
      //      System.out.println("double value " + doubleValue );
            return doubleValue;
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
           int column = Character.toUpperCase(g.charAt(0)) - 'A';
           return column <=11 && column >=0;
           //return g.matches("[a-zA-Z]+");
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
     
     public double SumFormula(String s2,Cell[][] sheet)
     {
        String [] arrString = s2.split(" ");
        String[] s3 = arrString[1].split("-");
        System.out.println(" location " + s3[0] + "  " + s3[1]);
        SpreadsheetLocation sumLocation = new SpreadsheetLocation(s3[0]);
        SpreadsheetLocation sumLocation2 = new SpreadsheetLocation(s3[1]);
        int row1=sumLocation.getRow();
        
        int row2=sumLocation2.getRow();
        int col1=sumLocation.getCol();
        int col2=sumLocation2.getCol();
         System.out.println(" location ij " + row1 + "  " + col1 + " " + row1 + " " + col2);
        double sum=0.0;
        for(int i=row1; i <= row2; i++){
          for(int j=col1; j <= col2; j++)
          {
              sum+=((RealCell)sheet[i][j]).getDoubleValue();
              System.out.println(" locaton sum item " + ((RealCell)sheet[i][j]).getDoubleValue());
            }
        }
        System.out.println("sum= " + sum);
        return sum;
    }
    public double AvrFormula(String s2,Cell[][] sheet)
     {
        String [] arrString = s2.split(" ");
        String[] s3 = arrString[1].split("-");
        System.out.println(" avg location " + s3[0] + "  " + s3[1]);
        SpreadsheetLocation sumLocation = new SpreadsheetLocation(s3[0]);
        SpreadsheetLocation sumLocation2 = new SpreadsheetLocation(s3[1]);
        int row1=sumLocation.getRow();
        
        int row2=sumLocation2.getRow();
        int col1=sumLocation.getCol();
        int col2=sumLocation2.getCol();
         System.out.println(" avg location ij " + row1 + "  " + col1 + " " + row1 + " " + col2);
        double sum=0.0;
        int count=0;
        for(int i=row1; i <= row2; i++){
          for(int j=col1; j <= col2; j++)
          {
              sum+=((RealCell)sheet[i][j]).getDoubleValue();
              System.out.println(" locaton sum item " + ((RealCell)sheet[i][j]).getDoubleValue());
              count++;
            }
        }
        System.out.println("sum= " + sum);
        return sum/count;
    }
     
     
}

