package freemarker;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class FtlTemplateMaker {
	Configuration cfg;
	
	public FtlTemplateMaker() {
		setConfig();
	}
	public FtlTemplateMaker(String dirName) {
		setConfig(dirName);
	}
	
	public void setConfig() {
		String dirName = "ftl";
		setConfig(dirName);
	}
	public void setConfig(String dirName) {
		cfg = new Configuration();
		File dir = new File(dirName);
		try{
			cfg.setDirectoryForTemplateLoading(dir);
		} catch(IOException e) {
			e.printStackTrace();
		}
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
	}
	
	public void printTemplate(String fileName, Map root, Writer out) {
		if (fileName.indexOf('.') < 0 || !fileName.substring(fileName.lastIndexOf('.')+1).equals("ftl")) {
			fileName += ".ftl";
		}
		Template tpl;
		try {
			System.out.println("good");
			tpl = cfg.getTemplate(fileName);
			
			tpl.process(root, out);
		} catch(Exception e) {
			System.err.println("Something goes wrong with the ftl file: "+fileName+"!");
			e.printStackTrace();
		}
	}
}
