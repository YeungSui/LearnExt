package test;

import java.io.File;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.Writer;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.info.market.model.UserDetails;
import com.info.market.service.*;

import model.Product;
import freemarker.FtlTemplateMaker;

public class TestCases {
	private String testFtlDirName = "ftl";
	private String testHtmlDirName = "html";
	// 如果目录ftl不存在则新建目录
	public TestCases() {
		existOrCreateDir(testFtlDirName);
		existOrCreateDir(testHtmlDirName);
	}
	// 测试hibernate保存对象
	public void testSaveObj() {
		UserDetails user1 = new UserDetails();
		Scanner scan = new Scanner(System.in);
		UserDetailsService uds = new UserDetailsService();
		for (int i = 0; i < 3; i++) {
			System.out.print("Enter user name: ");
			user1.setUname(scan.nextLine().trim());
			System.out.print("Enter user description: ");
			user1.setUdescription(scan.nextLine().trim());
			uds.addUser(user1);
		}
		scan.close();
	}
	// 测试Hibernate获取模型数据
	public void testGetObj() {
		List<UserDetails> users = null;
		UserDetailsService uds = new UserDetailsService();
		users = uds.getUserList();
		for (UserDetails user:users){
			System.out.println("User ID: "+user.getUid());
			System.out.println("User Name: "+user.getUname());
			System.out.println("User Description: "+user.getUdescription());
		}
	}
	public void testProduct() {
		String templateName = "listProducts";
		String htmlName = getPathName(testHtmlDirName, templateName, "html");
		String ftlName = templateName;
		
		FtlTemplateMaker ftm = new FtlTemplateMaker();
		
		List products = new ArrayList<Product>();
		Product wastons = new Product();
		wastons.setName("Wastons Soda Water");
		wastons.setDescription("The best Soda Water.");
		wastons.setPrice(3.5);
		wastons.setProducer("Wastons");
		wastons.setProducedDate(new Date());
		Product cokeCola = new Product();
		cokeCola.setName("Coke Cola Zero");
		cokeCola.setDescription("Coke with Lower heat and better taste");
		cokeCola.setPrice(3.2);
		cokeCola.setProducer("Coke Cola");
		cokeCola.setProducedDate(new Date());
		Product cEstbon = new Product();
		cEstbon.setName("C'estbon Pure Water");
		cEstbon.setDescription("Pure water");
		cEstbon.setPrice(1.8);
		cEstbon.setProducer("C'estbon");
		cEstbon.setProducedDate(new Date());
		
		products.add(wastons);
		products.add(cokeCola);
		products.add(cEstbon);
		Map root = new HashMap();
		root.put("products", products);
		
		Writer out = getWriter(htmlName);
		if (out != null) {
			ftm.printTemplate(ftlName, root, out);
			try {
				out.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		else {
			System.err.println("cannot create output writer");
		}
	}
	
	private Writer getWriter(String fileName) {
		File file = new File(fileName);
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch(IOException e) {
				System.err.println("cannot create file: "+fileName);
				e.printStackTrace();
			}
		}
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			return new OutputStreamWriter(fos);
		} catch(FileNotFoundException e) {
			System.err.println("cannot find file while creating FileOutputStream");
			e.printStackTrace();
		}
		return null;
	}
	private String getPathName(String dir, String name, String suffix) {
		String suffixSeperator = ".";
		return dir+"\\"+name+suffixSeperator+suffix;
	}
	private void existOrCreateDir(String dirName) {
		File file = new File(dirName);
		if(!file.exists()) {
			file.mkdir();
		}
	}
}
