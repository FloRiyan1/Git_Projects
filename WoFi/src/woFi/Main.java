package woFi;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import woFi.service.FileAccesService;
import woFi.service.FileEncryptionService;

public class Main
{

	public static void main(String[] args)
	{
		FileEncryptionService encryptionService = new FileEncryptionService();
		
		FileAccesService accesService = new FileAccesService();
		
		try
		{
			accesService.reverseWurm("D:\\Test1", "Das_ist_ein_key_");
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
