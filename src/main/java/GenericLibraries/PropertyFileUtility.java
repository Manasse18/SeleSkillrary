package GenericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility 
{
	 Properties property;
	 /**
	  * this method is used to initialialize properties file
	  * @param filepath
	  */
	public void property_file_inilization(String filepath)
	{
		FileInputStream fis =null;
		try {
			 fis = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		 property= new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
		/**
		 * this method returns the data from properties file based on the key passes
		 * @param key
		 * @return
		 */
		
		public String fetchProperty(String key)
		{
			return property.getProperty(key);
		}
	

}
