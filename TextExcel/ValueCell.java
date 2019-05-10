
/**
 * Write a description of class RealCell here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ValueCell extends RealCell
{
    // instance variables - replace the example below with your own
   // public String realString;
    //public double doubleValue;
    /**
     * Constructor for objects of class RealCell
     */
    public ValueCell(String realString0)
    {
        super(realString0);
        realString=realString0;
        doubleValue = Double.parseDouble(realString);
    }
    public String abbreviatedCellText() // text for spreadsheet cell display, must be exactly length 10
    {
    double x = doubleValue;
        String y = "" + x;
        y += "          ";
       // if(val1.length()>=10)
        return y.substring(0,10);
    }
    public String fullCellText() // text for individual cell inspection, not truncated or padded
    {
        return realString;
       }
    public double getDoubleValue()
    {
        return doubleValue;
       }
}
