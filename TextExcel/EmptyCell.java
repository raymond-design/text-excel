
/**
 * An empty cell has a full text and a truncated text
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EmptyCell implements Cell
{
    /**
     * Constructor for objects of class EmptyCell
     */
    public EmptyCell()
    {
        
    }
    
    public String abbreviatedCellText() // text for spreadsheet cell display, must be exactly length 10
    {
    return "          ";
    }
	public String fullCellText() // text for individual cell inspection, not truncated or padded
	{
	return "";   
	}
}
