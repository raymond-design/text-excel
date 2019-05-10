
/**
 * Write a description of class PercentCell here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PercentCell extends RealCell
{
    /**
     * Constructor for objects of class PercentCell
     */
    //private double value;
   // private String val;
    public PercentCell(String val)
    {
        super(val);
       // System.out.println("perccell: " + val);
       
       // realString = val;
       //realString = val;
        String val1 = val.substring(0,val.indexOf("%"));
        doubleValue = Double.parseDouble(val1);   
    }
    
    public String abbreviatedCellText()
    {
        int x = (int)doubleValue;
        String y = "" + x;
        y += "%";
        y += "          ";
       // if(val1.length()>=10)
        return y.substring(0,10);
    }// text for spreadsheet cell display, must be exactly length 10
	public String fullCellText()
	{
	    //s.replaceAll("\"","");
	    //System.out.println("kk" + s);
	    //return percString(2);
	    return (doubleValue/100) + "";
}
public double getDoubleValue()
    {
        return (doubleValue/100) ;
       }
}
