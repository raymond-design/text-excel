 

// Update this file with your own code.

public class Spreadsheet implements Grid
{
    private int rows = 20;
    private int columns = 12;
    Cell[][] spreadsheet;
    //SpreadsheetLocation lc;
    public Spreadsheet()
    {
        spreadsheet = new Cell[rows][columns];
        for(int i=0; i < rows; i++){
          for(int j=0; j < columns; j++){
              spreadsheet[i][j]=new EmptyCell();
            }
        }
    }
   // @Override
    public String processCommand(String command)
    {
        // TODO Auto-generated method stub
        command=command.trim();
        //command=command.toLowerCase();
        String []arr = command.split(" ");
        if(command.equals(""))
        {
        return "";
        }
        if(command.substring(0,2).equals("cl")||command.substring(0,2).equals("Cl")||command.substring(0,2).equals("cL")||(command.substring(0,2).equals("CL")))
        {
            //clear entire badboi
            if(command.length()==5)
            {
                for(int i=0; i < rows; i++){
                  for(int j=0; j < columns; j++){
                     spreadsheet[i][j]=new EmptyCell();
                  }
                }
                return getGridText();
            }
              //clear individual
              else if(command.length()>5)
              {
                  String clearCell = command.substring(6);
                  SpreadsheetLocation clearLocation = new SpreadsheetLocation(clearCell);
                  spreadsheet[clearLocation.getRow()][clearLocation.getCol()]=new EmptyCell();
                  return getGridText();
              }
          }
        if(command.indexOf("=")!=-1)
        {
            int firstBracket = command.indexOf("\"");
            //String assignText = command.substring(firstBracket+1,command.length()-1);
            if (firstBracket >=0)
            {
               String assignText = command.substring(firstBracket);
               System.out.println(" ssigned text " + assignText);
               String textValue = arr[0]; // command.substring(0,3);
               SpreadsheetLocation textLocation = new SpreadsheetLocation(textValue);
               spreadsheet[textLocation.getRow()][textLocation.getCol()]=new TextCell(assignText);
               return getGridText();
            }
            else  // not text cell
            {
                int idx = command.indexOf("=");
                if(command.indexOf("%")!=-1)
                {
                String s1 = command.substring(idx+1);
                
                String s2 = s1.trim();
                //System.out.println(idx + s1 + "  " + s2);
               
                String textValue = arr[0]; // command.substring(0,3);
                //System.out.println(textValue);
                SpreadsheetLocation textLocation = new SpreadsheetLocation(textValue);
                spreadsheet[textLocation.getRow()][textLocation.getCol()]=new PercentCell(s2);
            }
            else if(command.indexOf("(")== -1)
            {
                String s1 = command.substring(idx+1);
                
                String s2 = s1.trim();
                //System.out.println(idx + s1 + "  " + s2);
               //System.out.println(s2);
               
                String textValue = arr[0]; // command.substring(0,3);
                //System.out.println(textValue);
                SpreadsheetLocation textLocation = new SpreadsheetLocation(textValue);
                spreadsheet[textLocation.getRow()][textLocation.getCol()]=new RealCell(s2);
            }
            else  // formulae
            {
                String s1 = command.substring(idx+1);
                
                String s2 = s1.trim();
                //System.out.println(idx + s1 + "  " + s2);
               System.out.println(s2);
               
                String textValue = arr[0]; // command.substring(0,3);
                //System.out.println(textValue);
                SpreadsheetLocation textLocation = new SpreadsheetLocation(textValue);
                spreadsheet[textLocation.getRow()][textLocation.getCol()]=new FormulaCell(s2,spreadsheet);
                
            }
            
           return getGridText();
        }
    }
        else if((command.length()<=3)&&(Character.isLetter(command.charAt(0))))
           {
             SpreadsheetLocation inspectLocation = new SpreadsheetLocation(command);
             return spreadsheet[inspectLocation.getRow()][inspectLocation.getCol()].fullCellText();  
            }
          return " ";
          
        
    }
/** public void swap(SpreadsheetLocation loc1, SpreadsheetLocation loc2)
 {
     Cell t = getCell(loc1);
     setCell(loc1,getCell(loc2));
     setCell(loc2,t);
    }
    public void setCell(Spreadsheet loc1,)
    **/
    @Override
    public int getRows()
    {
        // TODO Auto-generated method stub
        return rows;
    }

    @Override
    public int getCols()
    {
        // TODO Auto-generated method stub
        return columns;
    }

    @Override
    public Cell getCell(Location loc)
    {
        // TODO Auto-generated method stub
		return spreadsheet[loc.getRow()][loc.getCol()];
    }

    @Override
    public String getGridText()
    {
        String grid = "   |A         |B         |C         |D         |E         |F         |G         |H         |I         |J         |K         |L         |\n";
        //String newLine = "|          |          |          |          |          |          |          |          |          |          |          |          |\n";
        for(int i=0; i < rows; i++){
        //  String newLine = "   " + (i+1);
          String newLine = String.format("%-3d|", i + 1);
          for(int j=0; j < columns; j++){
           //   newLine = newLine + "|" + spreadsheet[i][j].abbreviatedCellText();
           newLine = newLine  + spreadsheet[i][j].abbreviatedCellText() +  "|";
            }
           grid = grid + newLine + "\n";
        }
              return grid;
    }
    
    public String format(String s)
    {
       return String.format(String.format("%%-%d.%ds", 10, 10),  s);
    } 
    }


