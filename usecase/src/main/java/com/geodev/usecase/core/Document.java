package com.geodev.usecase.core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/**
 *   测试用例文档
 * @author geodev
 *
 */
public class Document {

	/**
	 * 测试用例文档标题
	 */
	private String title;
	
	/**
	 * 测试用例文档相对路径
	 */
	private String realPath;
	
	/**
	 * 测试用例文档模板
	 */
	private String template;

	/**
	 * 测试用例列表
	 */
	private List<UseCase> cases = new ArrayList<>();
	
	public Document() {}
	
	public Document(String title, String realPath, List<UseCase> cases) {
		this.title = title;
		this.realPath = realPath;
		this.cases = cases;
	}
	
	public Document(String title, String realPath, String template, List<UseCase> cases) {
		this(title, realPath, cases);
		this.cases = cases;
	}

	/**
	 * 添加测试用例
	 * @param useCase 测试用例
	 */
	public void addUseCase(UseCase useCase) {
		if(cases == null){
			cases = new ArrayList<>();
        }
		cases.add(useCase);
	}

	/**
	 * 生成测试用例文档
	 */
	public void generate() {
		if(cases == null || cases.size() <= 0){
			throw new RuntimeException("The test use case data is null.");
		}
		
		Map<String, List<UseCase>> dataModel = new HashMap<>();
		dataModel.put("cases", cases);
		String templateName = getTemplate();
		String filePath = getPath();
		
		Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
		configuration.setClassForTemplateLoading(Document.class.getCanonicalName().getClass(), "/templates");
        configuration.setDefaultEncoding("utf-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        
        try {
            Template template = configuration.getTemplate(templateName);
            File file = new File(filePath);
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
            template.process(dataModel, out);
            out.flush();
            out.close();
            System.out.println("Execute success.");
			System.out.println("The document path: "+ getPath());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
	}
	
	public String getTitle() {
		if(title == null || ("").equals(title)) {
			title = "TCD" + String.valueOf(System.currentTimeMillis());
		}
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTemplate() {
		if(template == null || ("").equals(template)) {
			template = "use_case.ftl";
		}
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getRealPath() {
		if(realPath == null || ("").equals(realPath)) {
			String classPath = Document.class.getClassLoader().getResource("").getFile();
	        File file = new File(classPath);
	        realPath = file.getParentFile().getAbsolutePath(); 
	        try {
	        	realPath = URLDecoder.decode(realPath, "utf-8");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		}
		return realPath;
	}
	
	public void setRealPath(String realPath) {
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		this.realPath = realPath;
	}

	public String getPath() {
		return getRealPath() + File.separator + getTitle() + ".doc";
	}
	
	public List<UseCase> getCases() {
		return cases;
	}

	public void setCases(List<UseCase> cases) {
		this.cases = cases;
	}

}
