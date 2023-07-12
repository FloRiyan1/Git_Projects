package woFi.srctest;

import static org.junit.Assert.*;

import org.junit.Test;
import java.io.File;
import java.io.IOException;

import woFi.service.FileAccesService;
import java.util.*;

public class FileAccesServiceTest
{
	private List<File> files = new ArrayList<>();
	
	@Test
	public void test() throws IOException
	{
		FileAccesService service = new FileAccesService();
		
		File file = new File("D:\\Test1\\test.txt");

		if(!file.exists())
		{
			file.createNewFile();
		}
		
		files = service.startWurm(file.getAbsolutePath());
	}

}
