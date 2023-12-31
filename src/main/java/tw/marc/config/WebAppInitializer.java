package tw.marc.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import jakarta.servlet.Filter;
import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletRegistration;

//相當於web.xml的java程式組態的類別
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		registration.setMultipartConfig(new MultipartConfigElement("/home/yiiiiiach/"));
	}
	//相當於註冊beans.config.xml的java程式組態的類別
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootAppConfig.class};
	}

	//相當於註冊mvc-servlet.xml的java程式組態的類別
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {WebAppConfig.class};
		//return null; 
	}

	//設定DispatcherServlet接收請求的servlet-mapping url-pattern
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
		//return null;
	}

	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter cef = new CharacterEncodingFilter("UTF-8",true);
		return new Filter[] {cef};
	}	

}
