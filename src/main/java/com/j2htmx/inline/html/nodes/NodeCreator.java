package com.j2htmx.inline.html.nodes;

import com.j2htmx.inline.html.custom.processor.CSSLoader;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class NodeCreator extends CSSLoader {
	String hxSwap = "";
	protected String Tag="";
	protected String misc="";
	protected String classStyle = "";
	protected String For = "";
	protected String content="";
	protected String hxOn = "";
	protected String placeholder="";
	protected String source = "";
	protected String layout="";
	protected String styleID="";
	protected String style="";
	protected String hxTrigger="";
	protected String hxInclude="";
	protected String href="";
	protected Object clientId = "";
	protected String hxGet = "";
	protected String onload = "";
	protected String hxVals = "";
	protected String hxTarget = "";
	protected String name = "";
	protected String width = "";
	protected String hxOutOfOrderSwap = "";
	protected String type = "";
	protected String height = "";
	protected String id = "";
	protected List<String> addedStyles = new ArrayList<>();

	@Override
	public int hashCode() {
		return clientId.hashCode();
	}

	public void setClientId(Object obj) {
		this.clientId = obj;
	}

	public void setHxGet(String url) {
		this.hxGet = " hx-get = "+url;
	}

	public void setSource(String url) {
		this.source = " src = "+url;
	}

	public void setHxOutOfOrderSwap() {
		this.hxOutOfOrderSwap= " hx-swap-oob = true";
	}

	public void setType(String type) {
		this.type = " type = "+type;
	}

	public void setHxInclude(String validName) {
		this.hxInclude =" hx-include= "+validName;
	}

	public void setName(String name) {
		this.name = " name= "+name+" ";
	}

	public void setHxTrigger(String triggerCondition) {
		this.hxTrigger = " hx-trigger = "+triggerCondition;
	}

	public void setOnload(String triggerCondition) {
		this.onload = " onload = "+triggerCondition;
	}


	public void setHxOn(String triggerCondition) {
		this.hxOn = " hx-on = "+triggerCondition;
	}

	public void setHxTarget(String target) {
		this.hxTarget = " hx-target = "+target;
	}

	public void setForId(String id) {
		this.For = " for = "+id;
	}
	public void setMisc(String misc) {
		this.misc = misc;
	}


	public void setHxVals(String target) {
		this.hxVals= " hx-vals = "+target;
	}

	public void setStyleViaString(String styleClass) {
		this.style=styleClass;
	}

	public void setPlaceholder(String placeholder) {
		this.hxTarget = " placeholder = "+placeholder;
	}

	public Object getClientId() {
		return this.clientId;
	}

	public String createPairNode(){
		if(Tag.equals("img")) {
			return "<"+this.Tag+style+" "+"src ="+href+"/>";
		}
		if(href.length()>0) {
			return "<"+this.Tag+hxGet+id+For+source+onload+misc+hxTarget+hxSwap+hxOn+hxOutOfOrderSwap+type+placeholder+hxTrigger+hxVals+hxInclude+style+" "+"href ="+href+">"+ this.content   + "</"+this.Tag+">";
		}
		return "<"+this.Tag+classStyle+name+hxOn+onload+misc+source+ hxSwap+For+style+hxOutOfOrderSwap+type+placeholder+id+width+height+hxGet+hxVals+hxTarget+hxInclude+hxTrigger+" >"+ this.content   + "</"+this.Tag+">";
	}
	public void setTag(String tag) {
			this.Tag=tag;
	}

	public void setContent(NodeCreator... nodeCreators){
		String node = "";
		for (NodeCreator nodeCreator : nodeCreators) {
			node = node.concat(nodeCreator.createPairNode());
		}
		this.content = node;
	}

	public void addContent(NodeCreator... nodeCreators){
		String node = "";
		for (NodeCreator nodeCreator : nodeCreators) {
			node = node.concat(nodeCreator.createPairNode());
		}
		this.content = this.content.concat(node);
	}


	public void addContent(String... nodeCreators){
		String node = "";
		for (String nodeCreator : nodeCreators) {
			node = node.concat(nodeCreator);
		}
		this.content = this.content.concat(node);
	}

	public void setContent(String content) {
		this.content=content;
	}

	public void addContent(String content) {
		this.content = this.content.concat(content);
	}

	public void setNodeLink(String href) {
		this.href=href;
	}
	public String getContent() {
		return content;
	}
	public void setStyle(String styleClass) {
		this.style=" style='"+getProperty(styleClass)+"' ";
		addedStyles.add(getProperty(styleClass));
	}

	public void setClass(String styleClass) {
		this.classStyle=" class= '"+styleClass+"' ";
	}

	public void addClass(String styleClass) {
		this.classStyle = this.classStyle.concat(" "+styleClass);
	}

	public void addStyle(String styleClass) {
		addedStyles.add(getProperty(styleClass));
		String styleAdded = addedStyles.stream().reduce("", (a,b)->a+" "+b);
		this.style=" style=' "+styleAdded+"' ";
	}


	public void setWidth(String width) {
		this.width=" width = ".concat(width);
	}
	public void setHeight(String height) {
		this.height=" width = ".concat(height);
	}
	public void setId(String id) {
		this.id = " id='"+id+"'";
	}
	public void setContentFromProperty(String property) {
		setContent(getProperty(property));
	}
	public void setHxSwap(String swap) {
		this.hxSwap = " hx-swap = " + swap;
	}



}
