package com.fly.demo.concurrenthashmap;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DecoratorPattern {

	public static String replaceHtmlTag(String str, String tag, String tagAttrib, String startTag, String endTag) {
		String regxpForTag = "<\\s*" + tag + "\\s+([^>]*)\\s*";
		String regxpForTagAttrib = tagAttrib + "=\\s*\"([^\"]+)\"";
		Pattern patternForTag = Pattern.compile(regxpForTag, Pattern.CASE_INSENSITIVE);
		Pattern patternForAttrib = Pattern.compile(regxpForTagAttrib, Pattern.CASE_INSENSITIVE);
		Matcher matcherForTag = patternForTag.matcher(str);
		StringBuffer sb = new StringBuffer();
		while (matcherForTag.find()) {
			StringBuffer sbreplace = new StringBuffer("<" + tag + " ");
			Matcher matcherForAttrib = patternForAttrib.matcher(matcherForTag.group(1));
			if (matcherForAttrib.find()) {
				String attributeStr = matcherForAttrib.group(1);
				System.out.println("==>"+attributeStr);
				matcherForAttrib.appendReplacement(sbreplace, startTag + attributeStr + endTag);
			}
			matcherForAttrib.appendTail(sbreplace);
			matcherForTag.appendReplacement(sb, sbreplace.toString());
		}
		matcherForTag.appendTail(sb);
		return sb.toString();
	}

	public static void main(String[] args) {
		StringBuffer content = new StringBuffer();
		content.append(
				"哈哈哈<ul class=\"imgBox\"><li><img id=\"160424\" src=\"https://timgsa.baidu.com/timg?image&amp;quality=80&amp;s06158&amp;di=70eb73b3604dd957b642ea2e0a7c1108&amp;imgtype=0&amp;src=http%3A%2F%2Fimg4q.duitang.com%2Fuploads%2Fitem%2F201501%2F27%2F201eg\" class=\"src_class\"></li>");
		content.append(
				"<li>啦啦啦<img id=\"150628\" src=\"uploads/allimg/150628/1-15062Q12247.jpg\" class=\"src_class\"></li></ul>");
		//content=new StringBuffer();
		//content.append("<a >sdsdfs啦啦啦啦</a>");
		System.out.println("原始字符串为:" + content.toString());
		String newStr = replaceHtmlTag(content.toString(), "img", "src", "src=\"http://127.0.0.1:8080/", "\"");
		System.out.println("       替换后为:" + newStr);
		
		System.out.println("=="+UUID.randomUUID().toString());
	}
}