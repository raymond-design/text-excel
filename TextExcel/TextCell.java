
/**
 * Write a description of class TextCell here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextCell implements Cell
{
    // instance variables - replace the example below with your own
    private int x;
    private String s;

    /**
     * Constructor for objects of class TextCell
     */
    public TextCell()
    {
        s = "";// initialise instance variables
        x = 0;
    }
    public TextCell(String oof)
    {
        s = oof;// initialise instance variables
    
    }
        public String abbreviatedCellText()
    {
     //   if(s.length()>=10)
     //   return(s.replaceAll("\"","").substring(0,10));
     //   else
     //   {
            String s1 = s + "          ";
            //System.out.println("ggg" + s+"k");
            return(s1.replaceAll("\"","").substring(0,10));
       // }
    }// text for spreadsheet cell display, must be exactly length 10
	public String fullCellText()
	{
	    return s;
	}
	   
	public  String format(String s)
    {
       return String.format(String.format("%%-%d.%ds", 10, 10),  s);
    }

}
