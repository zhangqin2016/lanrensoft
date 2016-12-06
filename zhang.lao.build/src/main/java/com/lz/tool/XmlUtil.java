package com.lz.tool;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

import java.io.File;
import java.io.IOException;

public class XmlUtil {

	public static void writeToXml(Object model,String src) throws IOException{
		XStream xstream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("-_", "_")));
		xstream.processAnnotations(model.getClass());// 如果没有这句，xml中的根元素会是<包.类名>；或者说：注解根本就没生效，所以的元素名就是类的属性
		String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + xstream.toXML(model);
		FileTool.write(src, xmlString);
	}
	
	public static String writeToXml(Object model) throws IOException{
		XStream xstream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("-_", "_")));
		xstream.processAnnotations(model.getClass());// 如果没有这句，xml中的根元素会是<包.类名>；或者说：注解根本就没生效，所以的元素名就是类的属性
		String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + xstream.toXML(model);
		return xmlString;
	}
	
	public static Object readXmlToModel(Object model,String src){
		XStream xstream = new XStream(new DomDriver("utf-8"));
		xstream.processAnnotations(model.getClass());
		return xstream.fromXML(new File(src));
	}
	
	public static Object readXmlToModel(Object model,File file){
		XStream xstream = new XStream(new DomDriver("utf-8"));
		xstream.processAnnotations(model.getClass());
		return xstream.fromXML(file);
	}
}
