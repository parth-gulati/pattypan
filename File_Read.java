import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.*;

public class File_Read {

	
	public static void main(String[] args) {
		
		String location=new String("time");
		String time1=new String("00:00:00");
		String date1=new String("14/09/1998");
		
		try {
			File file = new File("E:\\code_stuff\\meeting.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				if(line.startsWith("Location:"))
				{
					location=line.substring("Location:".length());
				}
				
				if(line.startsWith("Time:"))
				{
					time1=line.substring("Time:".length());
				}
				
				if(line.startsWith("Date:"))
				{
					date1=line.substring("Date:".length());
				}
			}
			fileReader.close();
			System.out.println("Contents of file:");
			System.out.println(location);
			System.out.println(time1);
			System.out.println(date1);
			String datefinal = date1 + " " + time1;
			datefinal.trim();
			Time_zone_change.time_change(location, datefinal);
			
		} catch (IOException e) {
			e.printStackTrace();	
		}
	}

	}

