 

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
    private int row;
    private int column;
    public SpreadsheetLocation(String cellName)
    {
       //split(cellName);
       System.out.println("column row " + cellName);
       column = Character.toUpperCase(cellName.charAt(0)) - 'A';
       String b = cellName.substring(1);
      // System.out.println(b);
       row = Integer.valueOf(b) -1;
       //row = Integer.parseInt(cellName.substring(1)) - 1;
      // System.out.println("column row " + " " + column + " " + row);
    }
    
    @Override
    public int getRow()
    {
        return row;
    }

    @Override
    public int getCol()
    {
        return column;
    }
    
    public void split(String cellName)
    {
      /** cellName=cellName.trim();
       int rowValue = Integer.parseInt(cellName.substring(1));
       String colValue = cellName.substring(0,1).toLowerCase();
       final String alphabet = "abcdefghijklmnopqrstuvwxyz";
       row = rowValue-1;
       column = 0;
       for(int i=0; i<24; i++)
       {
           if(alphabet.substring(i,i+1).equals(colValue))
           {
               column=i;
            }
        }
        **/
    }

}
