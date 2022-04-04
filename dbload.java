
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

//dbload class
public class dbload {

   static final int sNameMaxLength = 100;
   
   //page class to hold pages
    static class page {
       ArrayList<ArrayList<rec>> lstPage = new ArrayList<ArrayList<rec>>();
   }

   //record class to hold records
   static class rec {
   
      String personName;
      String birthDate;
      String birthPlaceLabel;
      String deathDate;
      String fieldLabel;
      String genreLabel;
      String instrumentalLabel;
      String nationalityLabel;
      String thumbnailLabel;
      int wikiPageID;
      String description;
   
   
      int ID;
      String Date_Time;
      int Year;
      String Month;
      int mDate;
      String Day;
      int Time;
      int SensorID;
      String SensorName;
      String SDT_Name;
      int HourlyCounts;
 }

//InitaliseOutputStream. File created is heap.(pagesize).
public static DataOutputStream GenerateOutputStream(int pageSize) throws FileNotFoundException {
    DataOutputStream oStream = new DataOutputStream(new FileOutputStream("heap." + pageSize));
    return oStream;
 }

 //This method will read data from the .csv file and then use CSVReader to splits into array with values.
 //All strings will be converted to bytes and written to file through DataOutputStream
 //Record size = Total size of all the fields.
 //All records are stored in a page until no more record can fit into the page.
 public static void CreateHeapFile(int pagesize, String datafile){
   File file = new File("heap" + "." + pagesize);
   int pageNum = 1;

   String line = "";  
   String splitBy = ",";  
   try   
   {  
   //parsing a CSV file into BufferedReader class constructor  
   BufferedReader br = new BufferedReader(new FileReader(datafile));  
   DataOutputStream objStream = GenerateOutputStream(pagesize);

   String headerLine = br.readLine();
   page objPage = new page();
   objPage.lstPage.add(new ArrayList<rec>());
   rec objRow = null;
   int intTotalRecordSize= 0;
   int intTotalRowCount = 0;
   int intPageNo = 0;

   while ((line = br.readLine()) != null)   //returns a Boolean value  
   {  
   
   objRow = new rec();

   int personNameLength;
   int birthDateLength;
   int birthPlaceLabelLength;
   int deathDateLength;
   int fieldLabelLength;
   int genreLabelLength;
   int instrumentalLabelLength;
   int nationalityLabelLength;
   int thumbnailLabelLength;
   int wikiPageIDLength;
   int descriptionLength;
   
   
   int tmpRecordSize = 0;
   int maxLength = 0;
   String strDateTime="";
   String strSDTNameValue="";

   String[] ArrPC = line.split(splitBy);
   
      // Add new field SDT_Name.
      //  strSDTNameValue = ArrPC[7] + "_" + ArrPC[1];
      //  byte[] objtmpByte = strSDTNameValue.getBytes("UTF-8");

      //  byte[] tmpSDTByte = Arrays.copyOf(objtmpByte, SDTNameMaxLength);
      //  objStream.write(tmpSDTByte);

      //  objRow.SDT_Name = strSDTNameValue;
      //  tmpRecordSize += tmpSDTByte.length;
    
     for (int x=0; x < ArrPC.length; x++){
                       
                if (x == 0) 
                {
                  
                  byte[] objByte = ArrPC[x].getBytes("UTF-8");
                  byte[] tmpByte = Arrays.copyOf(objByte, sNameMaxLength);
                  objStream.write(tmpByte);
                  personNameLength = tmpByte.length;   
                  tmpRecordSize += personNameLength;
                  objRow.personName = ArrPC[x];
                }
                else if (x == 1) {
                  byte[] objByte = ArrPC[x].getBytes("UTF-8");
                  byte[] tmpByte = Arrays.copyOf(objByte, sNameMaxLength);
                  objStream.write(tmpByte);
                  birthDateLength = tmpByte.length;   
                  tmpRecordSize += birthDateLength;
                  objRow.birthDate = ArrPC[x];
               }
                else if (x == 2) {
                  byte[] objByte = ArrPC[x].getBytes("UTF-8");
                  byte[] tmpByte = Arrays.copyOf(objByte, sNameMaxLength);
                  objStream.write(tmpByte);
                  birthPlaceLabelLength = tmpByte.length;   
                  tmpRecordSize += birthPlaceLabelLength;
                  objRow.birthPlaceLabel = ArrPC[x];
               }
               else if (x == 3) {
                  byte[] objByte = ArrPC[x].getBytes("UTF-8");
                  byte[] tmpByte = Arrays.copyOf(objByte, sNameMaxLength);
                  objStream.write(tmpByte);
                  deathDateLength = tmpByte.length;   
                  tmpRecordSize += deathDateLength;
                  objRow.deathDate = ArrPC[x];
               }
               
              else if (x == 4) {
                  byte[] objByte = ArrPC[x].getBytes("UTF-8");
                  byte[] tmpByte = Arrays.copyOf(objByte, sNameMaxLength);
                  objStream.write(tmpByte);
                  fieldLabelLength = tmpByte.length;   
                  tmpRecordSize += fieldLabelLength;
                  objRow.fieldLabel = ArrPC[x];
               }
               else if (x == 5) {
                  byte[] objByte = ArrPC[x].getBytes("UTF-8");
                  byte[] tmpByte = Arrays.copyOf(objByte, sNameMaxLength);
                  objStream.write(tmpByte);
                  genreLabelLength = tmpByte.length;   
                  tmpRecordSize += genreLabelLength;
                  objRow.genreLabel = ArrPC[x];
                  }
                  else if (x == 6) {
                     byte[] objByte = ArrPC[x].getBytes("UTF-8");
                     byte[] tmpByte = Arrays.copyOf(objByte, sNameMaxLength);
                     objStream.write(tmpByte);
                     instrumentalLabelLength = tmpByte.length;   
                     tmpRecordSize += instrumentalLabelLength;
                     objRow.instrumentalLabel = ArrPC[x];
                     }
                  else if (x == 7) {
                     byte[] objByte = ArrPC[x].getBytes("UTF-8");
                     byte[] tmpByte = Arrays.copyOf(objByte, sNameMaxLength);
                     objStream.write(tmpByte);
                     nationalityLabelLength = tmpByte.length;   
                     tmpRecordSize += nationalityLabelLength;
                     objRow.nationalityLabel = ArrPC[x];
                     }
                  else if (x == 8) {
                     byte[] objByte = ArrPC[x].getBytes("UTF-8");
                     byte[] tmpByte = Arrays.copyOf(objByte, sNameMaxLength);
                     objStream.write(tmpByte);
                     thumbnailLabelLength = tmpByte.length;   
                     tmpRecordSize += thumbnailLabelLength;
                     objRow.thumbnailLabel = ArrPC[x];
                     }
                  // else if (x == 9) {
                  //    int wikipageID = Integer.parseInt(ArrPC[x]);
                  //    byte[] objByte =  intToByteArray(wikipageID);
                  //    byte[] tmpByte = Arrays.copyOf(objByte, sNameMaxLength);
                  //    objStream.write(tmpByte);
                  //    wikiPageIDLength = tmpByte.length;                     
                  //    tmpRecordSize += wikiPageIDLength;
                  //    objRow.wikiPageID = Integer.parseInt(ArrPC[x]);
                  //    }
                  else if (x == 10) {
                     byte[] objByte = ArrPC[x].getBytes("UTF-8");
                     byte[] tmpByte = Arrays.copyOf(objByte, sNameMaxLength);
                     objStream.write(tmpByte);
                        descriptionLength = tmpByte.length;   
                        tmpRecordSize += descriptionLength;
                        objRow.description = ArrPC[x];
                        }
            
                   
             }
              
                 if((tmpRecordSize + intTotalRecordSize) < pagesize){
                    intTotalRowCount++;
                    intTotalRecordSize += tmpRecordSize;
                    objPage.lstPage.get(intPageNo).add(objRow);
                                    
                  }
                else{
                   intPageNo++;
                    objPage.lstPage.add(new ArrayList<rec>());
                    objPage.lstPage.get(intPageNo).add(objRow);                   
                    intTotalRecordSize = tmpRecordSize;
                  }
  
   }  

       //Print out the total no of pages and total no of records
    System.out.println("Total number of pages: " + objPage.lstPage.size());
    int intTotalRows=0;
    for(int i=0; i<objPage.lstPage.size(); i++) {
       for(int j=0; j<objPage.lstPage.get(i).size(); j++) {
         intTotalRows++;
       }
    }
    System.out.println("Total number of records: " + intTotalRows);

   }   
   catch (IOException e)   
   {  
   e.printStackTrace();  
   }  
 }
 
private static byte[] intToByteArray(final int i ) throws IOException {      
   byte[] bytes = java.nio.ByteBuffer.allocate(4).putInt(i).array();

   return bytes;
}

 //Main method
 //Calculates the time taken to create heap file in ms.
 public static void main(String[] args) {
    long intStartTime = System.nanoTime();
    try {
   
        int pagesize = 0;
        String datafile = null;
        try{
            pagesize = Integer.parseInt(args[1]);
            datafile = args[2];    
        }
        catch(Exception e){
            System.out.println("Invalid arguments. Please try again");
            System.exit(0);
        }
       
        CreateHeapFile(pagesize,datafile);
        long intEndTime = System.nanoTime();
        long intTotalTime = (intEndTime - intStartTime) / 1000000;
        System.out.println("Heap file creation completed in: " + intTotalTime + "ms");

    } catch (Exception e) {
       System.err.println(e.getMessage());
    }
   
 }

 
}